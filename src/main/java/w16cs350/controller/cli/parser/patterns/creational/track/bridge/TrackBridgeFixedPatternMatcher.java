package w16cs350.controller.cli.parser.patterns.creational.track.bridge;

import w16cs350.controller.cli.parser.CommandParser;
import w16cs350.controller.cli.parser.PrimitiveDeserializer;
import w16cs350.controller.cli.parser.patterns.A_IteratingPatternMatcher;
import w16cs350.controller.cli.parser.patterns.A_PatternMatcher;
import w16cs350.controller.command.A_Command;
import w16cs350.controller.command.PointLocator;
import w16cs350.controller.command.creational.CommandCreateTrackBridgeDraw;
import w16cs350.controller.command.creational.CommandCreateTrackBridgeFixed;
import w16cs350.datatype.Angle;
import w16cs350.support.Assert;

import java.util.ListIterator;

/**
 * Created by michael on 2/26/16.
 */
public class TrackBridgeFixedPatternMatcher extends A_IteratingPatternMatcher {
    public TrackBridgeFixedPatternMatcher(A_PatternMatcher parent) {
        super(parent);
    }

    @Override
    protected boolean isMatch(ListIterator<String> tok) {
        String token = tok.next();
        String drawToken = tok.next();
        tok.previous();
        tok.previous();
        return token.equals("BRIDGE") && !drawToken.equals("DRAW");
    }

    @Override
    protected void initializeMatchers() {
        throw new UnsupportedOperationException();
    }

    @Override
    protected A_Command parseCommand(ListIterator<String> tokens) {
        String idToken  = tokens.next();
        CommandParser root = (CommandParser) getRoot();
        PointLocator pl = PrimitiveDeserializer.parsePointLocator(tokens, root.getHelper());
        return new CommandCreateTrackBridgeFixed(idToken, pl);
    }

    @Override
    protected boolean isLeaf() {
        return true;
    }
}
