package w16cs350.controller.cli.parser.patterns.creational.power;

import w16cs350.controller.cli.TrackLocator;
import w16cs350.controller.cli.parser.patterns.A_IteratingPatternMatcher;
import w16cs350.controller.cli.parser.patterns.A_PatternMatcher;
import w16cs350.controller.command.A_Command;
import w16cs350.controller.command.creational.CommandCreatePowerPole;
import w16cs350.support.Assert;

import java.util.ListIterator;

/**
 * Created by michael on 2/24/16.
 */
public class PowerPolePatternMatcher extends A_IteratingPatternMatcher {
    public PowerPolePatternMatcher(A_PatternMatcher parent) { super(parent); }

    @Override
    protected boolean isMatch(ListIterator<String> tok) {
        String token = tok.next();
        tok.previous();
        return token.equals("POLE");
    }

    @Override
    protected void initializeMatchers() {
        throw new UnsupportedOperationException();
    }

    @Override
    protected A_Command parseCommand(ListIterator<String> tokens) {
        String idToken = tokens.next();
        TrackLocator tl = parseTrackLocator(tokens);
        return new CommandCreatePowerPole(idToken, tl);
    }

    //NOTE: Also in StockEngineDieselPatternMatcher
    protected TrackLocator parseTrackLocator(ListIterator<String> tokens){
        String onToken = tokens.next();
        Assert.isTrue(onToken.equals("ON"), "Incorrect input, expected: ON");
        String trackToken = tokens.next();
        Assert.isTrue(trackToken.equals("TRACK"), "Incorrect input, expected: TRACK");
        String trackID = tokens.next();
        String distanceToken = tokens.next();
        Assert.isTrue(distanceToken.equals("DISTANCE"), "Incorrect input, expected: DISTANCE");
        double distance = Double.parseDouble(tokens.next());
        String fromToken = tokens.next();
        Assert.isTrue(fromToken.equals("FROM"), "Incorrect input, expected: FROM");
        boolean isFromAOrB = tokens.next().equals("START");
        return new TrackLocator(trackID, distance, isFromAOrB);
    }

    @Override
    protected boolean isLeaf() {
        return true;
    }
}
