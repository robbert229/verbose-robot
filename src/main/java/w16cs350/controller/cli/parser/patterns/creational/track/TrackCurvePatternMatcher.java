package w16cs350.controller.cli.parser.patterns.creational.track;

import w16cs350.controller.cli.parser.CommandParser;
import w16cs350.controller.cli.parser.PrimitiveDeserializer;
import w16cs350.controller.cli.parser.patterns.A_IteratingPatternMatcher;
import w16cs350.controller.cli.parser.patterns.A_PatternMatcher;
import w16cs350.controller.command.A_Command;
import w16cs350.controller.command.creational.CommandCreateTrackCurve;
import w16cs350.datatype.CoordinatesDelta;
import w16cs350.datatype.CoordinatesWorld;
import w16cs350.support.Assert;

import java.util.ListIterator;

/**
 * Created by michael on 2/26/16.
 */
public class TrackCurvePatternMatcher extends A_IteratingPatternMatcher{
    public TrackCurvePatternMatcher(A_PatternMatcher parent) {
        super(parent);
    }

    @Override
    protected boolean isMatch(ListIterator<String> tok) {
        String token = tok.next();
        tok.previous();
        return token.equals("CURVE");
    }

    @Override
    protected void initializeMatchers() {
        throw new UnsupportedOperationException();
    }

    @Override
    protected A_Command parseCommand(ListIterator<String> tokens) {
        String idToken = tokens.next();
        CommandParser cp = (CommandParser) getRoot();
        CoordinatesWorld reference = PrimitiveDeserializer.parseReference(tokens, cp.getHelper());

        String deltaToken = tokens.next();
        Assert.isTrue(deltaToken.equals("DELTA"), "Incorrect input, expected: DELTA");

        String startToken = tokens.next();
        Assert.isTrue(startToken.equals("START"), "Incorrect input, expected: START");
        CoordinatesDelta cdStart = PrimitiveDeserializer.parseCoordinatesDelta(tokens);

        String endToken = tokens.next();
        Assert.isTrue(endToken.equals("END"), "Incorrect input, expected: END");
        CoordinatesDelta cdEnd = PrimitiveDeserializer.parseCoordinatesDelta(tokens);

        String distance_or_origin = tokens.next();
        Assert.isTrue(distance_or_origin.equals("DISTANCE") || distance_or_origin.equals("ORIGIN"), "Incorrect input, expected: DISTANCE or ORIGIN");
        if(distance_or_origin.equals("DISTANCE")){
            String originToken = tokens.next();
            Assert.isTrue(originToken.equals("ORIGIN"), "Incorrect input, expected: ORIGIN");
            double distance = Double.parseDouble(tokens.next());
            CoordinatesDelta deltaReference = PrimitiveDeserializer.getOrigin(reference, cdStart, cdEnd, distance);
            return new CommandCreateTrackCurve(idToken, reference, cdStart, cdEnd, deltaReference);
        }
        else{
            CoordinatesDelta cdOrigin = PrimitiveDeserializer.parseCoordinatesDelta(tokens);
            return new CommandCreateTrackCurve(idToken, reference, cdStart, cdEnd, cdOrigin);
        }
    }

    @Override
    protected boolean isLeaf() {
        return true;
    }
}
