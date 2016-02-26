package w16cs350.controller.cli.parser.patterns.creational.stock.engine;

import w16cs350.controller.cli.parser.patterns.A_IteratingPatternMatcher;
import w16cs350.controller.cli.parser.patterns.A_PatternMatcher;
import w16cs350.controller.cli.parser.patterns.creational.stock.car.*;
import w16cs350.controller.command.A_Command;
import w16cs350.controller.command.creational.CommandCreateStockCarBox;
import w16cs350.support.Assert;

import java.util.ListIterator;

/**
 * Created by michael on 2/24/16.
 */
public class StockEngineDieselPatternMatcher extends A_IteratingPatternMatcher {
    public StockEngineDieselPatternMatcher(A_PatternMatcher parent) { super(parent); }

    @Override
    protected boolean isMatch(ListIterator<String> tok) {
        String idToken = tok.next();
        String asToken = tok.next();
        Assert.isTrue(asToken.equals("AS"), "Incorrect input: StockEngineDiesel");
        String engineType = tok.next();
        tok.previous();
        tok.previous();
        tok.previous();
        return engineType.equals("DIESEL");
    }

    @Override
    protected void initializeMatchers() {
        throw new UnsupportedOperationException();
    }

    @Override
    protected A_Command parseCommand(ListIterator<String> tokens) {
        //TODO
        return null;
    }

    @Override
    protected boolean isLeaf() {
        return true;
    }
}
