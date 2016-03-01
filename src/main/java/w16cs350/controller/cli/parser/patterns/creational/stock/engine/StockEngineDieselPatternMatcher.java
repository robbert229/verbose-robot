package w16cs350.controller.cli.parser.patterns.creational.stock.engine;

import w16cs350.controller.cli.TrackLocator;
import w16cs350.controller.cli.parser.PrimitiveDeserializer;
import w16cs350.controller.cli.parser.patterns.A_IteratingPatternMatcher;
import w16cs350.controller.cli.parser.patterns.A_PatternMatcher;
import w16cs350.controller.command.A_Command;
import w16cs350.controller.command.creational.CommandCreateStockEngineDiesel;
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
        String engineIDToken = tokens.previous();
        tokens.next();
        tokens.next(); //AS
        tokens.next(); //DIESEL
        TrackLocator tl = PrimitiveDeserializer.parseTrackLocator(tokens);
        String facingToken = tokens.next();
        Assert.isTrue(facingToken.equals("FACING"), "Incorrect input, expected: FACING");
        boolean isFacingStartElseEnd = tokens.next().equals("START");
        return new CommandCreateStockEngineDiesel(engineIDToken, tl, isFacingStartElseEnd);
    }

    @Override
    protected boolean isLeaf() {
        return true;
    }
}
