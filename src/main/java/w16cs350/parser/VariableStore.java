package w16cs350.parser;

import w16cs350.datatype.CoordinatesWorld;

import java.util.HashMap;

/**
 * Created by RowleyJohn on 2/23/2016.
 */

/**
 * A Key-Value store containing variables that different pattern matcher nodes might need.
 */
public class VariableStore {
    private HashMap<String, CoordinatesWorld> coordinatesWorldHashMap;

    public VariableStore(){
        coordinatesWorldHashMap = new HashMap<String, CoordinatesWorld>();
    }

    /**
     * Returns a CoordinatesWorld from the Store.
     * @param id The key.
     * @return
     */
    public CoordinatesWorld get(String id){
        return coordinatesWorldHashMap.get(id);
    }

    /**
     * Puts a CoordinatesWorld into the store.
     * @param id The key.
     * @param coordinates The CoordinatesWorld to be placed in the store.
     */
    public void set(String id, CoordinatesWorld coordinates){
        if(coordinatesWorldHashMap.containsKey(id))
            throw new RuntimeException("CoordinatesWorld with key: " + id + " already exists in variable store");
        coordinatesWorldHashMap.put(id, coordinates);
    }
}
