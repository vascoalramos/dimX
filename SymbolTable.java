import java.util.Map;
import java.util.HashMap;

/**
 * This class is responsible for save all the variables defined by the
 * programmer. It has a private Map, where the keys are Strings and the values
 * are Symbols.
 */
public class SymbolTable {
    /**
     * HashMap to save all the variables and their values.
     */
    private Map<String, Symbol> table = new HashMap<>();

    /**
     * Check if the symbol table contains a given variable name.
     * 
     * @param name Name of the variable.
     * @return true or false.
     */
    public boolean exists(String name) {
        return table.containsKey(name);
    }

    /**
     * Put a new variable and its value on the symbol table.
     * 
     * @param name  Name of the new variable.
     * @param value Value of the new variable.
     */
    public void put(String name, Symbol value) {
        table.put(name, value);
    }

    /**
     * Get the value (Symbol) of a given variable.
     * 
     * @param name Name of the variable.
     * @return Value (Symbol) of the variable.
     */
    public Symbol get(String name) {
        return table.get(name);
    }
}