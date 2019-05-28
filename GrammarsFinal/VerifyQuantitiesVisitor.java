import java.util.*;

public class VerifyQuantitiesVisitor extends QuantitiesBaseVisitor<String> {
    private HashMap<String, String[]> quantityMap = new HashMap<>();

    @Override
    public String visitQuantity_decl(QuantitiesParser.Quantity_declContext ctx) {
        System.out.println(ctx.e1.getText());

        if (quantityMap.containsKey(ctx.e1.getText())) {
            System.out.println("ola");
        } else {
            List<String[]> list = new ArrayList<String[]>(quantityMap.values());
            String [] tokens=visit(ctx.type()).split(" ");
            String check = tokens[1].replace("[]","");
            System.out.println(check);
            String[] value = { tokens[0], check };

            if (list.contains(value)) {
                System.out.println("ola1");
            } else {
                quantityMap.put(ctx.e1.getText(), value);
            }
        }
        return visitChildren(ctx);
    }

    @Override
    public String visitComplx_quantity_decl(QuantitiesParser.Complx_quantity_declContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public String visitType(QuantitiesParser.TypeContext ctx) {
        String str=ctx.e3.getText()+" "+ctx.e4.getText();
        return str;
    }

}