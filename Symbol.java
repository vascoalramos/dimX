/**
 * This class implements a specific Symbol. Essentially, a Symbol is a variable.
 * A Symbol has a name and a Type.
 */
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

    /**
     * Set the dimension of the Symbol.
     * 
     * @param dimension Dimension to be set.
     */
    public void setDimension(String dimension) {
        assert dimension != null;

        this.dimension = dimension;
    }

    /**
     * Set the unit of the Symbol.
     * 
     * @param unit Unit to be set.
     */
    public void setUnit(String unit) {
        assert unit != null;

        this.unit = unit;
    }

    /**
     * Set the value of the Symbol.
     * 
     * @param value Value to be set.
     */
    public void setValue(Value value) {
        assert value != null;

        this.value = value;
    }

    /**
     * Get the name of the Symbol.
     * 
     * @return A string representing the name of the Symbol.
     */
    public String name() {
        return name;
    }

    /**
     * Set the variable name of the Symbol in the output language.
     * 
     * @param varName Mame of the variable in the output language.
     */
    public void setVarName(String varName) {
        assert varName != null;

        this.varName = varName;
    }

    /**
     * Get the variable name of the Symbol in the output languge.
     * 
     * @return A string representing the output variable name.
     */
    public String varName() {
        return varName;
    }

    /**
     * Get the Type of the Symbol.
     * 
     * @return Type of the Symbol.
     */
    public Type type() {
        return type;
    }

    /**
     * Get the dimension of the Symbol.
     * 
     * @return A string representing the dimension of the Symbol.
     */
    public String dimension() {
        return this.dimension;
    }

    /**
     * Get the unit of the Symbol.
     * 
     * @return A string representing the unit of the Symbol.
     */
    public String unit() {
        return this.unit;
    }

    /**
     * Set that the Symbol value was defined.
     */
    public void setValueDefined() {
        valueDefined = true;
    }

    /**
     * Check if the Symbol value is defined.
     * 
     * @return true or false.
     */
    public boolean valueDefined() {
        return valueDefined;
    }

    /**
     * Get the value of the Symbol.
     * 
     * @return Value of the Symbol.
     */
    public Value value() {
        assert valueDefined();

        return value;
    }

    /**
     * Check if 'this' dimension is equals to 'otherDimension'
     * 
     * @param otherDimension Another dimension to be compared.
     * @return true or false.
     */
    public boolean conformsToDimension(String otherDimension) {
        if (this.dimension.equals(otherDimension)) {
            return true;
        }
        return false;
    }
}