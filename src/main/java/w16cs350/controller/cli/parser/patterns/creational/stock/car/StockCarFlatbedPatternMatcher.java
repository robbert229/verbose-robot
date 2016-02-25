package w16cs350.controller.cli.parser.patterns.creational.stock.car;

import w16cs350.controller.cli.parser.patterns.A_IteratingPatternMatcher;
import w16cs350.controller.cli.parser.patterns.A_PatternMatcher;
import w16cs350.controller.command.A_Command;

import java.util.ListIterator;

/**
 * Created by michael on 2/24/16.
 */
public class StockCarFlatbedPatternMatcher extends A_IteratingPatternMatcher{
    public StockCarFlatbedPatternMatcher(A_PatternMatcher parent) { super(parent); }

    @Override
    protected boolean isMatch(ListIterator<String> tok) {
        String asToken = tok.next();
        String token = tok.next();
        tok.previous();
        return asToken.equals("AS") && token.equals("FLATBED");
    }

    @Override
    protected void initializeMatchers() {

    }

    @Override
    protected A_Command parseCommand(ListIterator<String> tokens) {
        return null;
    }

    @Override
    protected boolean isLeaf() {
        return false;
    }
}
