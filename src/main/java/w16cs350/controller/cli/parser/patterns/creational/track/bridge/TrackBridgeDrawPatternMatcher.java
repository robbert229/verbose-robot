package w16cs350.controller.cli.parser.patterns.creational.track.bridge;

import w16cs350.controller.cli.parser.CommandParser;
import w16cs350.controller.cli.parser.PrimitiveDeserializer;
import w16cs350.controller.cli.parser.patterns.A_IteratingPatternMatcher;
import w16cs350.controller.cli.parser.patterns.A_PatternMatcher;
import w16cs350.controller.command.A_Command;
import w16cs350.controller.command.PointLocator;
import w16cs350.controller.command.creational.CommandCreateTrackBridgeDraw;
import w16cs350.datatype.Angle;
import w16cs350.support.Assert;

import java.util.ListIterator;

/**
 * Created by michael on 2/26/16.
 */
public class TrackBridgeDrawPatternMatcher extends A_IteratingPatternMatcher{
    public TrackBridgeDrawPatternMatcher(A_PatternMatcher parent) {
        super(parent);
    }

    @Override
    protected boolean isMatch(ListIterator<String> tok) {
        String token = tok.next();
        String drawToken = tok.next();
        tok.previous();
        tok.previous();
        return token.equals("BRIDGE") && drawToken.equals("DRAW");
    }

    @Override
    protected void initializeMatchers() {
        throw new UnsupportedOperationException();
    }

    @Override
    protected A_Command parseCommand(ListIterator<String> tokens) {
        tokens.next(); //bridgepatternmatcher is non-iterating, need to iterate over 'DRAW'
        String idToken  = tokens.next();
        CommandParser root = (CommandParser) getRoot();
        PointLocator pl = PrimitiveDeserializer.parsePointLocator(tokens, root.getHelper());
        String angleToken = tokens.next();
        Assert.isTrue(angleToken.equals("ANGLE"), "Incorrect input, expected: ANGLE");
        Angle angle = PrimitiveDeserializer.parseAngle(tokens);
        return new CommandCreateTrackBridgeDraw(idToken, pl, angle);
    }

    @Override
    protected boolean isLeaf() {
        return true;
    }
}
