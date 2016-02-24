package w16cs350.controller.cli.parser;

import w16cs350.datatype.CoordinatesWorld;

/**
 * Created by RowleyJohn on 2/23/2016.
 */

/**
 * A Key-Value store containing variables that different pattern matcher nodes might need.
 */
public class VariableStore {
    private A_ParserHelper _helper;

    public VariableStore(A_ParserHelper helper){
        _helper = helper;
    }

    /**
     * Returns a CoordinatesWorld from the Store.
     * @param id The key.
     * @return
     */
    public CoordinatesWorld get(String id){
        return _helper.getReference(id);
    }

    /**
     * Puts a CoordinatesWorld into the store.
     * @param id The key.
     * @param coordinates The CoordinatesWorld to be placed in the store.
     */
    public void set(String id, CoordinatesWorld coordinates){
        _helper.addReference(id, coordinates);
    }
}
