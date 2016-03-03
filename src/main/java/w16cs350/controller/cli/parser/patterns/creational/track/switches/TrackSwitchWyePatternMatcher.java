package w16cs350.controller.cli.parser.patterns.creational.track.switches;

import w16cs350.controller.cli.parser.CommandParser;
import w16cs350.controller.cli.parser.PrimitiveDeserializer;
import w16cs350.controller.cli.parser.patterns.A_IteratingPatternMatcher;
import w16cs350.controller.cli.parser.patterns.A_PatternMatcher;
import w16cs350.controller.command.A_Command;
import w16cs350.controller.command.creational.CommandCreateTrackSwitchWye;
import w16cs350.datatype.CoordinatesDelta;
import w16cs350.datatype.CoordinatesWorld;
import w16cs350.support.Assert;

import java.util.ListIterator;

/**
 * Created by michael on 2/26/16.
 */
public class TrackSwitchWyePatternMatcher extends A_IteratingPatternMatcher{
    public TrackSwitchWyePatternMatcher(A_PatternMatcher parent) {
        super(parent);
    }

    @Override
    protected boolean isMatch(ListIterator<String> tok) {
        String idToken = tok.next();
        tok.previous();
        return idToken.equals("WYE");
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

        String deltaToken1 = tokens.next();
        Assert.isTrue(deltaToken1.equals("DELTA"), "Incorrect input, expected: DELTA");

        String startToken1 = tokens.next();
        Assert.isTrue(startToken1.equals("START"), "Incorrect input, expected: START");
        CoordinatesDelta cdStart1 = PrimitiveDeserializer.parseCoordinatesDelta(tokens);

        String endToken1 = tokens.next();
        Assert.isTrue(endToken1.equals("END"), "Incorrect input, expected: END");
        CoordinatesDelta cdEnd1 = PrimitiveDeserializer.parseCoordinatesDelta(tokens);

        String distanceToken1 = tokens.next();
        Assert.isTrue(distanceToken1.equals("DISTANCE"), "Incorrect input, expected: DISTANCE");

        String originToken1 = tokens.next();
        Assert.isTrue(originToken1.equals("ORIGIN"), "Incorrect input, expected: ORIGIN");
        double distance1 = Double.parseDouble(tokens.next());
        CoordinatesDelta cdOrigin1 = PrimitiveDeserializer.getOrigin(reference, cdStart1, cdEnd1, distance1);


        String deltaToken2 = tokens.next();
        Assert.isTrue(deltaToken2.equals("DELTA"), "Incorrect input, expected: DELTA");

        String startToken2 = tokens.next();
        Assert.isTrue(startToken2.equals("START"), "Incorrect input, expected: START");
        CoordinatesDelta cdStart2 = PrimitiveDeserializer.parseCoordinatesDelta(tokens);

        String endToken2 = tokens.next();
        Assert.isTrue(endToken2.equals("END"), "Incorrect input, expected: END");
        CoordinatesDelta cdEnd2 = PrimitiveDeserializer.parseCoordinatesDelta(tokens);

        String distanceToken2 = tokens.next();
        Assert.isTrue(distanceToken2.equals("DISTANCE"), "Incorrect input, expected: DISTANCE");

        String originToken2 = tokens.next();
        Assert.isTrue(originToken2.equals("ORIGIN"), "Incorrect input, expected: ORIGIN");
        double distance2 = Double.parseDouble(tokens.next());
        CoordinatesDelta cdOrigin2 = PrimitiveDeserializer.getOrigin(reference, cdStart2, cdEnd2, distance2);

        return new CommandCreateTrackSwitchWye(idToken, reference, cdStart1, cdEnd1, cdOrigin1, cdStart2, cdEnd2, cdOrigin2);
    }

    @Override
    protected boolean isLeaf() {
        return true;
    }
}
