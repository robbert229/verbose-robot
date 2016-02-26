package w16cs350.controller.cli.parser.patterns.meta;

import w16cs350.controller.cli.parser.patterns.A_IteratingPatternMatcher;
import w16cs350.controller.cli.parser.patterns.A_PatternMatcher;
import w16cs350.controller.command.A_Command;
import w16cs350.controller.command.meta.CommandMetaDoRun;

import java.util.ListIterator;

/**
 * Created by RowleyJohn on 2/24/2016.
 */
public class RunPatternMatcher extends A_IteratingPatternMatcher {
    public RunPatternMatcher(A_PatternMatcher parent) {
        super(parent);
    }

    @Override
    protected boolean isMatch(ListIterator<String> tok) {
        String token = tok.next();
        tok.previous();

        return token.equals("@RUN");
    }

    @Override
    protected void initializeMatchers() {
        throw new UnsupportedOperationException();
    }

    @Override
    protected A_Command parseCommand(ListIterator<String> tokens) {
        return new CommandMetaDoRun(tokens.next());
    }

    @Override
    protected boolean isLeaf() {
        return true;
    }
}
