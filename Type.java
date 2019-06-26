import java.util.ArrayList;
import java.util.List;

public class Type {
   private String value;
   private List<String> units = new ArrayList<>();

   public Type(String value, String unit) {
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
