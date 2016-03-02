package w16cs350.controller.cli.parser.patterns.creational.track.switches;

import w16cs350.controller.cli.parser.CommandParser;
import w16cs350.controller.cli.parser.PrimitiveDeserializer;
import w16cs350.controller.cli.parser.patterns.A_IteratingPatternMatcher;
import w16cs350.controller.cli.parser.patterns.A_PatternMatcher;
import w16cs350.controller.cli.parser.patterns.creational.track.TrackCurvePatternMatcher;
import w16cs350.controller.command.A_Command;
import w16cs350.controller.command.creational.CommandCreateTrackCurve;
import w16cs350.controller.command.creational.CommandCreateTrackSwitchTurnout;
import w16cs350.datatype.CoordinatesDelta;
import w16cs350.datatype.CoordinatesWorld;
import w16cs350.support.Assert;

import java.util.ListIterator;

/**
 * Created by michael on 2/26/16.
 */
public class TrackSwitchTurnoutPatternMatcher extends A_IteratingPatternMatcher{
    public TrackSwitchTurnoutPatternMatcher(A_PatternMatcher parent) {
        super(parent);
    }

    @Override
    protected boolean isMatch(ListIterator<String> tok) {
        String token = tok.next();
        tok.previous();
        return token.equals("TURNOUT");
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

        String straightToken = tokens.next();
        Assert.isTrue(straightToken.equals("STRAIGHT"), "Incorrect input, expected: STRAIGHT");

        String deltaStraightToken = tokens.next();
        Assert.isTrue(deltaStraightToken.equals("DELTA"), "Incorrect input, expected: DELTA");

        String startStraightToken = tokens.next();
        Assert.isTrue(startStraightToken.equals("START"), "Incorrect input, expected: START");
        CoordinatesDelta cdStraightStart = PrimitiveDeserializer.parseCoordinatesDelta(tokens);

        String endStraightToken = tokens.next();
        Assert.isTrue(endStraightToken.equals("END"), "Incorrect input, expected: END");
        CoordinatesDelta cdStraightEnd = PrimitiveDeserializer.parseCoordinatesDelta(tokens);

        String curveToken = tokens.next();
        Assert.isTrue(curveToken.equals("CURVE"), "Incorrect input, expected: CURVE");

        String deltaCurveToken = tokens.next();
        Assert.isTrue(deltaCurveToken.equals("DELTA"), "Incorrect input, expected: DELTA");

        String startCurveToken = tokens.next();
        Assert.isTrue(startCurveToken.equals("START"), "Incorrect input, expected: START");
        CoordinatesDelta cdCurveStart = PrimitiveDeserializer.parseCoordinatesDelta(tokens);

        String endCurveToken = tokens.next();
        Assert.isTrue(endCurveToken.equals("END"), "Incorrect input, expected: END");
        CoordinatesDelta cdCurveEnd = PrimitiveDeserializer.parseCoordinatesDelta(tokens);

        String distanceToken = tokens.next();
        Assert.isTrue(distanceToken.equals("DISTANCE"), "Incorrect input, expected: DISTANCE");

        String originToken = tokens.next();
        Assert.isTrue(originToken.equals("ORIGIN"), "Incorrect input, expected: ORIGIN");
        double distance = Double.parseDouble(tokens.next());
        CommandCreateTrackCurve curve = new CommandCreateTrackCurve("temp", reference, cdCurveStart, cdCurveEnd, distance);
        CoordinatesDelta cdOrigin = curve.getDeltaOrigin();

        return new CommandCreateTrackSwitchTurnout(idToken, reference, cdStraightStart, cdStraightEnd, cdCurveStart, cdCurveEnd, cdOrigin);
    }

    @Override
    protected boolean isLeaf() {
        return false;
    }
}
