package w16cs350.controller.cli.parser.patterns.meta;

import w16cs350.controller.cli.parser.patterns.A_PatternMatcher;
import w16cs350.controller.cli.parser.patterns.A_SubPatternMatcher;
import w16cs350.controller.command.A_Command;
import w16cs350.controller.command.meta.CommandMetaDoExit;

import java.util.ListIterator;

/**
 * Created by RowleyJohn on 2/24/2016.
 */
public class ExitPatternMatcher extends A_SubPatternMatcher{
    public ExitPatternMatcher(A_PatternMatcher parent) {
        super(parent, "@EXIT");
    }

    @Override
    protected boolean isMatch(ListIterator<String> tokens) {
        _tokensSet(tokens, null);
        return peekNextToken("matching token").equals("@EXIT");
    }

    @Override
    protected void initializeMatchers() {
        throw new UnsupportedOperationException();
    }

    @Override
    protected A_Command parseCommand(ListIterator<String> tokens) {
        return new CommandMetaDoExit();
    }

    @Override
    protected boolean isLeaf() {
        return true;
    }
}
