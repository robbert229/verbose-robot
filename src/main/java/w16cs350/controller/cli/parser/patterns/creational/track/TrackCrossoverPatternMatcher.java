package w16cs350.controller.cli.parser.patterns.creational.track;

import w16cs350.controller.cli.parser.CommandParser;
import w16cs350.controller.cli.parser.PrimitiveDeserializer;
import w16cs350.controller.cli.parser.patterns.A_IteratingPatternMatcher;
import w16cs350.controller.cli.parser.patterns.A_PatternMatcher;
import w16cs350.controller.command.A_Command;
import w16cs350.controller.command.creational.CommandCreateTrackCrossover;
import w16cs350.datatype.CoordinatesDelta;
import w16cs350.datatype.CoordinatesWorld;
import w16cs350.support.Assert;

import java.util.ListIterator;

/**
 * Created by michael on 2/26/16.
 */
public class TrackCrossoverPatternMatcher extends A_IteratingPatternMatcher{
    public TrackCrossoverPatternMatcher(A_PatternMatcher parent) {
        super(parent);
    }

    @Override
    protected boolean isMatch(ListIterator<String> tok) {
        String token = tok.next();
        tok.previous();
        return token.equals("CROSSOVER");
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

        String startToken1 = tokens.next();
        Assert.isTrue(startToken1.equals("START"), "Incorrect input, expected: START");
        CoordinatesDelta cdStart1 = PrimitiveDeserializer.parseCoordinatesDelta(tokens);

        String endToken1 = tokens.next();
        Assert.isTrue(endToken1.equals("END"), "Incorrect input, expected: END");
        CoordinatesDelta cdEnd1 = PrimitiveDeserializer.parseCoordinatesDelta(tokens);

        String startToken2 = tokens.next();
        Assert.isTrue(startToken2.equals("START"), "Incorrect input, expected: START");
        CoordinatesDelta cdStart2 = PrimitiveDeserializer.parseCoordinatesDelta(tokens);

        String endToken2 = tokens.next();
        Assert.isTrue(endToken2.equals("END"), "Incorrect input, expected: END");
        CoordinatesDelta cdEnd2 = PrimitiveDeserializer.parseCoordinatesDelta(tokens);

        return new CommandCreateTrackCrossover(idToken, reference, cdStart1, cdEnd1, cdStart2, cdEnd2);
    }

    @Override
    protected boolean isLeaf() {
        return true;
    }
}
