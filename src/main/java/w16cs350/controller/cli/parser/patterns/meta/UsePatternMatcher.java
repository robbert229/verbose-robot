package w16cs350.controller.cli.parser.patterns.meta;

import w16cs350.controller.cli.parser.*;
import w16cs350.controller.command.A_Command;
import w16cs350.datatype.CoordinatesWorld;
import w16cs350.controller.cli.parser.patterns.A_IteratingPatternMatcher;
import w16cs350.controller.cli.parser.patterns.A_PatternMatcher;
import w16cs350.support.Assert;

import java.util.ListIterator;

/**
 * Created by RowleyJohn on 2/23/2016.
 */
public class UsePatternMatcher extends A_IteratingPatternMatcher {
    public UsePatternMatcher(A_PatternMatcher parent) {
        super(parent);
    }

    @Override
    protected boolean isMatch(ListIterator<String> tok) {
        String token = tok.next();
        tok.previous();

        return token.equals("USE");
    }

    @Override
    protected void initializeMatchers() {
        throw new UnsupportedOperationException();
    }

    @Override
    protected A_Command parseCommand(ListIterator<String> tokens) {
        A_ParserHelper store = getParserHelper();

        String id = tokens.next();
        Assert.isTrue(tokens.next().equals("AS"), "Token should be AS");
        Assert.isTrue(tokens.next().equals("REFERENCE"), "Token should be REFERENCE");

        CoordinatesWorld world = PrimitiveDeserializer.parseCoordinatesWorld(tokens);

        store.addReference(id, world);
        return new EmptyCommand();
    }

    @Override
    protected boolean isLeaf() {
        return true;
    }
}
