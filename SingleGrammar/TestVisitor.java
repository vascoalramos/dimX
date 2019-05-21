public class TestVisitor<T> extends GeneralBaseVisitor<T> {
    @Override public T visitQuantity_decl(GeneralParser.Quantity_declContext ctx) {
         return visitChildren(ctx); 
        }
   
  }
  