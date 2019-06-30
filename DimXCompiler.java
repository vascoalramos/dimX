import java.io.File;
import org.stringtemplate.v4.*;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.ParserRuleContext;

public class DimXCompiler extends GeneralBaseVisitor<ST> {
    protected int varCount = 0;
    protected STGroup stg = null;
    protected String targetLang = "java";

    /* SUPPORT FUNCTIONS */

    // Checks if the string template file exists
    public boolean validTarget(String outputLang) {
        File stgFile = new File(outputLang+".stg");
        return (stgFile.exists() && stgFile.isFile() && stgFile.canRead());
    }

    // Set Output Lang Target
    public boolean setTarget(String outputLang) {
        assert validTarget(outputLang);

        this.targetLang = outputLang;
        return true;
    }

    // Returns a new usable variable name
    public String newVar() {
        return "v" + varCount++;
    }

    /* MAIN RULES */

    //Main rule -> Starts module and adds all stats to the main function
    @Override
    public ST visitMain(GeneralParser.MainContext ctx) {
        assert (validTarget(this.targetLang)); // Check if we have a valid stgFile

        this.stg = new STGroupFile("java.stg");

        ST resultModule = this.stg.getInstanceOf("module"); // Final result
        resultModule.add("stat",visit(ctx.statList()));
        
        return resultModule;
    }

    @Override 
    public ST visitStatList(GeneralParser.StatListContext ctx) { 
        ST resultStats = this.stg.getInstanceOf("stats"); // Intermediate results of all stats

        for (GeneralParser.StatContext sc : ctx.stat()){
            resultStats.add("stat", visit(sc));
        }

        return resultStats;
    }


    /* PRINT RULES */

    //Print rule -> Prints the expression
    @Override
    public ST visitPrint(GeneralParser.PrintContext ctx) {
        ST printResult = this.stg.getInstanceOf("print");
        
        printResult.add("stat", visit(ctx.expr()));
        printResult.add("expr",ctx.expr().varName);
        if(!ctx.expr().unit.equals("Void"))
            printResult.add("unit",ctx.expr().unit);
        return printResult;
    }

    //Check dimension rule -> Prints expression's dimension
    @Override
    public ST visitDimensionCheck(GeneralParser.DimensionCheckContext ctx) {
        ST printResult = this.stg.getInstanceOf("print");

        printResult.add("stat", visit(ctx.expr()));
        printResult.add("expr",ctx.expr().getText() + " is " + ctx.expr().dimension);

        return printResult;
    }

    //Check unit rule -> Prints expression's unit
    @Override 
    public ST visitUnitCheck(GeneralParser.UnitCheckContext ctx) { 
        ST printResult = this.stg.getInstanceOf("print");

        printResult.add("stat", visit(ctx.expr()));
        printResult.add("expr",ctx.expr().getText() + " is " + ctx.expr().unit);

        return printResult;
    }

    /* ASSIGNMENT FUNCTIONS */

    //Assignment rule -> Assigns value to previously declared variable
    @Override 
    public ST visitJustAssign(GeneralParser.JustAssignContext ctx) {

        ST assignResult = stg.getInstanceOf("assign");
        String id = ctx.ID().getText();
        Symbol symbol = GeneralParser.map.get(id);
        
        assignResult.add("stat", visit(ctx.expr()).render());
        assignResult.add("var",symbol.varName());
        assignResult.add("value",ctx.expr().varName);

        return assignResult;
    }

    //Declare rule -> Declares new variable
    @Override 
    public ST visitDeclaration(GeneralParser.DeclarationContext ctx) {

        ST decResult = stg.getInstanceOf("declaration");
        String id = ctx.ID().getText();

        Symbol symbol = GeneralParser.map.get(id);
        symbol.setVarName(newVar()); //Change var name to v
        decResult.add("type", symbol.type().getType());
        decResult.add("var",symbol.varName());

        return decResult;
    }

    //Declare and assign rule -> Declares new variable and assigns it a value
    @Override 
    public ST visitDeclareAndAssign(GeneralParser.DeclareAndAssignContext ctx) { 

        ST result = stg.getInstanceOf("stats");

        //Get the declaration
        ST decResult = visit(ctx.declaration());

        //Get the assignment
        ST assResult = stg.getInstanceOf("assign");
        String id = ctx.declaration().ID().getText();
        Symbol symbol = GeneralParser.map.get(id);
        
        assResult.add("stat", visit(ctx.expr()).render());
        assResult.add("var",symbol.varName());
        assResult.add("value",ctx.expr().varName);
        

        //Write both declaration and assignment in seperate lines
        result.add("stat",decResult.render());
        result.add("stat",assResult.render());


        return result;
    }




    /* EXPR RULES */

    //Base Expr ST Builder -> e1Stats : Stats of 1st operand ; e2Stats : Stats of 2nd operand ;  type : Result type ; var1 : VarName of 1st operand ; op - Operation ; var2 : VarName of 2nd Operand ; varOut : VarName of output ;
    private ST getExprResult(ParserRuleContext ctx, String e1Stats, String e2Stats, String type, String var1,String op, String var2, String varOut){
        ST result = stg.getInstanceOf("stats");
        result.add("stat", e1Stats);
        result.add("stat",e2Stats);

        ST expression = stg.getInstanceOf("expression");
        expression.add("type",type);
        expression.add("var",varOut);
        expression.add("e1",var1);
        expression.add("op",op);
        expression.add("e2",var2);

        result.add("stat",expression.render());

        return result;
    }

    //Parenthesis Expr
    @Override 
    public ST visitParentheses(GeneralParser.ParenthesesContext ctx) { 
        ST result = visit(ctx.expr());
        ctx.varName = ctx.expr().varName;

        return result;
    }

    //Addition/Subtraction Expr
    @Override 
    public ST visitAddSub(GeneralParser.AddSubContext ctx) { 
        ctx.varName = newVar();
        return getExprResult(ctx, 
                                visit(ctx.e1).render(), 
                                visit(ctx.e2).render(), 
                                ctx.exprType.getType(),
                                ctx.e1.varName,
                                ctx.op.getText(), 
                                ctx.e2.varName,
                                ctx.varName);
    }

    //Multiplication/Division Expr
    @Override 
    public ST visitMultDiv(GeneralParser.MultDivContext ctx) {
        ctx.varName = newVar();
        return getExprResult(ctx, 
                                visit(ctx.e1).render(), 
                                visit(ctx.e2).render(), 
                                ctx.exprType.getType(),
                                ctx.e1.varName,
                                ctx.op.getText(), 
                                ctx.e2.varName,
                                ctx.varName);
    }

    //Power Expr
    @Override 
    public ST visitPow(GeneralParser.PowContext ctx) {
        ctx.varName = newVar();
        ST result = stg.getInstanceOf("stats");
        result.add("stat", visit(ctx.e1).render());
        result.add("stat",visit(ctx.e2).render());

        ST powResult = stg.getInstanceOf("powerExpr");
        powResult.add("type", ctx.exprType.getType());
        powResult.add("var", ctx.varName);
        powResult.add("e1", ctx.e1.varName);
        powResult.add("e2", ctx.e2.varName);
        
        result.add("stat", powResult.render());

        return result;
    }



    /* LITERAL EXPR */
        //Base int literal expression
        @Override 
        public ST visitIntValue(GeneralParser.IntValueContext ctx) { 
            ST result = stg.getInstanceOf("declaration");
            ctx.varName = newVar();

            result.add("type","Integer");
            result.add("var",ctx.varName);

            result.add("value",ctx.INT().getText());

            return result;
        }

        //Base real literal expression
        @Override public ST visitRealValue(GeneralParser.RealValueContext ctx) {
            ST result = stg.getInstanceOf("declaration");
            ctx.varName = newVar();

            result.add("type","Real");
            result.add("var",ctx.varName);
            result.add("value",ctx.REAL().getText());

            return result;
        } 
        
        //Base boolean literal expression
        @Override 
        public ST visitBooleanValue(GeneralParser.BooleanValueContext ctx) { 
            ST result = stg.getInstanceOf("declaration");
            ctx.varName = newVar();

            result.add("type","Boolean");
            result.add("var",ctx.varName);
            result.add("value",ctx.BOOLEAN().getText());

            return result;
        }

        //Base String literal declaration
        @Override 
        public ST visitStringValue(GeneralParser.StringValueContext ctx) { 
            ST result = stg.getInstanceOf("declaration");
            ctx.varName = newVar();

            result.add("type","String");
            result.add("var",ctx.varName);
            result.add("value",ctx.STRING().getText());

            return result;
        }


        //Base ID value getter
        @Override public ST visitIDvalue(GeneralParser.IDvalueContext ctx) { 
            ST result = stg.getInstanceOf("stats");
            ST idVarDecl = stg.getInstanceOf("declaration");

            String id = ctx.ID().getText();

            ctx.varName = newVar();
            
            idVarDecl.add("type",ctx.exprType.getType());
            idVarDecl.add("var",ctx.varName);
            idVarDecl.add("value",GeneralParser.map.get(id).varName());

            result.add("stat",idVarDecl.render());

            return result;
        }

        /* INPUT RULE */
        @Override 
        public ST visitInputValue(GeneralParser.InputValueContext ctx){ 
            ST result = stg.getInstanceOf("input");

            ctx.varName = newVar();
            result.add("prompt", ctx.input().STRING().getText());
            result.add("var",ctx.varName);

            return result;

        }

    
    /* CONDITIONAL EXPRESSIONS */

    //Base Expr .EQUALS() ST Builder -> Used for comparing using the === operator
    private ST getExprEquals(ParserRuleContext ctx, String e1Stats, String e2Stats, String var1, String var2, String varOut){
        ST result = stg.getInstanceOf("stats");
        result.add("stat", e1Stats);
        result.add("stat",e2Stats);

        ST expression = stg.getInstanceOf("expressionEquals");
        expression.add("type","Boolean");
        expression.add("var",varOut);
        expression.add("e1",var1);
        expression.add("e2",var2);

        result.add("stat",expression.render());

        return result;
    }

    //Base Expr NOT .EQUALS() ST Builder -> Used for comparing using the !== operator
    private ST getExprNotEquals(ParserRuleContext ctx, String e1Stats, String e2Stats, String var1, String var2, String varOut){
        ST result = stg.getInstanceOf("stats");
        result.add("stat", e1Stats);
        result.add("stat",e2Stats);

        ST expression = stg.getInstanceOf("expressionNotEquals");
        expression.add("type","Boolean");
        expression.add("var",varOut);
        expression.add("e1",var1);
        expression.add("e2",var2);

        result.add("stat",expression.render());

        return result;
    }

    //Base Expr NOT ST Builder -> Used for the Not <expr> rules
    private ST getExprNot(ParserRuleContext ctx, String e1Stats, String var1, String varOut){
        ST result = stg.getInstanceOf("stats");
        result.add("stat", e1Stats);

        ST expression = stg.getInstanceOf("expressionNot");
        expression.add("type","Boolean");
        expression.add("var",varOut);
        expression.add("e1",var1);

        result.add("stat",expression.render());

        return result;
    }

    //If-Else Rule
    @Override 
    public ST visitConditional(GeneralParser.ConditionalContext ctx) { 
        ST result = stg.getInstanceOf("conditional");
        result.add("stat", visit(ctx.expr()).render());
        result.add("var", ctx.expr().varName);
        result.add("trueStats", visit(ctx.trueStats).render());

        if(ctx.falseStats != null){
            if(ctx.falseStats.conditional() != null)
                result.add("falseStats", visit(ctx.falseStats).render());
            else{
                result.add("falseStats", visit(ctx.falseStats.statList()).render());
            }
        }
        return result;
    }

    //While Rule
    @Override 
    public ST visitWhileConditional(GeneralParser.WhileConditionalContext ctx){
        ST result = stg.getInstanceOf("conditionalWhile");

        result.add("stat", visit(ctx.expr()).render());
        result.add("var", ctx.expr().varName);
        result.add("trueStats", visit(ctx.trueStats).render());

        return result;
    }

    //For Rule
    @Override 
    public ST visitForConditional(GeneralParser.ForConditionalContext ctx) { 
        ST result = stg.getInstanceOf("conditionalFor");

        String incrementVarDec = visit(ctx.incVarDec).render();
        String breakCond = visit(ctx.breakCond).render();
        String incrementCond = visit(ctx.incCond).render();

        String incVar = incrementVarDec.split("\n")[0].split(" ")[1].replace(";","");
        
        String incCondition;
        String lastIncCondStatement = incrementCond.split("\n")[incrementCond.split("\n").length-1];
        incCondition = incVar + " = " + lastIncCondStatement.split(" = ")[1];

        String incDec;
        String lastIncDec = incrementVarDec.split("\n")[incrementVarDec.split("\n").length-1];
        incDec = incVar + " = " + lastIncDec.split(" = ")[1];


        String breakCondUpdate = "";
        for(int i = 0 ; i < breakCond.split("\n").length ; i++){
            breakCondUpdate += breakCond.split("\n")[i].substring(breakCond.split("\n")[i].indexOf(' ')+1);
        }

        String updateIncrement = "";
        for(int i = 0 ; i < incrementCond.split("\n").length ; i++){
            updateIncrement += incrementCond.split("\n")[i].substring(incrementCond.split("\n")[i].indexOf(' ')+1);
        }


        result.add("stat", incrementVarDec + "\n\n" + breakCond + "\n\n" + incrementCond);
        result.add("var", incDec);
        result.add("cond", ctx.breakCond.varName);
        result.add("inc", incCondition.replace(";", ""));

        result.add("updateIncr", updateIncrement);
        result.add("updateCond", breakCondUpdate);


        result.add("trueStats", visit(ctx.trueStats).render());

        return result; 
    }


        /* CONDITIONAL CHECKS */

        //Equality Expressions (includes ==, ===, !=, !==)
        @Override 
        public ST visitConditionalEquality(GeneralParser.ConditionalEqualityContext ctx) { 
            ctx.varName = newVar();

            if(ctx.op.getText().equals("===")){
                return getExprEquals(ctx, 
                                    visit(ctx.e1).render(), 
                                    visit(ctx.e2).render(), 
                                    ctx.e1.varName,
                                    ctx.e2.varName,
                                    ctx.varName);
            }else if(ctx.op.getText().equals("!==")){
                return getExprNotEquals(ctx, 
                                    visit(ctx.e1).render(), 
                                    visit(ctx.e2).render(), 
                                    ctx.e1.varName,
                                    ctx.e2.varName,
                                    ctx.varName);

            }else{
                return getExprResult(ctx, 
                                    visit(ctx.e1).render(), 
                                    visit(ctx.e2).render(), 
                                    "Boolean",
                                    ctx.e1.varName,
                                    ctx.op.getText(), 
                                    ctx.e2.varName,
                                    ctx.varName);
            }
        }

        //Binary Equality Expressions (includes ==, ===, !=, !==)
        @Override 
        public ST visitConditionalRelational(GeneralParser.ConditionalRelationalContext ctx) { 
            ctx.varName = newVar();

            return getExprResult(ctx, 
                                    visit(ctx.e1).render(), 
                                    visit(ctx.e2).render(), 
                                    "Boolean",
                                    ctx.e1.varName,
                                    ctx.op.getText(), 
                                    ctx.e2.varName,
                                    ctx.varName);
        }

        //Binary AND/OR Expressions
        @Override 
        public ST visitConditionalAndOr(GeneralParser.ConditionalAndOrContext ctx) { 
            ctx.varName = newVar();

            return getExprResult(ctx, 
                                    visit(ctx.e1).render(), 
                                    visit(ctx.e2).render(), 
                                    "Boolean",
                                    ctx.e1.varName,
                                    ctx.op.getText(), 
                                    ctx.e2.varName,
                                    ctx.varName);
        }

        //Unary Negation Expression
        @Override 
        public ST visitConditionalNegation(GeneralParser.ConditionalNegationContext ctx) {
            ctx.varName = newVar();

            return getExprNot(ctx, 
                            visit(ctx.expr()).render(), 
                            ctx.expr().varName,
                            ctx.varName);
        }
}