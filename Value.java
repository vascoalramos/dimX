/**
 * Abstract class for a specific primitive value. There are four possible
 * values: Integer, Real, Boolean and String.
 */
public abstract class Value {

    /**
     * Get Type object.
     * 
     * @return Type.
     */
    public Type type() {
        assert false;
        return null;
    }

    /**
     * Set the Integer value.
     * 
     * @param val value to be set.
     */
    public void setIntValue(int val) {
        assert false;
    }

    /**
     * Set the Real value.
     * 
     * @param val value to be set.
     */
    public void setRealValue(double val) {
        assert false;
    }

    /**
     * Set the Boolean Value
     * 
     * @param val value to be set.
     */
    public void setBoolValue(boolean val) {
        assert false;
    }

    /**
     * Set the String value.
     * 
     * @param val value to be set.
     */
    public void setStringValue(String val) {
        assert false;
    }

    /**
     * Get the Integer value.
     * 
     * @return integer value.
     */
    public int intValue() {
        assert false;
        return 0;
    }

    /**
     * Get the Real value.
     * 
     * @return real value.
     */
    public double realValue() {
        assert false;
        return 0;
    }

    /**
     * Get the Boolean value.
     * 
     * @return boolean value.
     */
    public boolean boolValue() {
        assert false;
        return false;
    }

    /**
     * Get the String value.
     * 
     * @return string value.
     */
    public String stringValue() {
        assert false;
        return "";
    }
}