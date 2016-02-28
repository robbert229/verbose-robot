package w16cs350.controller.cli.parser.patterns.meta;

import w16cs350.controller.cli.parser.A_ParserHelper;
import w16cs350.controller.cli.parser.CommandParser;
import w16cs350.controller.cli.parser.EmptyCommand;
import w16cs350.controller.cli.parser.PrimitiveDeserializer;
import w16cs350.controller.cli.parser.patterns.A_IteratingPatternMatcher;
import w16cs350.controller.cli.parser.patterns.A_PatternMatcher;
import w16cs350.controller.command.A_Command;
import w16cs350.datatype.CoordinatesWorld;

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
        CommandParser commandParser = (CommandParser) getRoot();
        A_ParserHelper store = commandParser.getHelper();

        String id = tokens.next();
        String raw = tokens.next();
        CoordinatesWorld world = PrimitiveDeserializer.parseCoordinatesWorld(tokens);

        store.addReference(id, world);
        return new EmptyCommand();
    }

    @Override
    protected boolean isLeaf() {
        return true;
    }
}
