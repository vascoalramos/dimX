import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.FileInputStream;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import org.stringtemplate.v4.*;

public class GeneralMain {
   public static void main(String[] args) throws Exception {
      // create a CharStream that reads from standard input:
      CharStream input = null;
      try {
         input = CharStreams.fromStream(new FileInputStream(args[0]));
      } catch (Exception e) {
         System.err.println("ERROR: Unable to read from file");
         System.exit(1);
      }
      // create a lexer that feeds off of input CharStream:
      GeneralLexer lexer = new GeneralLexer(input);
      // create a buffer of tokens pulled from the lexer:
      CommonTokenStream tokens = new CommonTokenStream(lexer);
      // create a parser that feeds off the tokens buffer:
      GeneralParser parser = new GeneralParser(tokens);
      // replace error listener:
      // parser.removeErrorListeners(); // remove ConsoleErrorListener
      // parser.addErrorListener(new ErrorHandlingListener());
      // begin parsing at main rule:
      ParseTree tree = parser.main();
      if (parser.getNumberOfSyntaxErrors() == 0) {
         // print LISP-style tree:
         // System.out.println(tree.toStringTree(parser));

         SemanticCheckGeneral visitorGeneral = new SemanticCheckGeneral();
         DimXCompiler compiler = new DimXCompiler();

         visitorGeneral.visit(tree);
         if (!ErrorHandling.error()) {
            String outputLang = "java";

            if (!compiler.validTarget(outputLang)) {
               System.err.println("ERROR: Can't find template group file for JAVA");
               System.exit(1);
            }

            compiler.setTarget(outputLang);
            ST code = compiler.visit(tree);

            String outputFile = "Output." + outputLang;

            try {
               code.add("name", "Output");
               PrintWriter pw = new PrintWriter(new File(outputFile));
               pw.print(code.render());
               pw.close();

            } catch (FileNotFoundException e) {
               System.err.println("ERROR: Failed to write code file");
               System.exit(1);
            }
         }
      }
   }
}
