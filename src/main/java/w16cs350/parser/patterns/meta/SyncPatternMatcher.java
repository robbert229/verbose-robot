package w16cs350.parser.patterns.meta;

import w16cs350.controller.command.A_Command;
import w16cs350.parser.A_IteratingPatternMatcher;
import w16cs350.parser.A_PatternMatcher;

import java.util.ListIterator;

/**
 * Created by RowleyJohn on 2/23/2016.
 */
public class SyncPatternMatcher extends A_IteratingPatternMatcher {
    public SyncPatternMatcher(A_PatternMatcher parent) {
        super(parent);
    }

    @Override
    protected boolean isMatch(String tok) {
        return tok.equals("SYNC");
    }

    @Override
    public void initializeMatchers() {
        getPatternMatchers().add(new SyncViewPatternMatcher(this));
    }

    @Override
    protected A_Command parseCommand(ListIterator<String> tokens) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected boolean isLeaf() {
        return false;
    }
}
