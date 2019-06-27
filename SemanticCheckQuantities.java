import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SemanticCheckQuantities extends QuantitiesBaseVisitor<String> {

    @Override
    public String visitMain(QuantitiesParser.MainContext ctx) {
        Iterator<QuantitiesParser.StatContext> iter = ctx.stat().iterator();
        while (iter.hasNext()) {
            visit(iter.next());
        }
        return "success";
    }

    @Override
    public String visitQuantity_declare(QuantitiesParser.Quantity_declareContext ctx) {
        String typeName = ctx.ID().getText();
        if (QuantitiesParser.quantityTable.exists(typeName)) {
            ErrorHandling.printError(ctx, "Quantity \"" + typeName + "\" already declared!");
            return null;
        }

        String value = visit(ctx.type());
        if (value != null) {
            String[] tokens = value.split("-");
            QuantitiesParser.quantityTable.put(typeName, new Quantity(tokens[1], tokens[0]));

        } else {
            return null;
        }

        return "success";
    }

    @Override
    public String visitSimpleType(QuantitiesParser.SimpleTypeContext ctx) {
        String unit = visit(ctx.unit()), value = visit(ctx.value());

        return unit + "-" + value;
    }

    @Override
    public String visitComplexType(QuantitiesParser.ComplexTypeContext ctx) {
        String var1 = ctx.e1.getText(), var2 = ctx.e2.getText(), unit = visit(ctx.unit()), value = "";
        Boolean check = true;

        if (!QuantitiesParser.quantityTable.exists(var1)) {
            ErrorHandling.printError(ctx, "Quantity \"" + var1 + "\" not defined!");
            check = false;
        }
        if (!QuantitiesParser.quantityTable.exists(var2)) {
            ErrorHandling.printError(ctx, "Quantity \"" + var2 + "\" not defined!");
            check = false;
        }

        if (!check) {
            return null;
        }

        Quantity a, b;

        a = QuantitiesParser.quantityTable.get(var1);
        b = QuantitiesParser.quantityTable.get(var2);
        if (a.value().equals(b.value()))
            value = a.value();
        else
            value = "real";

        return unit + "-" + value;
    }

    @Override
    public String visitValue(QuantitiesParser.ValueContext ctx) {
        return ctx.getText();
    }

    @Override
    public String visitUnit(QuantitiesParser.UnitContext ctx) {
        return ctx.getText().replace("[", "").replace("]", "");
    }

}