package w16cs350.controller.cli.parser.patterns.creational.track;

import w16cs350.controller.cli.parser.patterns.A_IteratingPatternMatcher;
import w16cs350.controller.cli.parser.patterns.A_PatternMatcher;
import w16cs350.controller.cli.parser.patterns.creational.track.bridge.TrackBridgePatternMatcher;
import w16cs350.controller.cli.parser.patterns.creational.track.switches.TrackSwitchPatternMatcher;
import w16cs350.controller.command.A_Command;

import java.util.ListIterator;

/**
 * Created by michael on 2/24/16.
 */
public class TrackPatternMatcher extends A_IteratingPatternMatcher {
    public TrackPatternMatcher(A_PatternMatcher parent) { super(parent); }

    @Override
    protected boolean isMatch(ListIterator<String> tok) {
        String token = tok.next();
        tok.previous();
        return token.equals("TRACK");
    }

    @Override
    protected void initializeMatchers() {
        getPatternMatchers().add(new TrackBridgePatternMatcher(this));
        getPatternMatchers().add(new TrackSwitchPatternMatcher(this));
        getPatternMatchers().add(new TrackCrossingPatternMatcher(this));
        getPatternMatchers().add(new TrackCrossoverPatternMatcher(this));
        getPatternMatchers().add(new TrackCurvePatternMatcher(this));
        getPatternMatchers().add(new TrackEndPatternMatcher(this));
        getPatternMatchers().add(new TrackLayoutPatternMatcher(this));
        getPatternMatchers().add(new TrackRoundhousePatternMatcher(this));
        getPatternMatchers().add(new TrackStraightPatternMatcher(this));
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
