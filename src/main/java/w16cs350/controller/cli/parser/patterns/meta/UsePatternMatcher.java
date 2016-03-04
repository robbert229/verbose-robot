package w16cs350.controller.cli.parser.patterns.meta;

import w16cs350.controller.cli.parser.A_ParserHelper;
import w16cs350.controller.cli.parser.PrimitiveDeserializer;
import w16cs350.controller.cli.parser.patterns.A_PatternMatcher;
import w16cs350.controller.cli.parser.patterns.A_SubPatternMatcher;
import w16cs350.controller.command.A_Command;
import w16cs350.datatype.CoordinatesWorld;
import w16cs350.support.Assert;

import java.util.ListIterator;

/**
 * Created by RowleyJohn on 2/23/2016.
 */
public class UsePatternMatcher extends A_SubPatternMatcher {
    public UsePatternMatcher(A_PatternMatcher parent) {
        super(parent, "USE");
    }

    @Override
    protected boolean isMatch(ListIterator<String> tok) {
        return peekNextToken("matching USE").equals("USE");
    }

    @Override
    protected void initializeMatchers() {
        throw new UnsupportedOperationException();
    }

    @Override
    protected A_Command parseCommand(ListIterator<String> tokens) {
        A_ParserHelper store = getHelper();
        String id = getNextToken("matching ID");
        Assert.isTrue(getNextToken("matching AS").equals("AS"), "Token should be AS");
        Assert.isTrue(getNextToken("matching REFERENCE").equals("REFERENCE"), "Token should be REFERENCE");
        CoordinatesWorld world = PrimitiveDeserializer.parseCoordinatesWorld(tokens);
        store.addReference(id, world);
        return null;
    }

    @Override
    protected boolean isLeaf() {
        return true;
    }
}
