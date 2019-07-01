import java.util.*;

public class QuantityTable {

    private HashMap<String, Quantity> table = new HashMap<String, Quantity>();

    public boolean exists(String name) {
        return table.containsKey(name);
    }

    public void put(String name, Quantity value) {
        table.put(name, value);
    }

    public Quantity get(String name) {
        return table.get(name);
    }

    public Collection<Quantity> values() {
        return table.values();
    }
}