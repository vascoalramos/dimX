/** Derived class from abstract class Type.
 * It implements a concrete Boolean Type object.
 * Check Type class documentation for more details.
 */
public class BooleanType extends Type {
    
    public BooleanType() {
        super("Boolean"); 
    }

    @Override
    public boolean isBoolean(){
        return true;
    }
}