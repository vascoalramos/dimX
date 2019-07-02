import java.io.File;
import org.stringtemplate.v4.*;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.ParserRuleContext;

/**
 * This class is responsible for generate the code in the defined output
 * language. It extends the GeneralBaseVisitor class, so it uses the software
 * pattern visitor. It uses a string template file, in order to convert our
 * languange statements in valid statements to the output language.
 */
public class DimXCompiler extends GeneralBaseVisitor<ST> {
    protected int varCount = 0;
    protected STGroup stg = null;
    protected String targetLang = "java";

    // SUPPORT FUNCTIONS

    /**
     * Checks if a string template file exists.
     * 
     * @param outputLang Name of the file.
     * @return true or false.
     */
    public boolean validTarget(String outputLang) {
        File stgFile = new File(outputLang + ".stg");
        return (stgFile.exists() && stgFile.isFile() && stgFile.canRead());
    }

    /**
     * Definition the output language.
     * 
     * @param outputLang Name of the output language.
     * @return always true
     */
    public boolean setTarget(String outputLang) {
        assert validTarget(outputLang);

        this.targetLang = outputLang;
        return true;
    }

    /**
     * Returns a new variable name to use in the output language.
     * 
     * @return A string representing a variable name.
     */
    public String newVar() {
        return "v" + varCount++;
    }

    // MAIN RULES

    /**
     * The first rule to visit in the syntatic tree. It starts the module and add
     * all the statements to the main function.
     */
    @Override
    public ST visitMain(GeneralParser.MainContext ctx) {
        assert (validTarget(this.targetLang)); // Check if we have a valid stgFile

        this.stg = new STGroupFile("java.stg");

        ST resultModule = this.stg.getInstanceOf("module"); // Final result
        resultModule.add("stat", visit(ctx.statList()));

        return resultModule;
    }

    /**
     * It visits all the present statements in the syntatic tree, and adds all
     * statements in a collection of statements.
     */
    @Override
    public ST visitStatList(GeneralParser.StatListContext ctx) {
        ST resultStats = this.stg.getInstanceOf("stats"); // Intermediate results of all stats

        for (GeneralParser.StatContext sc : ctx.stat()) {
            resultStats.add("stat", visit(sc));
        }

        return resultStats;
    }

    // PRINT RULES

    /**
     * This method generates the output code for printing to the console an
     * expression.
     */
    @Override
    public ST visitPrint(GeneralParser.PrintContext ctx) {
        ST printResult = this.stg.getInstanceOf("print");

        printResult.add("stat", visit(ctx.expr()));
        printResult.add("expr", ctx.expr().varName);
        if (!ctx.expr().unit.equals("Void"))
            printResult.add("unit", ctx.expr().unit);
        return printResult;
    }

    /**
     * This method generates the output code for printing to the console the
     * dimension of an expression.
     */
    @Override
    public ST visitDimensionCheck(GeneralParser.DimensionCheckContext ctx) {
        ST printResult = this.stg.getInstanceOf("print");

        printResult.add("stat", visit(ctx.expr()));
        printResult.add("expr", ctx.expr().getText() + " is " + ctx.expr().dimension);

        return printResult;
    }

    /**
     * This method generates the output code for printing to the console the unit of
     * an expression.
     */
    @Override
    public ST visitUnitCheck(GeneralParser.UnitCheckContext ctx) {
        ST printResult = this.stg.getInstanceOf("print");

        printResult.add("stat", visit(ctx.expr()));
        printResult.add("expr", ctx.expr().getText() + " is " + ctx.expr().unit);

        return printResult;
    }

    // ASSIGNMENT RULES

    /**
     * This method generates the code for only assign a value to a previously
     * declared variable.
     */
    @Override
    public ST visitJustAssign(GeneralParser.JustAssignContext ctx) {

        ST assignResult = stg.getInstanceOf("assign");
        String id = ctx.ID().getText();
        Symbol symbol = GeneralParser.map.get(id);

        assignResult.add("stat", visit(ctx.expr()).render());
        assignResult.add("var", symbol.varName());
        assignResult.add("value", ctx.expr().varName);

        return assignResult;
    }

    /**
     * This method declares a new variable.
     */
    @Override
    public ST visitDeclaration(GeneralParser.DeclarationContext ctx) {

        ST decResult = stg.getInstanceOf("declaration");
        String id = ctx.ID().getText();

        Symbol symbol = GeneralParser.map.get(id);
        symbol.setVarName(newVar()); // Change var name to v
        decResult.add("type", symbol.type().getType());
        decResult.add("var", symbol.varName());

        return decResult;
    }

    /**
     * This method simultaneously declares a new variable and assigns a value to it.
     */
    @Override
    public ST visitDeclareAndAssign(GeneralParser.DeclareAndAssignContext ctx) {

        ST result = stg.getInstanceOf("stats");

        // Get the declaration
        ST decResult = visit(ctx.declaration());

        // Get the assignment
        ST assResult = stg.getInstanceOf("assign");
        String id = ctx.declaration().ID().getText();
        Symbol symbol = GeneralParser.map.get(id);

        assResult.add("stat", visit(ctx.expr()).render());
        assResult.add("var", symbol.varName());
        assResult.add("value", ctx.expr().varName);

        // Write both declaration and assignment in seperate lines
        result.add("stat", decResult.render());
        result.add("stat", assResult.render());

        return result;
    }

    // EXPR RULES

    /**
     * This method generates the output code for an expression using the triple
     * address code technique.
     * 
     * @param ctx     Context of the rule.
     * @param e1Stats Statements of the first operand.
     * @param e2Stat  Statements of the second operand.
     * @param type    Result type of the expression.
     * @param var1    Name of the variable of the first operand.
     * @param op      Operation to be performed.
     * @param var2    Name of the variable of the second operand.
     * @param varOut  Name of the output variable that will old the result value of
     *                the expression.
     */
    private ST getExprResult(ParserRuleContext ctx, String e1Stats, String e2Stats, String type, String var1, String op,
            String var2, String varOut) {
        ST result = stg.getInstanceOf("stats");
        result.add("stat", e1Stats);
        result.add("stat", e2Stats);

        ST expression = stg.getInstanceOf("expression");
        expression.add("type", type);
        expression.add("var", varOut);
        expression.add("e1", var1);
        expression.add("op", op);
        expression.add("e2", var2);

        result.add("stat", expression.render());

        return result;
    }

    /**
     * Method to visit the parentheses expression.
     */
    @Override
    public ST visitParentheses(GeneralParser.ParenthesesContext ctx) {
        ST result = visit(ctx.expr());

        ctx.varName = ctx.expr().varName;

        return result;
    }

    /**
     * Method to visit and generate the output code of the addition/subtraction
     * expression.
     */
    @Override
    public ST visitAddSub(GeneralParser.AddSubContext ctx) {
        ctx.varName = newVar();
        return getExprResult(ctx, visit(ctx.e1).render(), visit(ctx.e2).render(), ctx.exprType.getType(),
                ctx.e1.varName, ctx.op.getText(), ctx.e2.varName, ctx.varName);
    }

    /**
     * Method to visit and generate the output code of the multiplication/division
     * expression.
     */
    @Override
    public ST visitMultDiv(GeneralParser.MultDivContext ctx) {
        ctx.varName = newVar();
        return getExprResult(ctx, visit(ctx.e1).render(), visit(ctx.e2).render(), ctx.exprType.getType(),
                ctx.e1.varName, ctx.op.getText(), ctx.e2.varName, ctx.varName);
    }

    /**
     * Method to visit and generate the output code of the pow expression.
     */
    @Override
    public ST visitPow(GeneralParser.PowContext ctx) {
        ctx.varName = newVar();
        ST result = stg.getInstanceOf("stats");
        result.add("stat", visit(ctx.e1).render());
        result.add("stat", visit(ctx.e2).render());

        ST powResult = stg.getInstanceOf("powerExpr");
        powResult.add("type", ctx.exprType.getType());
        powResult.add("var", ctx.varName);
        powResult.add("e1", ctx.e1.varName);
        powResult.add("e2", ctx.e2.varName);

        result.add("stat", powResult.render());

        return result;
    }

    /**
     * Method to generate the base integer literal expression output code.
     */
    @Override
    public ST visitIntValue(GeneralParser.IntValueContext ctx) {
        ST result = stg.getInstanceOf("declaration");
        ctx.varName = newVar();

        result.add("type", "Integer");
        result.add("var", ctx.varName);

        result.add("value", ctx.INT().getText());

        return result;
    }

    /**
     * Method to generate the base real literal expression output code.
     */
    @Override
    public ST visitRealValue(GeneralParser.RealValueContext ctx) {
        ST result = stg.getInstanceOf("declaration");
        ctx.varName = newVar();

        result.add("type", "Real");
        result.add("var", ctx.varName);
        result.add("value", ctx.REAL().getText());

        return result;
    }

    /**
     * Method to generate the base boolean literal expression output code.
     */
    @Override
    public ST visitBooleanValue(GeneralParser.BooleanValueContext ctx) {
        ST result = stg.getInstanceOf("declaration");
        ctx.varName = newVar();

        result.add("type", "Boolean");
        result.add("var", ctx.varName);
        result.add("value", ctx.BOOLEAN().getText());

        return result;
    }

    /**
     * Method to generate the base string literal expression output code.
     */
    @Override
    public ST visitStringValue(GeneralParser.StringValueContext ctx) {
        ST result = stg.getInstanceOf("declaration");
        ctx.varName = newVar();

        result.add("type", "String");
        result.add("var", ctx.varName);
        result.add("value", ctx.STRING().getText());

        return result;
    }

    /**
     * Method to generate the ID value expression output code.
     */
    @Override
    public ST visitIDvalue(GeneralParser.IDvalueContext ctx) {
        ST result = stg.getInstanceOf("stats");
        ST idVarDecl = stg.getInstanceOf("declaration");

        String id = ctx.ID().getText();

        ctx.varName = newVar();

        idVarDecl.add("type", ctx.exprType.getType());
        idVarDecl.add("var", ctx.varName);
        idVarDecl.add("value", GeneralParser.map.get(id).varName());

        result.add("stat", idVarDecl.render());

        return result;
    }

    // INPUT RULE
    /**
     * Method to generate the output code for input expression.
     */
    @Override
    public ST visitInputValue(GeneralParser.InputValueContext ctx) {
        ST result = stg.getInstanceOf("input");

        ctx.varName = newVar();
        result.add("prompt", ctx.input().STRING().getText());
        result.add("var", ctx.varName);

        return result;

    }

    // CONDITIONAL EXPRESSIONS

    /**
     * This method, similiar to the getExprResult, is used to generate the output
     * code of an equality comparison between two expressions.
     */
    private ST getExprEquals(ParserRuleContext ctx, String e1Stats, String e2Stats, String var1, String var2,
            String varOut) {
        ST result = stg.getInstanceOf("stats");
        result.add("stat", e1Stats);
        result.add("stat", e2Stats);

        ST expression = stg.getInstanceOf("expressionEquals");
        expression.add("type", "Boolean");
        expression.add("var", varOut);
        expression.add("e1", var1);
        expression.add("e2", var2);

        result.add("stat", expression.render());

        return result;
    }

    /**
     * This method, similiar to the getExprResult, is used to generate the output
     * code of a not equality comparison between two expressions.
     */
    private ST getExprNotEquals(ParserRuleContext ctx, String e1Stats, String e2Stats, String var1, String var2,
            String varOut) {
        ST result = stg.getInstanceOf("stats");
        result.add("stat", e1Stats);
        result.add("stat", e2Stats);

        ST expression = stg.getInstanceOf("expressionNotEquals");
        expression.add("type", "Boolean");
        expression.add("var", varOut);
        expression.add("e1", var1);
        expression.add("e2", var2);

        result.add("stat", expression.render());

        return result;
    }

    /**
     * This method, similiar to the getExprResult, is used to generate the output
     * code of a negation of one expression.
     */
    private ST getExprNot(ParserRuleContext ctx, String e1Stats, String var1, String varOut) {
        ST result = stg.getInstanceOf("stats");
        result.add("stat", e1Stats);

        ST expression = stg.getInstanceOf("expressionNot");
        expression.add("type", "Boolean");
        expression.add("var", varOut);
        expression.add("e1", var1);

        result.add("stat", expression.render());

        return result;
    }

    /**
     * This method is responsible for generating the output code of an 'if'
     * statement.
     */
    @Override
    public ST visitConditional(GeneralParser.ConditionalContext ctx) {
        ST result = stg.getInstanceOf("conditional");
        result.add("stat", visit(ctx.expr()).render());
        result.add("var", ctx.expr().varName);
        result.add("trueStats", visit(ctx.trueStats).render());

        if (ctx.falseStats != null) {
            if (ctx.falseStats.conditional() != null)
                result.add("falseStats", visit(ctx.falseStats).render());
            else {
                result.add("falseStats", visit(ctx.falseStats.statList()).render());
            }
        }
        return result;
    }

    /**
     * This method is responsible for generating the output code of a 'while'
     * statement.
     */
    @Override
    public ST visitWhileConditional(GeneralParser.WhileConditionalContext ctx) {
        ST result = stg.getInstanceOf("conditionalWhile");

        String exprFirst = visit(ctx.expr()).render();

        String exprNext = "";
        for (int i = 0; i < exprFirst.split("\n").length; i++) {
            exprNext += exprFirst.split("\n")[i].substring(exprFirst.split("\n")[i].indexOf(' ') + 1);
        }
        result.add("stat", exprFirst);
        result.add("var", ctx.expr().varName);
        result.add("checkCondition", "\n" + exprNext);
        result.add("trueStats", visit(ctx.trueStats).render());

        return result;
    }

    /**
     * This method is responsible for generating the output code of a 'for'
     * statement.
     */
    @Override
    public ST visitForConditional(GeneralParser.ForConditionalContext ctx) {
        ST result = stg.getInstanceOf("conditionalFor");

        String incrementVarDec = visit(ctx.incVarDec).render();
        String breakCond = visit(ctx.breakCond).render();
        String incrementCondTemp = visit(ctx.incCond).render();

        String incVar = incrementVarDec.split("\n")[incrementVarDec.split("\n").length - 1].split(" ")[0].replace(";",
                "");

        // Increment Condition
        String incrementCond = "";
        for (int i = 0; i < incrementCondTemp.split("\n").length - 1; i++) {
            incrementCond += incrementCondTemp.split("\n")[i] + "\n";
        }

        String incCondition;
        String lastIncCondStatement = incrementCondTemp.split("\n")[incrementCondTemp.split("\n").length - 1];
        incCondition = incVar + " = " + lastIncCondStatement.split(" = ")[1];

        incrementCond += incCondition;

        // Increment Variable Declaration
        String incDeclaration;
        String lastIncDec = incrementVarDec.split("\n")[incrementVarDec.split("\n").length - 1];
        incDeclaration = incVar + " = " + lastIncDec.split(" = ")[1];

        // Update Break Condition
        String breakCondUpdate = "";
        for (int i = 0; i < breakCond.split("\n").length; i++) {
            breakCondUpdate += breakCond.split("\n")[i].substring(breakCond.split("\n")[i].indexOf(' ') + 1);
        }

        // Update Increment Condition
        String updateIncrement = "";
        for (int i = 0; i < incrementCond.split("\n").length - 1; i++) {
            updateIncrement += incrementCond.split("\n")[i].substring(incrementCond.split("\n")[i].indexOf(' ') + 1);
        }

        result.add("stat", incrementVarDec + "\n\n" + breakCond + "\n\n" + incrementCond);
        result.add("var", incDeclaration);
        result.add("cond", ctx.breakCond.varName);
        result.add("inc", incCondition.replace(";", ""));

        result.add("updateIncr", updateIncrement);
        result.add("updateCond", breakCondUpdate);

        result.add("trueStats", visit(ctx.trueStats).render());

        return result;
    }

    // CONDITIONAL CHECKS

    /**
     * This method is responsible to choose the correct function in order to
     * generate the code for an equality expression.
     */
    @Override
    public ST visitConditionalEquality(GeneralParser.ConditionalEqualityContext ctx) {
        ctx.varName = newVar();

        if (ctx.op.getText().equals("===")) {
            return getExprEquals(ctx, visit(ctx.e1).render(), visit(ctx.e2).render(), ctx.e1.varName, ctx.e2.varName,
                    ctx.varName);
        } else if (ctx.op.getText().equals("!==")) {
            return getExprNotEquals(ctx, visit(ctx.e1).render(), visit(ctx.e2).render(), ctx.e1.varName, ctx.e2.varName,
                    ctx.varName);

        } else {
            return getExprResult(ctx, visit(ctx.e1).render(), visit(ctx.e2).render(), "Boolean", ctx.e1.varName,
                    ctx.op.getText(), ctx.e2.varName, ctx.varName);
        }
    }

    /**
     * This method visits a conditional relational expression.
     */
    @Override
    public ST visitConditionalRelational(GeneralParser.ConditionalRelationalContext ctx) {
        ctx.varName = newVar();

        return getExprResult(ctx, visit(ctx.e1).render(), visit(ctx.e2).render(), "Boolean", ctx.e1.varName,
                ctx.op.getText(), ctx.e2.varName, ctx.varName);
    }

    /**
     * This method visits a binary 'and/or' conditional expression.
     */
    @Override
    public ST visitConditionalAndOr(GeneralParser.ConditionalAndOrContext ctx) {
        ctx.varName = newVar();

        return getExprResult(ctx, visit(ctx.e1).render(), visit(ctx.e2).render(), "Boolean", ctx.e1.varName,
                ctx.op.getText(), ctx.e2.varName, ctx.varName);
    }

    /**
     * This method visits a unary conditional negation expression.
     */
    @Override
    public ST visitConditionalNegation(GeneralParser.ConditionalNegationContext ctx) {
        ctx.varName = newVar();

        return getExprNot(ctx, visit(ctx.expr()).render(), ctx.expr().varName, ctx.varName);
    }

    /**
     * This method visits a binary operator expression, to set its sign.
     */
    @Override
    public ST visitBinaryOperator(GeneralParser.BinaryOperatorContext ctx) {
        ctx.varName = newVar();

        return getBinaryOperator(ctx.exprType, visit(ctx.expr()).render(), ctx.expr().varName, ctx.varName,
                ctx.sign.getText());
    }

    /**
     * This method is responsible for generate the output code of a binary operator
     * expression.
     */
    private ST getBinaryOperator(Type type, String e1Stats, String var1, String varOut, String operator) {
        ST result = stg.getInstanceOf("stats");
        result.add("stat", e1Stats);

        ST expression = stg.getInstanceOf("binaryOperator");
        expression.add("type", type.getType());
        expression.add("var", varOut);
        expression.add("e1", var1);
        expression.add("operator", operator);

        result.add("stat", expression.render());

        return result;
    }

    /**
     * This method visits an absolute value expression, to set its absolute value.
     */
    @Override
    public ST visitAbsoluteValue(GeneralParser.AbsoluteValueContext ctx) {
        ctx.varName = newVar();

        return getAbsoluteValue(ctx.exprType, visit(ctx.expr()).render(), ctx.expr().varName, ctx.varName);
    }

    /**
     * This method is responsible for generate the output code of an absolute value
     * expression.
     */
    private ST getAbsoluteValue(Type type, String e1Stats, String var1, String varOut) {
        ST result = stg.getInstanceOf("stats");
        result.add("stat", e1Stats);

        ST expression = stg.getInstanceOf("absoluteValue");
        expression.add("type", type.getType());
        expression.add("var", varOut);
        expression.add("e1", var1);

        result.add("stat", expression.render());

        return result;
    }

}