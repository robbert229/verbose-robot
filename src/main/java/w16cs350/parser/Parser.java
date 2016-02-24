package w16cs350.parser;

import w16cs350.controller.command.A_Command;
import w16cs350.parser.patterns.meta.MetaCategoryPatternMatcher;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by johnrowleyster on 2/23/16.
 */

public class Parser extends A_NonIteratingPatternMatcher {
    public Parser() {
        super(null);
    }

    public A_Command parse(String line){
        String[] tokens = line.split(" ");
        LinkedList<String> tokenList = new LinkedList<String>();
        for(String t : tokens) tokenList.add(t);
        return parse(tokenList.listIterator());
    }

    @Override
    protected void initializeMatchers() {
        getPatternMatchers().add(new MetaCategoryPatternMatcher(this));
    }
}
