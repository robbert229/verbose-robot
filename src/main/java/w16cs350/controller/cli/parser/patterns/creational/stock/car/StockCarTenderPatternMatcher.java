package w16cs350.controller.cli.parser.patterns.creational.stock.car;

import org.omg.CORBA.UNSUPPORTED_POLICY;
import w16cs350.controller.cli.parser.patterns.A_IteratingPatternMatcher;
import w16cs350.controller.cli.parser.patterns.A_PatternMatcher;
import w16cs350.controller.command.A_Command;
import w16cs350.controller.command.creational.CommandCreateStockCarTender;
import w16cs350.support.Assert;

import java.util.ListIterator;

/**
 * Created by michael on 2/24/16.
 */
public class StockCarTenderPatternMatcher extends A_IteratingPatternMatcher {
    public StockCarTenderPatternMatcher(A_PatternMatcher parent) { super(parent); }

    @Override
    protected boolean isMatch(ListIterator<String> tok) {
        String idToken = tok.next();
        String asToken = tok.next();
        Assert.isTrue(asToken.equals("AS"), "Incorrect input: StockCarTender");
        String carType = tok.next();
        tok.previous();
        tok.previous();
        tok.previous();
        return carType.equals("TENDER");
    }

    @Override
    protected void initializeMatchers() {
        throw new UnsupportedOperationException();
    }

    @Override
    protected A_Command parseCommand(ListIterator<String> tokens) {
        String idToken = tokens.next();
        return new CommandCreateStockCarTender(idToken);
    }

    @Override
    protected boolean isLeaf() {
        return true;
    }
}
