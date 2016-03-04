package w16cs350.controller.cli.parser.patterns.creational.power;

import w16cs350.controller.cli.parser.patterns.A_IteratingPatternMatcher;
import w16cs350.controller.cli.parser.patterns.A_PatternMatcher;
import w16cs350.controller.command.A_Command;

import java.util.ListIterator;

/**
 * Created by michael on 2/24/16.
 */
public class PowerPatternMatcher extends A_IteratingPatternMatcher {
        public PowerPatternMatcher(A_PatternMatcher parent) { super(parent); }

    @Override
    protected boolean isMatch(ListIterator<String> tok) {
        String token = tok.next();
        tok.previous();
        return token.equals("POWER");
    }

    @Override
    protected void initializeMatchers() {
        getPatternMatchers().add(new PowerCatenaryPatternMatcher(this));
        getPatternMatchers().add(new PowerPolePatternMatcher(this));
        getPatternMatchers().add(new PowerStationPatternMatcher(this));
        getPatternMatchers().add(new PowerSubstationPatternMatcher(this));
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
