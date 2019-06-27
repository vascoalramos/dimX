public class IntegerType extends Type {
    public IntegerType() {
        super("Integer");
    }

    public boolean isNumeric() {
        return true;
    }

    @Override public boolean conformsTo(Type other) {
        return super.conformsTo(other) || other.name().equals("real");
    }
}