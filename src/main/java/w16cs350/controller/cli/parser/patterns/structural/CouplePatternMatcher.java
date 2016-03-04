package w16cs350.controller.cli.parser.patterns.structural;

import w16cs350.controller.cli.parser.patterns.A_IteratingPatternMatcher;
import w16cs350.controller.cli.parser.patterns.A_PatternMatcher;
import w16cs350.controller.command.A_Command;
import w16cs350.controller.command.structural.CommandStructuralCouple;
import w16cs350.support.Assert;

import java.util.ListIterator;

/**
 * Created by michael on 3/3/16.
 */
public class CouplePatternMatcher extends A_IteratingPatternMatcher {
    public CouplePatternMatcher(A_PatternMatcher parent) {
        super(parent);
    }

    @Override
    protected boolean isMatch(ListIterator<String> tok) {
        String token = tok.next();
        tok.previous();
        return token.equals("COUPLE");
    }

    @Override
    protected void initializeMatchers() {
        throw new UnsupportedOperationException();
    }

    @Override
    protected A_Command parseCommand(ListIterator<String> tokens) {
        String stockToken = tokens.next();
        Assert.isTrue(stockToken.equals("STOCK"), "Incorrect input, expected: STOCK");
        String id1 = tokens.next();
        String andToken = tokens.next();
        Assert.isTrue(andToken.equals("AND"), "Incorrect input, expected: AND");
        String id2 = tokens.next();
        return new CommandStructuralCouple(id1, id2);
    }

    @Override
    protected boolean isLeaf() {
        return true;
    }
}
