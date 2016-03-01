package w16cs350.controller.cli.parser.patterns.creational.power;

import w16cs350.controller.cli.parser.CommandParser;
import w16cs350.controller.cli.parser.PrimitiveDeserializer;
import w16cs350.controller.cli.parser.patterns.A_IteratingPatternMatcher;
import w16cs350.controller.cli.parser.patterns.A_PatternMatcher;
import w16cs350.controller.command.A_Command;
import w16cs350.controller.command.creational.CommandCreatePowerSubstation;
import w16cs350.datatype.CoordinatesDelta;
import w16cs350.datatype.CoordinatesWorld;
import w16cs350.support.Assert;

import java.util.List;
import java.util.ListIterator;

/**
 * Created by michael on 2/24/16.
 */
public class PowerSubstationPatternMatcher extends A_IteratingPatternMatcher {
    public PowerSubstationPatternMatcher(A_PatternMatcher parent) { super(parent); }

    @Override
    protected boolean isMatch(ListIterator<String> tok) {
        String token = tok.next();
        return token.equals("CATENARY");
    }

    @Override
    protected void initializeMatchers() {
        throw new UnsupportedOperationException();
    }

    @Override
    protected A_Command parseCommand(ListIterator<String> tokens) {
        String idToken = tokens.next();
        CommandParser cp = (CommandParser) getRoot();
        CoordinatesWorld ref = PrimitiveDeserializer.parseReference(tokens, cp.getHelper());
        String deltaToken = tokens.next();
        Assert.isTrue(deltaToken.equals("DELTA"), "Incorrect input, expected: DELTA");
        CoordinatesDelta cd = PrimitiveDeserializer.parseCoordinatesDelta(tokens);
        String withToken = tokens.next();
        Assert.isTrue(withToken.equals("WITH"), "Incorrect input, expected: WITH");
        String catenariesToken = tokens.next();
        Assert.isTrue(catenariesToken.equals("CATENARIES"), "Incorrect input, expected: CATENARIES");
        List<String> catenaryIDs = PrimitiveDeserializer.parserIDList(tokens);
        return new CommandCreatePowerSubstation(idToken, ref, cd, catenaryIDs);
    }

    @Override
    protected boolean isLeaf() {
        return true;
    }
}
