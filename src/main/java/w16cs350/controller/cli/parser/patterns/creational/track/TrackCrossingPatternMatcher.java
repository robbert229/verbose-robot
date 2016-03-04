package w16cs350.controller.cli.parser.patterns.creational.track;

import w16cs350.controller.cli.parser.CommandParser;
import w16cs350.controller.cli.parser.PrimitiveDeserializer;
import w16cs350.controller.cli.parser.patterns.A_IteratingPatternMatcher;
import w16cs350.controller.cli.parser.patterns.A_PatternMatcher;
import w16cs350.controller.command.A_Command;
import w16cs350.controller.command.PointLocator;
import w16cs350.controller.command.creational.CommandCreateTrackCrossing;
import w16cs350.datatype.CoordinatesDelta;
import w16cs350.datatype.CoordinatesWorld;
import w16cs350.support.Assert;

import java.util.ListIterator;

/**
 * Created by michael on 2/26/16.
 */
public class TrackCrossingPatternMatcher extends A_IteratingPatternMatcher{
    public TrackCrossingPatternMatcher(A_PatternMatcher parent) {
        super(parent);
    }

    @Override
    protected boolean isMatch(ListIterator<String> tok) {
        String token = tok.next();
        tok.previous();
        return token.equals("CROSSING");
    }

    @Override
    protected void initializeMatchers() {
        throw new UnsupportedOperationException();
    }

    @Override
    protected A_Command parseCommand(ListIterator<String> tokens) {
        String idToken = tokens.next();
        CommandParser cp = (CommandParser) getRoot();
        PointLocator pl = PrimitiveDeserializer.parsePointLocator(tokens, cp.getHelper());

        return new CommandCreateTrackCrossing(idToken, pl);
    }

    @Override
    protected boolean isLeaf() {
        return true;
    }
}
