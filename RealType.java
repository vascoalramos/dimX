/**
 * Derived class from abstract class Type. It implements a concrete Boolean Type
 * object. Check Type class documentation for more details.
 */
public class RealType extends Type {

    public RealType() {
        super("Real");
    }

    @Override
    public boolean isNumeric() {
        return true;
    }

    @Override
    public boolean conformsTo(Type other) {
        if (other.name().equals("Integer")) {
            return true;
        }
        return name.equals(other.name());
    }
}