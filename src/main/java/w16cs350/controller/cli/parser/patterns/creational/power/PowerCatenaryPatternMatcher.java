package w16cs350.controller.cli.parser.patterns.creational.power;

import w16cs350.controller.cli.parser.patterns.A_IteratingPatternMatcher;
import w16cs350.controller.cli.parser.patterns.A_PatternMatcher;
import w16cs350.controller.command.A_Command;
import w16cs350.controller.command.creational.CommandCreatePowerCatenary;
import w16cs350.support.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by michael on 2/24/16.
 */
public class PowerCatenaryPatternMatcher extends A_IteratingPatternMatcher{
    public PowerCatenaryPatternMatcher(A_PatternMatcher parent) { super(parent); }

    @Override
    protected boolean isMatch(ListIterator<String> tok) {
        String token = tok.next();
        return token.equals("CATENARY");
    }

    @Override
    protected void initializeMatchers() {
        throw new UnsupportedOperationException();
    }

    @Override
    protected A_Command parseCommand(ListIterator<String> tokens) {
        String idToken = tokens.next();
        String withToken = tokens.next();
        Assert.isTrue(withToken.equals("WITH"), "Incorrect input, expected: WITH");
        String polesToken = tokens.next();
        Assert.isTrue(polesToken.equals("POLES"), "Incorrect input, expected: POLES");
        List<String> poleIDs = new ArrayList<String>();
        while(tokens.hasNext())
            poleIDs.add(tokens.next());
        return new CommandCreatePowerCatenary(idToken, poleIDs);
    }

    @Override
    protected boolean isLeaf() {
        return true;
    }
}
