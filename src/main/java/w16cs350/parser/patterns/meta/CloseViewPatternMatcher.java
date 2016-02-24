package w16cs350.parser.patterns.meta;

import w16cs350.controller.command.A_Command;
import w16cs350.controller.command.meta.CommandMetaViewDestroy;
import w16cs350.parser.A_IteratingPatternMatcher;
import w16cs350.parser.A_PatternMatcher;

import java.util.ListIterator;

/**
 * Created by RowleyJohn on 2/23/2016.
 */
public class CloseViewPatternMatcher extends A_IteratingPatternMatcher{
    public CloseViewPatternMatcher(A_PatternMatcher parent) {
        super(parent);
    }

    @Override
    protected boolean isMatch(ListIterator<String> tokens) {
        String token = tokens.next();
        tokens.previous();

        return token.equals("CLOSE");
    }

    @Override
    protected void initializeMatchers() {
        throw new UnsupportedOperationException();
    }

    @Override
    protected A_Command parseCommand(ListIterator<String> tokens) {
        assert(tokens.next().equals("VIEW"));
        return new CommandMetaViewDestroy(tokens.next());
    }

    @Override
    protected boolean isLeaf() {
        return true;
    }
}
