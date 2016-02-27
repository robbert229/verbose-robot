package w16cs350.controller.cli.parser.patterns.creational.track;

import w16cs350.controller.cli.parser.patterns.A_IteratingPatternMatcher;
import w16cs350.controller.cli.parser.patterns.A_PatternMatcher;
import w16cs350.controller.command.A_Command;

import java.util.ListIterator;

/**
 * Created by michael on 2/26/16.
 */
public class TrackRoundhousePatternMatcher extends A_IteratingPatternMatcher{
    public TrackRoundhousePatternMatcher(A_PatternMatcher parent) {
        super(parent);
    }

    @Override
    protected boolean isMatch(ListIterator<String> tok) {
        String token = tok.next();
        tok.previous();
        return token.equals("ROUNDHOUSE");
    }

    @Override
    protected void initializeMatchers() {
        throw new UnsupportedOperationException();
    }

    @Override
    protected A_Command parseCommand(ListIterator<String> tokens) {
        return null;
    }

    @Override
    protected boolean isLeaf() {
        return true;
    }
}
