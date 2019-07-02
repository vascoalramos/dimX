import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/** Derived class from abstract class Type.
 * It implements a concrete Quantity Type.
 * This Quantity Type is defined by the programmer.
 * Check Type class documentation for more details.
 */
public class Quantity extends Type {
   /**
    * Value: Attribute representing the concrete primitive type of the Quantity.
   */
   private String value;
   /**
    * units: List of units of the new Quantity. i.e.: meters and seconds for Velocity.
    */
   private List<String> units = new ArrayList<>();

   /** Constructor of Quantity class.
    * @param value Value of the new Quantity.
    * @param unit Unit to express the new Quantity. i.e.: meters
    * @param name Name of the new Quantity.
    */
   public Quantity(String value, String unit, String name) {
      super(name);
      assert value != null;
      assert unit != null;
      this.value = value;
      this.units.add(unit);
   }

   public Quantity(String name) {
      super(name);
   }
   
   /** All new Quantities should be numeric.
    * @return always true
    */
   @Override
   public boolean isNumeric() {
      return true;
   }

   /** Check if 'this' is equal to another Type.
   * @param other Another Type to compare with 'this'
   * @return true or false
   */
   @Override
   public boolean conformsTo(Type other) {
      Boolean check;
      if (!other.getClass().getName().equals("Quantity")) {
         check = (super.conformsTo(other) || this.value.equals(other.name()) || this.value.equals(other.name));
      } else {
         Quantity temp = (Quantity) other;
         check = (super.conformsTo(other) || this.value.equals(other.name()) || this.value.equals(temp.value()));
      }
      return check;
   }

   /**
    * @return String representing the value of the Quantity.
    */
   public String value() {
      return value;
   }

   /**
    * @return List of all units of the Quantity.
    */
   public List<String> unit() {
      return this.units;
   }

   /** Check if the Quantity already has a specific unit.
    * @param unit Unit to be checked.
    * @return true or false.
    */
   public boolean checkUnit(String unit) {
      Iterator<String> it = units.listIterator();
      while (it.hasNext()) {
         if (it.next().equals(unit))
            return false;
      }
      return true;
   }

   /** Get the primitive type of a Quantity.
    * @return A string that can be "Integer" or "Real"
    */
   @Override
   public String getType() {
      if (value.equals("int"))
         return "Integer";
      else if (value.equals("real"))
         return "Real";
      return value;
   }
}
