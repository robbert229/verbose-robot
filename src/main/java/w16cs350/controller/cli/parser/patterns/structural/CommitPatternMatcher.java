package w16cs350.controller.cli.parser.patterns.structural;

import w16cs350.controller.cli.parser.patterns.A_IteratingPatternMatcher;
import w16cs350.controller.cli.parser.patterns.A_PatternMatcher;
import w16cs350.controller.command.A_Command;
import w16cs350.controller.command.structural.CommandStructuralCommit;

import java.util.ListIterator;

/**
 * Created by michael on 3/3/16.
 */
public class CommitPatternMatcher extends A_IteratingPatternMatcher {
    public CommitPatternMatcher(A_PatternMatcher parent) {
        super(parent);
    }

    @Override
    protected boolean isMatch(ListIterator<String> tok) {
        String token = tok.next();
        tok.previous();
        return token.equals("COMMIT");
    }

    @Override
    protected void initializeMatchers() {
        throw new UnsupportedOperationException();
    }

    @Override
    protected A_Command parseCommand(ListIterator<String> tokens) {
        return new CommandStructuralCommit();
    }

    @Override
    protected boolean isLeaf() {
        return true;
    }
}
