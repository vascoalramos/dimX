public class SemanticCheckGeneral extends GeneralBaseVisitor<Boolean>{


    @Override public Boolean visitParentheses(GeneralParser.ParenthesesContext ctx) { 
    Boolean res = visit(ctx.expr());
      if (res)
         ctx.exprType = ctx.expr().exprType;
      return res;
    }

    
}