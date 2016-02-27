package w16cs350.controller.cli.parser.patterns.creational.track.switches;

import w16cs350.controller.cli.parser.patterns.A_IteratingPatternMatcher;
import w16cs350.controller.cli.parser.patterns.A_PatternMatcher;
import w16cs350.controller.command.A_Command;

import java.util.ListIterator;

/**
 * Created by michael on 2/26/16.
 */
public class TrackSwitchTurnoutPatternMatcher extends A_IteratingPatternMatcher {
    public TrackSwitchTurnoutPatternMatcher(A_PatternMatcher parent) {
        super(parent);
    }

    @Override
    protected boolean isMatch(ListIterator<String> tok) {
        return false;
    }

    @Override
    protected void initializeMatchers() {

    }

    @Override
    protected A_Command parseCommand(ListIterator<String> tokens) {
        return null;
    }

    @Override
    protected boolean isLeaf() {
        return false;
    }
}
