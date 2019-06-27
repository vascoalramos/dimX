import java.util.*;
public class SymbolTable
{
    
    public boolean exists(String name){ 
        
        return table.containsKey(name);
    }

    public void put(String name, String value){
        table.put(name,value);
    } 

    public String get(String name){
        return table.get(name);
    }

    private HashMap<String,String> table=new HashMap<String,String>();
} 