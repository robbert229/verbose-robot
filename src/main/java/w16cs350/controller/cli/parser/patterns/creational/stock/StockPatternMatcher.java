package w16cs350.controller.cli.parser.patterns.creational.stock;

import w16cs350.controller.cli.parser.patterns.A_IteratingPatternMatcher;
import w16cs350.controller.cli.parser.patterns.A_PatternMatcher;
import w16cs350.controller.cli.parser.patterns.creational.power.PowerPatternMatcher;
import w16cs350.controller.cli.parser.patterns.creational.stock.car.StockCarPatternMatcher;
import w16cs350.controller.cli.parser.patterns.creational.stock.engine.StockEnginePatternMatcher;
import w16cs350.controller.command.A_Command;

import java.util.ListIterator;

/**
 * Created by michael on 2/24/16.
 */
public class StockPatternMatcher extends A_IteratingPatternMatcher{
    public StockPatternMatcher(A_PatternMatcher parent) { super(parent); }

    @Override
    protected boolean isMatch(ListIterator<String> tok) {
        String token = tok.next();
        tok.previous();
        return token.equals("STOCK");
    }

    @Override
    protected void initializeMatchers() {
        getPatternMatchers().add(new PowerPatternMatcher(this));
        getPatternMatchers().add(new StockCarPatternMatcher(this));
        getPatternMatchers().add(new StockEnginePatternMatcher(this));
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
