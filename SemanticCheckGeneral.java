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
      Boolean res = visit(ctx.type());
      if (res) {
        Type type = ctx.type().res;
        Symbol s = new Symbol(id, type);
        s.setValueDefined();
        GeneralParser.map.put(id, s);
      }
    }
    return true;
  }

  public Boolean visitMultDiv(GeneralParser.MultDivContext ctx) {
    visit(ctx.e1);
    visit(ctx.e2);
    Type t1 = ctx.e1.exprType;
    Type t2 = ctx.e2.exprType;
    Boolean res = true;
    if (t1.equals(stringType) || t1.equals(booleanType) || t2.equals(stringType) || t2.equals(booleanType)) {
      ErrorHandling.printError(ctx, "Bad operand types for operator \"" + ctx.op.getText() + "\"");
      res = false;
    }
    else if (ctx.e1.exprType.equals(realType) || ctx.e2.exprType.equals(realType))
      ctx.exprType = realType;
    else
      ctx.exprType = integerType;
    return res;
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
    String v = QuantitiesParser.quantityTable.get(type_name).value();
    switch (v) {
      case "Real":
        ctx.res = new RealType();
        break;
      case "Integer":
        ctx.res = new IntegerType();
        break;
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

}