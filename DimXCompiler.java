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

    @Override
    public ST visitPrint(GeneralParser.PrintContext ctx) {
        ST printResult = this.stg.getInstanceOf("print");
        printResult.add("stat", visit(ctx.expr()));
        printResult.add("expr",ctx.expr().varName);
        return printResult;
    }

}