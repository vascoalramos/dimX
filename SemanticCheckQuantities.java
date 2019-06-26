import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SemanticCheckQuantities extends QuantitiesBaseVisitor<String> {
    private Map<String, Type> typeTable = new HashMap<>();

    @Override
    public String visitMain(QuantitiesParser.MainContext ctx) {
        Iterator<QuantitiesParser.StatContext> iter = ctx.stat().iterator();
        while(iter.hasNext()) {
            visit(iter.next());
        }
        return "success";
    }

    @Override
    public String visitQuantity_declare(QuantitiesParser.Quantity_declareContext ctx) {
        String typeName = ctx.ID().getText();
        if (typeTable.containsKey(typeName)) {
            ErrorHandling.printError(ctx, "Quantity \"" + typeName + "\" already declared!");
            return null;
        }
        String value = visit(ctx.type());
        String [] tokens=value.split("-");
        System.out.println(value);


        typeTable.put(typeName,new Type(tokens[0],tokens[1]));
        return "success";
    }

    @Override
    public String visitSimpleType(QuantitiesParser.SimpleTypeContext ctx) {
        String unit=visit(ctx.unit()),value=visit(ctx.value());

        return unit+"-"+value;
    }

    @Override
    public String visitComplexType(QuantitiesParser.ComplexTypeContext ctx) {
        String var1=ctx.e1.getText(),var2=ctx.e2.getText(),unit=visit(ctx.unit());
        
        if (!typeTable.containsKey(var1)) {
            ErrorHandling.printError(ctx, "Quantity \"" + var1 + "\" already declared!");
            return null;
        }
        if (!typeTable.containsKey(var2)) {
            ErrorHandling.printError(ctx, "Quantity \"" + var2 + "\" already declared!");
            return null;
        }
        Type a,b;
        a=typeTable.get(var1);
        b=typeTable.get(var2);
        
        
        return ;
    }

    @Override
    public String visitValue(QuantitiesParser.ValueContext ctx) {
        return ctx.getText();
    }

    @Override
    public String visitUnit(QuantitiesParser.UnitContext ctx) {
        return ctx.getText().replace("[","").replace("]","");
    }

    @Override
    public String visitPrefix_declare(QuantitiesParser.Prefix_declareContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public String visitNumber_type(QuantitiesParser.Number_typeContext ctx) {
        return visitChildren(ctx);
    }

}