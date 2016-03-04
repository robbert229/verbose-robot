package w16cs350.controller.cli.parser.patterns.creational.track.bridge;

import w16cs350.controller.cli.parser.PrimitiveDeserializer;
import w16cs350.controller.cli.parser.deserializers.CoordinatesDeltaDeserializer;
import w16cs350.controller.cli.parser.patterns.A_PatternMatcher;
import w16cs350.controller.cli.parser.patterns.A_SubPatternMatcher;
import w16cs350.controller.command.A_Command;
import w16cs350.controller.command.PointLocator;
import w16cs350.controller.command.creational.CommandCreateTrackBridgeFixed;
import w16cs350.datatype.CoordinatesDelta;
import w16cs350.datatype.CoordinatesWorld;

import java.util.ListIterator;

/**
 * Created by michael on 2/26/16.
 */
public class TrackBridgeFixedPatternMatcher extends A_SubPatternMatcher {
    public TrackBridgeFixedPatternMatcher(A_PatternMatcher parent) {
        super(parent, "BRIDGE (fixed)");
    }

    @Override
    protected boolean isMatch(ListIterator<String> tok) {
        _tokensSet(tok, null);
        if (!peekNextToken("matching token").equals("BRIDGE")) {
            return false;
        }
        nextToken("advancing token");
        if (!peekNextNextToken("matching token").equals("REFERENCE")) {
            previousToken("previous token");
            return false;
        }
        previousToken("previous");
        return true;
    }

    @Override
    protected void initializeMatchers() {
        throw new UnsupportedOperationException();
    }


    @Override
    protected A_Command parseCommand(ListIterator<String> tokens) {
        _tokensSet(tokens, null);
        String idToken = getNextToken("getting ID token");
        CoordinatesWorld world_reference = PrimitiveDeserializer.parseReference(tokens, this.getHelper());
        nextTokenIs("DELTA", "next token delta");
        nextTokenIs("START", "next token start");
        CoordinatesDelta delta_start = CoordinatesDeltaDeserializer.parseCoordinatesDelta(tokens);
        nextTokenIs("END", "next token end");
        CoordinatesDelta delta_end = CoordinatesDeltaDeserializer.parseCoordinatesDelta(tokens);
        PointLocator pl = new PointLocator(world_reference, delta_start, delta_end);
        return new CommandCreateTrackBridgeFixed(idToken, pl);
    }

    @Override
    protected boolean isLeaf() {
        return true;
    }

}
