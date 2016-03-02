package w16cs350.controller.cli.parser.patterns.creational.track;

import w16cs350.controller.cli.parser.CommandParser;
import w16cs350.controller.cli.parser.PrimitiveDeserializer;
import w16cs350.controller.cli.parser.patterns.A_IteratingPatternMatcher;
import w16cs350.controller.cli.parser.patterns.A_PatternMatcher;
import w16cs350.controller.command.A_Command;
import w16cs350.controller.command.creational.CommandCreateTrackRoundhouse;
import w16cs350.datatype.Angle;
import w16cs350.datatype.CoordinatesDelta;
import w16cs350.datatype.CoordinatesWorld;
import w16cs350.support.Assert;

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
        String idToken = tokens.next();
        CommandParser cp = (CommandParser) getRoot();
        CoordinatesWorld reference = PrimitiveDeserializer.parseReference(tokens, cp.getHelper());

        String deltaToken = tokens.next();
        Assert.isTrue(deltaToken.equals("DELTA"), "Incorrect input, expected: DELTA");

        String originToken = tokens.next();
        Assert.isTrue(originToken.equals("ORIGIN"), "Incorrect input, expected: ORIGIN");
        CoordinatesDelta cdOrigin = PrimitiveDeserializer.parseCoordinatesDelta(tokens);

        String angleToken = tokens.next();
        Assert.isTrue(angleToken.equals("ANGLE"), "Incorrect input, expected: ANGLE");

        String entryToken = tokens.next();
        Assert.isTrue(entryToken.equals("ENTRY"), "Incorrect input, expected: ENTRY");
        Angle entryAngle = new Angle(Double.parseDouble(tokens.next()));

        String startToken = tokens.next();
        Assert.isTrue(startToken.equals("START"), "Incorrect input, expected: START");
        Angle startAngle = new Angle(Double.parseDouble(tokens.next()));

        String endToken = tokens.next();
        Assert.isTrue(endToken.equals("END"), "Incorrect input, expected: END");
        Angle endAngle = new Angle(Double.parseDouble(tokens.next()));

        String withToken = tokens.next();
        Assert.isTrue(withToken.equals("WITH"), "Incorrct input, expected: WITH");

        int numSpurs = Integer.parseInt(tokens.next());

        String spursToken = tokens.next();
        Assert.isTrue(spursToken.equals("SPURS"), "Incorrect input, expected: SPURS");

        String lengthToken1 = tokens.next();
        Assert.isTrue(lengthToken1.equals("LENGTH"), "Incorrect input, expected: LENGTH");
        int spurLength = Integer.parseInt(tokens.next());

        String turntableToken = tokens.next();
        Assert.isTrue(turntableToken.equals("TURNTABLE"), "Incorrect input, expected: TURNTABLE");

        String lengthToken2 = tokens.next();
        Assert.isTrue(lengthToken2.equals("LENGTH"), "Incorrect input, expected: LENGTH");
        int turntableLength = Integer.parseInt(tokens.next());

        return new CommandCreateTrackRoundhouse(idToken, reference, cdOrigin, entryAngle, startAngle, endAngle, numSpurs, spurLength, turntableLength);
    }

    @Override
    protected boolean isLeaf() {
        return true;
    }
}
