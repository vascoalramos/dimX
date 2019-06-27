import java.util.ArrayList;
import java.util.List;

public class Quantity {
   private String value;
   private List<String> units = new ArrayList<>();

   public Quantity(String value, String unit) {
      assert value != null;
      assert unit != null;
      this.value = value;
      this.units.add(unit);
   }

   public String value() {
      return value;
   }

   public List<String> unit() {
      return this.units;
   }
}
