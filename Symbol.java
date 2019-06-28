public class Symbol {

    private final String name;
    private final Type type;
    private Value value;
    private boolean valueDefined;
    private String varName;

    private String dimension = "Adimensional";
    private String unit = "Void";


    public Symbol(String name, Type type) {
        assert name != null;
        assert type != null;
        this.name = name;
        this.type = type;
    }

    
    public void setDimension(String dimension){
        assert dimension != null;

        this.dimension = dimension;
    }

    public void setUnit(String unit){
        assert unit != null;

        this.unit = unit;
    }

    public void setValue(Value value) {
        assert value != null;

        this.value = value;
    }

    public String name() {
        return name;
    }

    public void setVarName(String varName) {
        assert varName != null;

        this.varName = varName;
    }

    public String varName() {
        return varName;
    }

    public Type type() {
        return type;
    }

    public String dimension() {
        return this.dimension;
    }

    public String unit() {
        return this.unit;
    }


    public void setValueDefined() {
        valueDefined = true;
    }

    public boolean valueDefined() {
        return valueDefined;
    }

    public Value value() {
        assert valueDefined();

        return value;
    }


    public boolean conformsToDimension(String otherDimension) {
        if(this.dimension.equals(otherDimension)){
            return true;
        }
        return false;
    }
}