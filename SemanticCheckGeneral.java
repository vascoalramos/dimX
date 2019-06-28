import org.antlr.v4.runtime.ParserRuleContext;

public class SemanticCheckGeneral extends GeneralBaseVisitor<Boolean> {
  private final RealType realType = new RealType();
  private final IntegerType integerType = new IntegerType();
  private final BooleanType booleanType = new BooleanType();
  private final StringType stringType = new StringType();

  @Override
  public Boolean visitIDvalue(GeneralParser.IDvalueContext ctx) {
    Boolean res = true;
    String id = ctx.ID().getText();
    if (!GeneralParser.map.exists(id)) {
      ErrorHandling.printError(ctx, "Variable \"" + id + "\" does not exists!");
      res = false;
    } else {
      Symbol sym = GeneralParser.map.get(id);
      if (!sym.valueDefined()) {
        ErrorHandling.printError(ctx, "Variable \"" + id + "\" not defined!");
        res = false;
      } else {
        ctx.exprType = sym.type();
      }
    }
    return res;
  }

  @Override
  public Boolean visitJustAssign(GeneralParser.JustAssignContext ctx) {
    Boolean res = visit(ctx.expr());
    String id = ctx.ID().getText();
    if (res) {
      if (!GeneralParser.map.exists(id)) {
        ErrorHandling.printError(ctx, "Variable \"" + id + "\" does not exists!");
        res = false;
      } else {
        Symbol sym = GeneralParser.map.get(id);
        if (!ctx.expr().exprType.conformsTo(sym.type())) {
          ErrorHandling.printError(ctx, "Expression type does not conform to variable \"" + id + "\" type!");
          res = false;
        } else
          sym.setValueDefined();
      }
    }
    return res;
  }

  @Override
  public Boolean visitDeclareAndAssign(GeneralParser.DeclareAndAssignContext ctx) {
    Boolean res = visit(ctx.expr());
    String id = ctx.declaration().ID().getText();
    if (res) {
      if (GeneralParser.map.exists(id)) {
        ErrorHandling.printError(ctx, "Variable \"" + id + "\" already declared!");
        res = false;
      } else {
        visit(ctx.declaration().type());
        Type type = ctx.declaration().type().res;
        Symbol s = new Symbol(id, type);
        if (!ctx.expr().exprType.conformsTo(s.type())) {
          ErrorHandling.printError(ctx, "Expression type does not conform to variable \"" + id + "\" type!");
          res = false;
        } else {
          s.setValueDefined();
          GeneralParser.map.put(id, s);
        }
      }
    }

    return res;
  }

  @Override
  public Boolean visitDeclaration(GeneralParser.DeclarationContext ctx) {
    String id = ctx.ID().getText();
    if (GeneralParser.map.exists(id)) {
      ErrorHandling.printError(ctx, "Variable \"" + id + "\" already declared!");
      return false;
    } else {
      visit(ctx.type());
      Type type = ctx.type().res;
      Symbol s = new Symbol(id, type);
      s.setValueDefined();
      GeneralParser.map.put(id, s);
    }
    return true;
  }

  @Override public Boolean visitAddSub(GeneralParser.AddSubContext ctx) { 
    //check if there weren' errors in e1 and e2 and if both are numeric
    Boolean check=visit(ctx.e1) && visit(ctx.e2) && checkNumericType(ctx,ctx.e1.exprType) && checkNumericType(ctx, ctx.e2.exprType);
    
    //check if both belong to the same dimension
    check=checkDimension(ctx,ctx.e2.dimension,ctx.e1.dimension);

    //check if both have same unit? check if unit belongs to that dimension


    //assign same type (Real,Integer,...) to operands. Maybe we should assign same unit??
    if(check){
      ctx.exprType=fetchType(ctx.e1.exprType,ctx.e2.exprType);
    }
 
    return check; 
  }


  public Boolean visitMultDiv(GeneralParser.MultDivContext ctx) {
    ctx.exprType = integerType;
    return true;
  }

  @Override
  public Boolean visitIntType(GeneralParser.IntTypeContext ctx) {
    ctx.res = new IntegerType();
    return true;
  }

  @Override
  public Boolean visitRealType(GeneralParser.RealTypeContext ctx) {
    ctx.res = new RealType();
    return true;

  }

  @Override
  public Boolean visitBoolType(GeneralParser.BoolTypeContext ctx) {
    ctx.res = new BooleanType();
    return true;
  }

  @Override
  public Boolean visitStrType(GeneralParser.StrTypeContext ctx) {
    ctx.res = new StringType();
    return true;
  }

  @Override
  public Boolean visitCustomType(GeneralParser.CustomTypeContext ctx) {
    String type_name = ctx.TYPE_ID().getText();
    if (!QuantitiesParser.quantityTable.exists(type_name)) {
      ErrorHandling.printError(ctx, "Quantity \"" + type_name + "\" does not exist!");
      return false;
    }
    return true;
  }

  @Override
  public Boolean visitParentheses(GeneralParser.ParenthesesContext ctx) {
    Boolean res = visit(ctx.expr());
    if (res)
      ctx.exprType = ctx.expr().exprType;
    return res;
  }

  @Override
  public Boolean visitBooleanValue(GeneralParser.BooleanValueContext ctx) {
    ctx.exprType = booleanType;
    return true;
  }

  @Override
  public Boolean visitIntValue(GeneralParser.IntValueContext ctx) {
    ctx.exprType = integerType;
    return true;
  }

  @Override
  public Boolean visitRealValue(GeneralParser.RealValueContext ctx) {
    ctx.exprType = realType;
    return true;
  }

  @Override
  public Boolean visitStringValue(GeneralParser.StringValueContext ctx) {
    ctx.exprType = stringType;
    return true;
  }

  private Boolean checkNumericType(ParserRuleContext ctx, Type t)
   {
      Boolean res = true;
      if (!t.isNumeric())
      {
         ErrorHandling.printError(ctx, "Numeric operator applied to a non-numeric operand!");
         res = false;
      }
      return res;
  }

  private Type fetchType(Type t1, Type t2)
   {
      Type res = null;
      if (t1.isNumeric() && t2.isNumeric())
      {
         if ("real".equals(t1.name()))
            res = t1;
         else if ("real".equals(t2.name()))
            res = t2;
         else
            res = t1;
      }
      else if ("boolean".equals(t1.name()) && "boolean".equals(t2.name()))
         res = t1;
      return res;
   }

  private Boolean checkDimension(ParserRuleContext ctx, String dimensionA,String dimensionB)
   {
      Boolean res = true;
      if (!dimensionA.equals(dimensionB))
      {
         ErrorHandling.printError(ctx, "Can't perform sums and subtractions on operands from diferent dimensions");
         res = false;
      }
      return res;
  }

}