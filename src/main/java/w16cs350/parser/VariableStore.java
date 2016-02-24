package w16cs350.parser;

import w16cs350.datatype.CoordinatesWorld;

import java.util.HashMap;

/**
 * Created by RowleyJohn on 2/23/2016.
 */
public class VariableStore {
    private HashMap<String, CoordinatesWorld> coordinatesWorldHashMap;

    public VariableStore(){
        coordinatesWorldHashMap = new HashMap<String, CoordinatesWorld>();
    }

    public CoordinatesWorld get(String id){
        return coordinatesWorldHashMap.get(id);
    }

    public void set(String id, CoordinatesWorld coordinates){
        coordinatesWorldHashMap.put(id, coordinates);
    }
}
