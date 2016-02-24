package w16cs350.parser;

import w16cs350.controller.command.A_Command;
import w16cs350.parser.patterns.A_NonIteratingPatternMatcher;
import w16cs350.parser.patterns.meta.MetaCategoryPatternMatcher;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by johnrowleyster on 2/23/16.
 */

public class Parser extends A_NonIteratingPatternMatcher {
    public Parser() {
        super(null);
        variableStore = new VariableStore();
    }

    private VariableStore variableStore;

    public VariableStore getVariableStore(){
        return variableStore;
    }

    public A_Command parse(String line){
        return parse(getIteratorFromString(line));
    }

    public static ListIterator<String> getIteratorFromString(String string){
        String[] tokens = string.split(" ");
        LinkedList<String> tokenList = new LinkedList<String>();
        for(String t : tokens) tokenList.add(t);
        return tokenList.listIterator();
    }

    @Override
    protected void initializeMatchers() {
        getPatternMatchers().add(new MetaCategoryPatternMatcher(this));
    }
}
