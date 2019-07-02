import java.util.*;

/**
 * This class is responsible for save all the Quantities defined by the
 * programmer. It has a private Map, where the keys are Strings and the values
 * are Quantities.
 */
public class QuantityTable {
    /**
     * HashMap to save all the Quantities and their values.
     */
    private HashMap<String, Quantity> table = new HashMap<String, Quantity>();

    /**
     * Check if the quantities table contains a given variable name.
     * 
     * @param name Name of the variable.
     * @return true or false.
     */
    public boolean exists(String name) {
        return table.containsKey(name);
    }

    /**
     * Put a new variable and its value on the quantities table.
     * 
     * @param name  Name of the new variable.
     * @param value Value of the new variable.
     */
    public void put(String name, Quantity value) {
        table.put(name, value);
    }

    /**
     * Get the value (Quantity) of a given variable.
     * 
     * @param name Name of the variable.
     * @return Value (Quantity) of the variable.
     */
    public Quantity get(String name) {
        return table.get(name);
    }

    /**
     * Get all the values (Quantity) in the quantities table.
     * 
     * @return A collection of quantities (Collection of Quantity)
     */
    public Collection<Quantity> values() {
        return table.values();
    }
}