import javax.print.DocFlavor.STRING;

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
        ctx.dimension = sym.dimension();
        ctx.unit = sym.unit();
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
        String unitSym = sym.unit();

        if (sym.type().getClass().getName().equals("Quantity")) {
          if (ctx.expr().unit != null) {
            String unit = ctx.expr().unit.replace("[", "").replace("]", "");
            if (!unitSym.equals(unit)) {
              ErrorHandling.printError(ctx, "Prefix \"" + unit + "\" not declared for dimension " + sym.name());
              res = false;

            }
          } else {
            ErrorHandling.printError(ctx, "You need to indicate a prefix for  \"" + sym.name() + "\"  dimension");
            res = false;
          }

        }
        if (res) {
          if (!sym.type().conformsTo(ctx.expr().exprType)) {
            ErrorHandling.printError(ctx, "Expression type does not conform to variable \"" + id + "\" type!");
            res = false;

          } else
            sym.setValueDefined();

        }

      }
    }
    return res;
  }

  @Override
  public Boolean visitDeclareAndAssign(GeneralParser.DeclareAndAssignContext ctx) {
    Boolean res = true; // visit(ctx.expr());
    String id = ctx.declaration().ID().getText();
    visit(ctx.expr());
    if (res) {
      if (GeneralParser.map.exists(id)) {
        ErrorHandling.printError(ctx, "Variable \"" + id + "\" already declared!");
        res = false;
      } else {
        res = visit(ctx.declaration().type());
        if (res) {
          Type type = ctx.declaration().type().res;
          if (type.getClass().getName().equals("Quantity")) {
            if (ctx.expr().unit != null) {
              String unit = ctx.expr().unit.replace("[", "").replace("]", "");
              Quantity temp = (Quantity) type;
              if (temp.checkUnit(unit)) {
                ErrorHandling.printError(ctx, "Prefix \"" + unit + "\" not declared for dimension " + temp.name());
                res = false;

              }
            } else {
              ErrorHandling.printError(ctx,
                  "You need to indicate a prefix for  \"" + ctx.declaration().type().getText() + "\"  dimension");
              res = false;
            }
          }
          if (res) {
            Symbol s = new Symbol(id, type);
            // System.out.println(ctx.expr().exprType);
            if (!s.type().conformsTo(ctx.expr().exprType)) {
              ErrorHandling.printError(ctx, "Expression type does not conform to variable \"" + id + "\" type!");
              res = false;
            } else {
              s.setValueDefined();
              GeneralParser.map.put(id, s);
            }

          }
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

  @Override
  public Boolean visitAddSub(GeneralParser.AddSubContext ctx) {
    // check if there weren' errors in e1 and e2 and if both are numeric
    Boolean check = visit(ctx.e1) && visit(ctx.e2) && checkBooleanType(ctx, ctx.e1.exprType)
        && checkBooleanType(ctx, ctx.e2.exprType);

    // check if both belong to the same dimension
    check = checkDimension(ctx, ctx.e2.dimension, ctx.e1.dimension);
    //System.out.println(ctx.e1.unit);
    if (ctx.e2.unit.equals("Void") & ctx.e1.unit.equals("Void")) {
      ctx.unit = "Void";

    } else if ((ctx.e2.unit.equals("Void") & !ctx.e1.unit.equals("Void"))
        | (ctx.e1.unit.equals("Void") & !ctx.e2.unit.equals("Void"))) {
      ErrorHandling.printError(ctx, "You must specify unit for both operads");
      check = false;
    } else if (!ctx.e2.unit.equals("Void") & !ctx.e1.unit.equals("Void")) {
      String unit1 = ctx.e1.unit, unit2 = ctx.e2.unit;

      if (unit1.equals(unit2)) {
        ctx.unit = unit1;

      } else {
        ErrorHandling.printError(ctx, "Both operands must have the same unit");
        check = false;
      }

    }

    // check if both belong to the same dimension
    // check = checkDimension(ctx, ctx.e2.dimension, ctx.e1.dimension);

    // check if both have same unit? check if unit belongs to that dimension

    // assign same type (Real,Integer,...) to operands. Maybe we should assign same
    // unit??
    if (check) {
      Type tp = fetchType(ctx.e1.exprType, ctx.e2.exprType, ctx.op.getText());
      if (tp == null) {
        ErrorHandling.printError(ctx, "Numeric operator applied to a non-numeric operand!");
        check = false;
      } else
        ctx.exprType = tp;
      ctx.dimension = ctx.e2.dimension;

    }

    return check;
  }

  /* Conditional expressions */
  @Override
  public Boolean visitConditionalAndOr(GeneralParser.ConditionalAndOrContext ctx) {
    visit(ctx.e1);
    visit(ctx.e2);
    Boolean res = true;
    if (!ctx.e1.exprType.conformsTo(booleanType) || !ctx.e2.exprType.conformsTo(booleanType)) {
      ErrorHandling.printError(ctx, "Bad operand types for operator \"" + ctx.op.getText() + "\"");
      res = false;
    }
    ctx.exprType = booleanType;
    return res;
  }

  @Override
  public Boolean visitConditionalRelational(GeneralParser.ConditionalRelationalContext ctx) {
    visit(ctx.e1);
    visit(ctx.e2);

    Boolean res = true;
    if (!ctx.e1.exprType.isNumeric() || !ctx.e2.exprType.isNumeric()) {
      ErrorHandling.printError(ctx, "Bad operand types for operator \"" + ctx.op.getText() + "\"");
      res = false;
    }
    return res;
  }

  @Override
  public Boolean visitConditionalEquality(GeneralParser.ConditionalEqualityContext ctx) {
    String operation = ctx.op.getText();
    visit(ctx.e1);
    visit(ctx.e2);
    Boolean res = true;
    if (operation.equals("===") || operation.equals("!==")) {
      if (!ctx.e1.exprType.conformsTo(stringType) || !ctx.e2.exprType.conformsTo(stringType)) {
        ErrorHandling.printError(ctx, "Bad operand types for operator \"" + operation + "\"");
        res = false;
      }
    } else {
      if (ctx.e1.exprType.conformsTo(stringType) || ctx.e2.exprType.conformsTo(stringType)) {
        ErrorHandling.printError(ctx, "Bad operand types for operator \"" + operation + "\"");
        res = false;
      } else if ((ctx.e1.exprType.conformsTo(booleanType) || ctx.e2.exprType.conformsTo(booleanType))
          && !ctx.e1.exprType.conformsTo(ctx.e2.exprType)) {
        ErrorHandling.printError(ctx, "Bad operand types for operator \"" + operation + "\"");
        res = false;
      }
    }
    return res;
  }

  @Override
  public Boolean visitConditionalNegation(GeneralParser.ConditionalNegationContext ctx) {
    visit(ctx.expr());
    Boolean res = true;
    if (!ctx.expr().exprType.conformsTo(booleanType)) {
      ErrorHandling.printError(ctx, "Bad operand type for operator \"not\"");
      res = false;
    }
    ctx.exprType = booleanType;
    return res;
  }

  public Boolean visitMultDiv(GeneralParser.MultDivContext ctx) {
    Boolean check = visit(ctx.e1) && visit(ctx.e2) && checkBooleanType(ctx, ctx.e1.exprType)
        && checkBooleanType(ctx, ctx.e2.exprType);
    String op = ctx.op.getText();
    // associate dimension and calculate new unit
    if (check) {
      Type t1 = ctx.e1.exprType;
      Type t2 = ctx.e2.exprType;
      ctx.dimension = ctx.e1.dimension;

      if (ctx.e2.unit.equals("Void") & ctx.e1.unit.equals("Void")) {
        ctx.unit = "Void";

      } else if ((ctx.e2.unit.equals("Void") & !ctx.e1.unit.equals("Void"))
          | (ctx.e1.unit.equals("Void") & !ctx.e2.unit.equals("Void"))) {
        ErrorHandling.printError(ctx, "You must specify unit for both operads");
        check = false;
      } else if (!ctx.e2.unit.equals("Void") & !ctx.e1.unit.equals("Void")) {
        String unit1 = ctx.e1.unit, unit2 = ctx.e2.unit;
        switch (op) {
        case "*": {
          ctx.unit = unit1 + "." + unit2;
          break;
        }
        case "/": {
          ctx.unit = unit1 + "/" + unit2;
          break;
        }
        }

      }
      if (check) {
        if (!t1.isNumeric() && !t2.isNumeric()) {
          ErrorHandling.printError(ctx, "Bad operand types for operator \"" + ctx.op.getText() + "\"");
          check = false;
        } else if (ctx.e1.exprType.equals(realType) || ctx.e2.exprType.equals(realType))
          ctx.exprType = realType;
        else
          ctx.exprType = integerType;

      }

    }

    return check;
  }

  @Override
  public Boolean visitPow(GeneralParser.PowContext ctx) {
    Boolean check = visit(ctx.e1) && visit(ctx.e2) && checkBooleanType(ctx, ctx.e1.exprType)
        && checkBooleanType(ctx, ctx.e2.exprType);

    if(ctx.e2.dimension!="Adimensional" | ctx.e2.unit!="Void" | ctx.e2.exprType.equals(realType)){
      ErrorHandling.printError(ctx, "Bad operand types for exponent \"" + ctx.e2.getText() + "\"");
      check = false;
    }

    if(check){
      Type t1 = ctx.e1.exprType;
      Type t2 = ctx.e2.exprType;
      if (!t1.isNumeric() && !t2.isNumeric()) {
        ErrorHandling.printError(ctx, "Bad operand types for operator ^");
        check = false;
      }
      ctx.unit=ctx.e1.unit;
      ctx.dimension=ctx.e1.dimension;
      ctx.exprType=ctx.e1.exprType;

    }
    return check;
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
    Quantity v = QuantitiesParser.quantityTable.get(type_name);
    ctx.res = v;
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
    ctx.dimension = "Adimensional";
    ctx.unit = "Void";

    return true;
  }

  @Override
  public Boolean visitIntValue(GeneralParser.IntValueContext ctx) {
    ctx.exprType = integerType;
    if (ctx.unitID() != null) {
      Boolean check = false;
      String unit = ctx.unitID().getText().replace("[", "").replace("]", "");
      for (Quantity q : QuantitiesParser.quantityTable.values()) {
        if (!q.checkUnit(unit)) {
          ctx.dimension = q.name();
          ctx.unit = unit;
          check = true;
        }
      }
      if (!check) {
        ErrorHandling.printError(ctx, "Prefix \"" + ctx.unitID().getText() + "\" does not exist!");
        return false;
      }
    } else {
      ctx.dimension = "Adimensional";
      ctx.unit = "Void";
    }
    return true;
  }

  @Override
  public Boolean visitRealValue(GeneralParser.RealValueContext ctx) {
    ctx.exprType = realType;

    if (ctx.unitID() != null) {
      Boolean check = false;
      String unit = ctx.unitID().getText().replace("[", "").replace("]", "");
      for (Quantity q : QuantitiesParser.quantityTable.values()) {
        if (!q.checkUnit(unit)) {
          ctx.dimension = q.name();
          ctx.unit = unit;
          check = true;
        }
      }
      if (!check) {
        ErrorHandling.printError(ctx, "Prefix \"" + ctx.unitID().getText() + "\" does not exist!");
        return false;
      }
    } else {
      ctx.dimension = "Adimensional";
      ctx.unit = "Void";
    }

    return true;
  }

  @Override
  public Boolean visitStringValue(GeneralParser.StringValueContext ctx) {
    ctx.exprType = stringType;
    ctx.dimension = "Adimensional";
    ctx.unit = "Void";
    return true;
  }

  private Boolean checkBooleanType(ParserRuleContext ctx, Type t) {
    Boolean res = true;
    if (t.isBoolean()) {
      ErrorHandling.printError(ctx, "Numeric operator applied to a non-numeric operand!");
      res = false;
    }
    return res;
  }

  private Type fetchType(Type t1, Type t2, String op) {
    Type res = null;
    if (t1.isNumeric() && t2.isNumeric()) {
      if ("Real".equals(t1.name()))
        res = t1;
      else if ("Real".equals(t2.name()))
        res = t2;
      else
        res = t1;
    } else if ("String".equals(t1.name()) && op.equals("+")) {
      res = t1;
    } else if ("String".equals(t2.name()) && op.equals("+")) {
      res = t2;
    } else if ("Boolean".equals(t1.name()) && "Boolean".equals(t2.name()))
      res = t1;
    return res;
  }

  private Boolean checkDimension(ParserRuleContext ctx, String dimensionA, String dimensionB) {
    Boolean res = true;

    if (!dimensionA.equals(dimensionB)) {
      ErrorHandling.printError(ctx, "Can't perform sums and subtractions on operands from diferent dimensions");
      res = false;
    }
    return res;
  }

}