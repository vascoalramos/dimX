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
    
    @Override public stringValue() {
        return val;
    }
    
    @Override
    public String toString() {
        return "" + val;
    }
}