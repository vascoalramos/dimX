/**
 * Derived class from abstract class Value. It implements a concrete String
 * Value object. Check Value class documentation for more details.
 */
public class StringValue extends Value {

    private String val;
    private static StringType type = new StringType();

    public StringValue(String val) {
        setStringValue(val);
    }

    @Override
    public Type type() {
        return type;
    }

    @Override
    public void setStringValue(String val) {
        this.val = val;
    }

    @Override
    public String stringValue() {
        return val;
    }

    @Override
    public String toString() {
        return "" + val;
    }
}