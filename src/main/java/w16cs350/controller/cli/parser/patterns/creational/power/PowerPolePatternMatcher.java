package w16cs350.controller.cli.parser.patterns.creational.power;

import w16cs350.controller.cli.TrackLocator;
import w16cs350.controller.cli.parser.PrimitiveDeserializer;
import w16cs350.controller.cli.parser.patterns.A_IteratingPatternMatcher;
import w16cs350.controller.cli.parser.patterns.A_PatternMatcher;
import w16cs350.controller.command.A_Command;
import w16cs350.controller.command.creational.CommandCreatePowerPole;

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
        TrackLocator tl = PrimitiveDeserializer.parseTrackLocator(tokens);
        return new CommandCreatePowerPole(idToken, tl);
    }

    @Override
    protected boolean isLeaf() {
        return true;
    }
}
