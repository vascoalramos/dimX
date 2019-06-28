import java.util.ArrayList;
import java.util.List;

public class Quantity extends Type {
   private String value;
   private List<String> units = new ArrayList<>();

   public Quantity(String value, String unit,String name) {
      super(name);
      assert value != null;
      assert unit != null;
      this.value = value;
      this.units.add(unit);
   }

   public Quantity(String name){
      super(name);
   }

   public boolean isNumeric(){
      return true;
   }

   @Override public boolean conformsTo(Type other) { // compor esta merda
      return super.conformsTo(other) || other.name().equals("real");
  }

   public String value() {
      return value;
   }

   public List<String> unit() {
      return this.units;
   }
}
