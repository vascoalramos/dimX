import java.io.File;
import org.stringtemplate.v4.*;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.ParserRuleContext;

public class DimXCompiler extends GeneralBaseVisitor<ST> {
    protected int varCount = 0;
    protected STGroup stg = null;

    /* SUPPORT FUNCTIONS */

    // Checks if the string template file exists
    public boolean validTarget() {
        File stgFile = new File("java.stg");
        return (stgFile.exists() && stgFile.isFile() && stgFile.canRead());
    }

    // Returns a new usable variable name
    public String newVar() {
        return "v" + varCount++;
    }

    /* MAIN RULES */

    //Main rule -> Starts module and adds all stats to the main function
    @Override
    public ST visitMain(GeneralParser.MainContext ctx) {
        assert (validTarget()); // Check if we have a valid stgFile

        this.stg = new STGroupFile("java.stg");

        ST resultModule = this.stg.getInstanceOf("module"); // Final result
        ST resultStats = this.stg.getInstanceOf("stats"); // Intermediate results of all stats

        for (GeneralParser.StatContext sc : ctx.stat())
            resultStats.add("stat", visit(sc));

        resultModule.add("stat", resultStats);

        return resultModule;
    }

    /* PRINT RULES */

    //Print rule -> Prints the expression
    @Override
    public ST visitPrint(GeneralParser.PrintContext ctx) {
        ST printResult = this.stg.getInstanceOf("print");
        printResult.add("stat", visit(ctx.expr()));
        printResult.add("expr",ctx.expr().varName);
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
        assignResult.add("var",symbol.name());
        assignResult.add("value",ctx.expr().varName);

        return assignResult;
    }

    //Declare rule -> Declares new variable
    @Override 
    public ST visitDeclaration(GeneralParser.DeclarationContext ctx) {
        ST decResult = stg.getInstanceOf("declare");

        String id = ctx.ID().getText();
        Symbol symbol = GeneralParser.map.get(id);
        
        symbol.setVarName(newVar()); //Change var name to vX

        decResult.add("type", symbol.type().name());
        decResult.add("var",symbol.varName());

        return decResult;
    }

    //Declare and assign rule -> Declares new variable and assigns it a value
    @Override 
    public ST visitDeclareAndAssign(GeneralParser.DeclareAndAssignContext ctx) { 
        ST result = stg.getInstanceOf("stats");

        //Get the declaration
        ST decResult = visit(ctx.declaration());

        //Add value to declaration
        decResult.add("value",ctx.expr().varName);
        

        //Write both declaration and assignment in seperate lines
        result.add("stat",decResult.render());

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

    //Base int expression
    @Override 
    public ST visitIntValue(GeneralParser.IntValueContext ctx) { 
        ST result = stg.getInstanceOf("declaration");
        ctx.varName = newVar();

        result.add("type","Integer");
        result.add("var",ctx.varName);
        result.add("value",ctx.INT().getText());

        return result;
    }

    //Base real expression
    @Override public ST visitRealValue(GeneralParser.RealValueContext ctx) {
        ST result = stg.getInstanceOf("declaration");
        ctx.varName = newVar();

        result.add("type","Real");
        result.add("var",ctx.varName);
        result.add("value",ctx.REAL().getText());

        return result;
    } 
    
    


}