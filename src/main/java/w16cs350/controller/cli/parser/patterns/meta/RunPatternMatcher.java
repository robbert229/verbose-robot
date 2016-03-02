package w16cs350.controller.cli.parser.patterns.meta;

import w16cs350.controller.cli.parser.patterns.A_PatternMatcher;
import w16cs350.controller.cli.parser.patterns.A_SubPatternMatcher;
import w16cs350.controller.command.A_Command;
import w16cs350.controller.command.meta.CommandMetaDoRun;

import java.util.ListIterator;

/**
 * Created by RowleyJohn on 2/24/2016.
 */
public class RunPatternMatcher extends A_SubPatternMatcher {
    public RunPatternMatcher(A_PatternMatcher parent) {
        super(parent, "@RUN");
    }

    @Override
    protected boolean isMatch(ListIterator<String> tok) {
        return peekNextToken("matching @RUN").equals("@RUN");
    }

    @Override
    protected void initializeMatchers() {
        throw new UnsupportedOperationException();
    }

    @Override
    protected A_Command parseCommand(ListIterator<String> tokens) {
        return new CommandMetaDoRun(getNextToken("matching @RUN filepath"));
    }

    @Override
    protected boolean isLeaf() {
        return true;
    }
}
