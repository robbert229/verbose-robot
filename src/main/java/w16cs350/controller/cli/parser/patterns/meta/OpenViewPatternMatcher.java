package w16cs350.controller.cli.parser.patterns.meta;

import w16cs350.controller.cli.parser.PrimitiveDeserializer;
import w16cs350.controller.cli.parser.patterns.A_PatternMatcher;
import w16cs350.controller.cli.parser.patterns.A_SubPatternMatcher;
import w16cs350.controller.command.A_Command;
import w16cs350.controller.command.meta.CommandMetaViewGenerate;
import w16cs350.datatype.CoordinatesScreen;
import w16cs350.datatype.CoordinatesWorld;
import w16cs350.support.Assert;

import java.util.ListIterator;

/**
 * Created by RowleyJohn on 2/25/2016.
 */
public class OpenViewPatternMatcher extends A_SubPatternMatcher {

    public OpenViewPatternMatcher(A_PatternMatcher parent) {
        super(parent, "OPEN");
    }

    @Override
    protected boolean isMatch(ListIterator<String> tok) {
        _tokensSet(tok, null);
        return peekNextToken("matching OPEN").equals("OPEN") &&
            peekNextNextToken("matching VIEW").equals("VIEW");

    }

    @Override
    protected void initializeMatchers() {
        throw new UnsupportedOperationException();
    }

    @Override
    protected A_Command parseCommand(ListIterator<String> tokens) {
        _tokensSet(tokens, null);


        Assert.isTrue(getNextToken("matching VIEW").equals("VIEW"), "Token should be VIEW");
        String id = getNextToken("matching ID");
        Assert.isTrue(getNextToken("matching ORIGIN").equals("ORIGIN"), "Token should be ORIGIN");

        CoordinatesWorld coordinatesWorld;
        if(PrimitiveDeserializer.isNextCoordinatesWorld(tokens)){
            coordinatesWorld = PrimitiveDeserializer.parseCoordinatesWorld(tokens);
        } else {
            coordinatesWorld = getHelper().getReference(tokens.next());
            Assert.isNonnull(coordinatesWorld != null, "CoordinatesWorld shouldn't be NULL");
        }

        Assert.isTrue(getNextToken("matching WORLD").equals("WORLD"), "Token should be WORLD");
        Assert.isTrue(getNextToken("matching WIDTH").equals("WIDTH"), "Token should be WIDTH");

        int worldWidth = Integer.parseInt(getNextToken("matching worldWidth"));

        Assert.isTrue(getNextToken("matching SCREEN").equals("SCREEN"), "Token should be SCREEN");
        Assert.isTrue(getNextToken("matching WIDTH").equals("WIDTH"), "Token should be WIDTH");

        int screenWidth = Integer.parseInt(getNextToken("matching screenWidth"));

        Assert.isTrue(getNextToken("matching HEIGHT").equals("HEIGHT"), "Token should be HEIGHT");

        int screenHeight = Integer.parseInt(getNextToken("matching screenHeight"));

        return new CommandMetaViewGenerate(id, coordinatesWorld, worldWidth, new CoordinatesScreen(screenWidth, screenHeight));
    }

    @Override
    protected boolean isLeaf() {
        return true;
    }
}
