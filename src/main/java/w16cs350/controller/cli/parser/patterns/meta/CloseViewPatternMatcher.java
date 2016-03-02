package w16cs350.controller.cli.parser.patterns.meta;

import w16cs350.controller.cli.parser.patterns.A_PatternMatcher;
import w16cs350.controller.cli.parser.patterns.A_SubPatternMatcher;
import w16cs350.controller.command.A_Command;
import w16cs350.controller.command.meta.CommandMetaViewDestroy;

import java.util.ListIterator;

/**
 * Created by RowleyJohn on 2/23/2016.
 */
public class CloseViewPatternMatcher extends A_SubPatternMatcher{
    public CloseViewPatternMatcher(A_PatternMatcher parent) {
        super(parent, "CLOSE");
    }

    @Override
    protected boolean isMatch(ListIterator<String> tokens) {
        _tokensSet(tokens, null);
        return peekNextToken("matching token").equals("CLOSE");
    }

    @Override
    protected void initializeMatchers() {
        throw new UnsupportedOperationException();
    }

    @Override
    protected A_Command parseCommand(ListIterator<String> tokens) {
        _tokensSet(tokens, null);
        nextTokenIs("VIEW", "Token should be VIEW");
        return new CommandMetaViewDestroy(getNextToken("Token should be an ID"));
    }

    @Override
    protected boolean isLeaf() {
        return true;
    }
}
