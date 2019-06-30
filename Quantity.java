import java.util.ArrayList;
import java.util.Iterator;
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
      Boolean check;
      if(!other.getClass().getName().equals("Quantity")){
         check=(super.conformsTo(other) || other.name().equals("Real")) || this.value.equals(other.name);

      }else{
         Quantity temp=(Quantity) other;
         check=(super.conformsTo(other) || other.name().equals("Real")) || this.value.equals(temp.value());

      }
      return check;
  }

   public String value() {
      return value;
   }

   public List<String> unit() {
      return this.units;
   }

   public boolean checkUnit(String unit) {
      Iterator<String> it=units.listIterator();
      while(it.hasNext()){
         if(it.next().equals(unit))
            return false;
      }
      return true;
   }
}
