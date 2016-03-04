package w16cs350.controller.cli.parser.patterns.structural;

import w16cs350.controller.cli.TrackLocator;
import w16cs350.controller.cli.parser.PrimitiveDeserializer;
import w16cs350.controller.cli.parser.patterns.A_IteratingPatternMatcher;
import w16cs350.controller.cli.parser.patterns.A_PatternMatcher;
import w16cs350.controller.command.A_Command;
import w16cs350.controller.command.structural.CommandStructuralLocate;
import w16cs350.support.Assert;

import java.util.ListIterator;

/**
 * Created by michael on 3/3/16.
 */
public class LocatePatternMatcher extends A_IteratingPatternMatcher {
    public LocatePatternMatcher(A_PatternMatcher parent) {
        super(parent);
    }

    @Override
    protected boolean isMatch(ListIterator<String> tok) {
        String token = tok.next();
        tok.previous();
        return token.equals("LOCATE");
    }

    @Override
    protected void initializeMatchers() {
        throw new UnsupportedOperationException();
    }

    @Override
    protected A_Command parseCommand(ListIterator<String> tokens) {
        String stock = tokens.next();
        Assert.isTrue(stock.equals("STOCK"), "Incorrect input, expected: STOCK");
        String idToken = tokens.next();
        TrackLocator tl = PrimitiveDeserializer.parseTrackLocator(tokens);
        return new CommandStructuralLocate(idToken, tl);
    }

    @Override
    protected boolean isLeaf() {
        return true;
    }
}
