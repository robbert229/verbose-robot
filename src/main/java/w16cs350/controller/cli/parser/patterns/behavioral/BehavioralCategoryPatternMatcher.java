package w16cs350.controller.cli.parser.patterns.behavioral;

import w16cs350.controller.cli.parser.patterns.A_IteratingPatternMatcher;
import w16cs350.controller.cli.parser.patterns.A_PatternMatcher;
import w16cs350.controller.command.A_Command;

import java.util.ListIterator;

public class BehavioralCategoryPatternMatcher extends A_IteratingPatternMatcher {
    public BehavioralCategoryPatternMatcher(A_PatternMatcher parent) { super(parent); }

    @Override
    protected boolean isMatch(ListIterator<String> tok) {
        return false;
    }

    @Override
    protected void initializeMatchers() {

    }

    @Override
    protected A_Command parseCommand(ListIterator<String> tokens) {
        return null;
    }

    @Override
    protected boolean isLeaf() {
        return false;
    }
}
