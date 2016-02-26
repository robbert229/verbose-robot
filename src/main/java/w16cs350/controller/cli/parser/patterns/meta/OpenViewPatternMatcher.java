package w16cs350.controller.cli.parser.patterns.meta;

import w16cs350.controller.cli.parser.PrimitiveDeserializer;
import w16cs350.controller.cli.parser.patterns.A_IteratingPatternMatcher;
import w16cs350.controller.cli.parser.patterns.A_PatternMatcher;
import w16cs350.controller.command.A_Command;
import w16cs350.controller.command.meta.CommandMetaViewGenerate;
import w16cs350.datatype.CoordinatesScreen;
import w16cs350.datatype.CoordinatesWorld;
import w16cs350.support.Assert;

import java.util.ListIterator;

/**
 * Created by RowleyJohn on 2/25/2016.
 */
public class OpenViewPatternMatcher extends A_IteratingPatternMatcher {

    public OpenViewPatternMatcher(A_PatternMatcher parent) {
        super(parent);
    }

    @Override
    protected boolean isMatch(ListIterator<String> tok) {
        String open = tok.next();
        String view = tok.next();

        for(int i = 0; i < 2; i++)
            tok.previous();

        return open.equals("OPEN") && view.equals("VIEW");
    }

    @Override
    protected void initializeMatchers() {
        throw new UnsupportedOperationException();
    }

    @Override
    protected A_Command parseCommand(ListIterator<String> tokens) {
        Assert.isTrue(tokens.next().equals("VIEW"), "Token should be VIEW");
        String id = tokens.next();
        Assert.isTrue(tokens.next().equals("ORIGIN"), "Token should be ORIGIN");

        CoordinatesWorld coordinatesWorld;
        if(PrimitiveDeserializer.isNextCoordinatesWorld(tokens)){
            coordinatesWorld = PrimitiveDeserializer.parseCoordinatesWorld(tokens);
        } else {
            coordinatesWorld = getParserHelper().getReference(tokens.next());
            Assert.isNonnull(coordinatesWorld != null, "CoordinatesWorld shouldn't be NULL");
        }

        Assert.isTrue(tokens.next().equals("WORLD"), "Token should be WORLD");
        Assert.isTrue(tokens.next().equals("WIDTH"), "Token should be WIDTH");

        int worldWidth = Integer.parseInt(tokens.next());

        Assert.isTrue(tokens.next().equals("SCREEN"), "Token should be SCREEN");
        Assert.isTrue(tokens.next().equals("WIDTH"), "Token should be WIDTH");

        int screenWidth = Integer.parseInt(tokens.next());

        Assert.isTrue(tokens.next().equals("HEIGHT"), "Token should be HEIGHT");

        int screenHeight = Integer.parseInt(tokens.next());

        return new CommandMetaViewGenerate(id, coordinatesWorld, worldWidth, new CoordinatesScreen(screenWidth, screenHeight));
    }

    @Override
    protected boolean isLeaf() {
        return true;
    }
}
