package w16cs350.controller.cli.parser.patterns.creational.stock.car;

import w16cs350.controller.cli.parser.patterns.A_IteratingPatternMatcher;
import w16cs350.controller.cli.parser.patterns.A_PatternMatcher;
import w16cs350.controller.command.A_Command;

import java.util.ListIterator;

/**
 * Created by michael on 2/24/16.
 */
public class StockCarPatternMatcher extends A_IteratingPatternMatcher {
    public StockCarPatternMatcher(A_PatternMatcher parent) { super(parent); }

    @Override
    protected boolean isMatch(ListIterator<String> tok) {
        String token = tok.next();
        tok.previous();
        return token.equals("CAR");
    }

    @Override
    protected void initializeMatchers() {
        getPatternMatchers().add(new StockCarBoxPatternMatcher(this));
        getPatternMatchers().add(new StockCarCaboosePatternMatcher(this));
        getPatternMatchers().add(new StockCarFlatbedPatternMatcher(this));
        getPatternMatchers().add(new StockCarPassengerPatternMatcher(this));
        getPatternMatchers().add(new StockCarTankPatternMatcher(this));
        getPatternMatchers().add(new StockCarTenderPatternMatcher(this));
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
