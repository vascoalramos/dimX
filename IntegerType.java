/** Derived class from abstract class Type.
 * It implements a concrete Integer Type object.
 * Check Type class documentation for more details.
 */
public class IntegerType extends Type {
    
    public IntegerType() {
        super("Integer");
    }

    @Override
    public boolean isNumeric() {
        return true;
    }
    /** Check if 'this' is equal to another IntegerType or RealType.
     * @param other Another Type to compare with 'this'
     * @return true or false
     */
    @Override
    public boolean conformsTo(Type other) {
        return super.conformsTo(other) || other.name().equals("real");
    }
}