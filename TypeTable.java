import java.util.*;
public class TypeTable
{
    
    public boolean exists(String name){ 
        
        return table.containsKey(name);
    }

    public void put(String name, Type value){
        table.put(name,value);
    } 

    public Type get(String name){
        return table.get(name);
    }

    private HashMap<String,Type> table=new HashMap<String,Type>();
} 