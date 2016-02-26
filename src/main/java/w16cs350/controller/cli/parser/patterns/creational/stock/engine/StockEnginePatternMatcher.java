package w16cs350.controller.cli.parser.patterns.creational.stock.engine;

import w16cs350.controller.cli.parser.patterns.A_IteratingPatternMatcher;
import w16cs350.controller.cli.parser.patterns.A_PatternMatcher;
import w16cs350.controller.cli.parser.patterns.creational.stock.car.*;
import w16cs350.controller.command.A_Command;

import java.util.ListIterator;

/**
 * Created by michael on 2/24/16.
 */
public class StockEnginePatternMatcher extends A_IteratingPatternMatcher{
    public StockEnginePatternMatcher(A_PatternMatcher parent) { super(parent); }

    @Override
    protected boolean isMatch(ListIterator<String> tok) {
        String token = tok.next();
        tok.previous();
        return token.equals("ENGINE");
    }

    @Override
    protected void initializeMatchers() {
        getPatternMatchers().add(new StockEngineDieselPatternMatcher(this));
    }

    @Override
    protected A_Command parseCommand(ListIterator<String> tokens) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected boolean isLeaf() {
        return false;
    }
}
