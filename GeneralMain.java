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

      CharStream input = null;
      try {
         input = CharStreams.fromStream(new FileInputStream(args[0]));
         if(!args[0].split("\\.")[1].equals("dmx")){
            ErrorHandling.printError("Unrecognisable file extension! Use .dmx");
            System.exit(1);
         }
      } catch (Exception e) {
         ErrorHandling.printError("Couldn't find specified file \" " + args[0] + "\"");
         System.exit(1);
      }
      
      GeneralLexer lexer = new GeneralLexer(input);
      CommonTokenStream tokens = new CommonTokenStream(lexer);
      GeneralParser parser = new GeneralParser(tokens);
      ParseTree tree = parser.main();

      if (parser.getNumberOfSyntaxErrors() == 0) {
         SemanticCheckGeneral visitorGeneral = new SemanticCheckGeneral();
         DimXCompiler compiler = new DimXCompiler();

         visitorGeneral.visit(tree);
         if (!ErrorHandling.error()) {
            String outputLang = "java";

            if (!compiler.validTarget(outputLang)) {
               ErrorHandling.printError("Can't find template group file for " + outputLang);
               System.exit(1);
            }

            compiler.setTarget(outputLang);
            ST code = compiler.visit(tree);

            String outputFileName = args[0].split("\\.")[0];

            String outputFileExtension =  "." + outputLang;

            String outputFile = outputFileName + outputFileExtension;

            try {
               code.add("name", outputFileName);
               PrintWriter pw = new PrintWriter(new File(outputFile));
               pw.print(code.render());
               pw.close();

            } catch (FileNotFoundException e) {
               System.err.println("Failed to write code file");
               System.exit(1);
            }
         }
      }
   }
}
