/**
 * Abstract class for a specific primitive type. It has a name and can be
 * numeric or not.
 */
public abstract class Type {

    protected final String name;

    /**
     * Creates a Type with the specified name.
     * 
     * @param name A string representing the Type name.
     */
    protected Type(String name) {
        assert name != null;
        this.name = name;
    }

    /**
     * Gets the Type name.
     * 
     * @return A string representing the Type name.
     */
    public String name() {
        return name;
    }

    /**
     * Check if 'this' is equal to another Type.
     * 
     * @param other Another Type to compare with 'this'
     * @return true or false
     */
    public boolean conformsTo(Type other) {
        return name.equals(other.name());
    }

    /**
     * Check if 'this' is numeric or not.
     * 
     * @return true or false
     */
    public boolean isNumeric() {
        return false;
    }

    /**
     * Check if 'this' is boolean or not
     * 
     * @return true or false
     */
    public boolean isBoolean() {
        return false;
    }

    /**
     * Type object to String
     * 
     * @return A string representing the Type name.
     */
    @Override
    public String toString() {
        return name;
    }

    /**
     * Special method that will be overridden in extended classes.
     * 
     * @return A string representing the Type name.
     */
    public String getType() {
        return name;
    }
}