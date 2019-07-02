import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * This class is responsible for the semantic analysis of the rules defined in
 * Quantities.g4 grammar. It uses the visitor software pattern to visit each
 * rule in the syntatic tree. This class extends the QuantitiesBaseVisitor all
 * methos are overriden.
 */
public class SemanticCheckQuantities extends QuantitiesBaseVisitor<String> {

    /**
     * The first rule to visit in the syntatic tree. It visits all the present
     * statements in the syntatic tree using the software pattern iterator.
     */
    @Override
    public String visitMain(QuantitiesParser.MainContext ctx) {
        Iterator<QuantitiesParser.StatContext> iter = ctx.stat().iterator();
        while (iter.hasNext()) {
            visit(iter.next());
        }
        return "success";
    }

    /**
     * This method checks if a quantity is already declared. If it is already
     * declared, a semantic error is thrown. If not, the quantity is saved in the
     * quantities table.
     */
    @Override
    public String visitQuantity_declare(QuantitiesParser.Quantity_declareContext ctx) {
        String typeName = ctx.TYPE_ID().getText();

        Boolean checkUnit = true, check = true;

        if (QuantitiesParser.quantityTable.exists(typeName)) {
            ErrorHandling.printError(ctx, "Quantity \"" + typeName + "\" already declared!");
            check = false;
        }

        String value = visit(ctx.type());

        if (value != null) {
            String[] tokens = value.split("-");
            for (Quantity q : QuantitiesParser.quantityTable.values()) {
                if (!q.checkUnit(tokens[0])) {
                    checkUnit = false;
                    break;
                }
            }

            if (!checkUnit) {
                ErrorHandling.printError(ctx, "Unit \"" + tokens[0] + "\" already present in another Quantity!");
                return null;
            } else {
                if (!check) { // Se o primeiro erro ja occorreu e verificamos que o segundo nao chegou a
                              // ocorrer, nao podemos continuar na mesma
                    return null;
                }
                String temp = "";
                switch (tokens[1]) {
                case "real":
                    temp = "Real";
                    break;
                case "int":
                    temp = "Integer";
                    break;
                }
                QuantitiesParser.quantityTable.put(typeName, new Quantity(temp, tokens[0], typeName));
            }
        } else {
            return null;
        }
        return "success";
    }

    /**
     * This method is visited when a simple type is declared. i.e.: Distance : real
     * [m];
     */
    @Override
    public String visitSimpleType(QuantitiesParser.SimpleTypeContext ctx) {
        String unit = visit(ctx.unit()), value = visit(ctx.value());
        return unit + "-" + value;
    }

    /**
     * When a complex type is declared, this method checks if the quantities that
     * compose it had already been declared too.
     */
    @Override
    public String visitComplexType(QuantitiesParser.ComplexTypeContext ctx) {
        String var1 = ctx.e1.getText(), var2 = ctx.e2.getText(), unit = visit(ctx.unit()), value = "";
        String operand = ctx.op.getText(), unitOp = ctx.unit().op.getText();
        Boolean check = true;

        if (!QuantitiesParser.quantityTable.exists(var1)) {
            ErrorHandling.printError(ctx, "Quantity \"" + var1 + "\" not defined!");
            check = false;
        }

        if (!QuantitiesParser.quantityTable.exists(var2)) {
            ErrorHandling.printError(ctx, "Quantity \"" + var2 + "\" not defined!");
            check = false;
        }

        if (!operand.equals(unitOp)) {
            ErrorHandling.printError(ctx,
                    "Unit operand \"" + unitOp + "\" does not match to operation \"" + operand + "\"!");
            check = false;
        }

        Quantity a, b;

        a = QuantitiesParser.quantityTable.get(var1);
        b = QuantitiesParser.quantityTable.get(var2);

        String[] units = unit.split("\\" + unitOp);
        if (a.checkUnit(units[0])) {
            ErrorHandling.printError(ctx, "Unit \"" + units[0] + "\" does not match to unit from \"" + a + "\"!");
            check = false;
        }
        if (b.checkUnit(units[1])) {
            ErrorHandling.printError(ctx, "Unit \"" + units[1] + "\" does not match to unit from \"" + b + "\"!");
            check = false;
        }

        if (!check) {
            return null;
        }

        if (a.value().equals(b.value()))
            value = a.value();
        else
            value = "real";

        return unit + "-" + value;
    }

    /**
     * This method gets the text of a value.
     */
    @Override
    public String visitValue(QuantitiesParser.ValueContext ctx) {
        return ctx.getText();
    }

    /**
     * This method gets the text of an unit.
     */
    @Override
    public String visitUnit(QuantitiesParser.UnitContext ctx) {
        return ctx.getText().replace("[", "").replace("]", "");
    }

}