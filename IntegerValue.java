/**
 * Derived class from abstract class Value. It implements a concrete Integer
 * Value object. Check Value class documentation for more details.
 */
public class IntegerValue extends Value {

    private int val;
    private static IntegerType type = new IntegerType();

    public IntegerValue(int val) {
        setIntValue(val);
    }

    @Override
    public Type type() {
        return type;
    }

    @Override
    public void setIntValue(int val) {
        this.val = val;
    }

    @Override
    public int intValue() {
        return val;
    }

    @Override
    public String toString() {
        return "" + val;
    }
}