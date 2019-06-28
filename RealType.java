public class RealType extends Type {
    public RealType() {
        super("Real");
    }

    public boolean isNumeric() {
        return true;
    }

    public boolean conformsTo(Type other) {
        if (other.name().equals("Integer")) {
            return true;
        }
        return name.equals(other.name());
    }
}