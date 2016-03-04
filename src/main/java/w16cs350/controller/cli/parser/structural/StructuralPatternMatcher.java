package w16cs350.controller.cli.parser.structural;

import w16cs350.controller.cli.parser.patterns.A_NonIteratingPatternMatcher;
import w16cs350.controller.cli.parser.patterns.A_PatternMatcher;

/**
 * Created by michael on 3/3/16.
 */
public class StructuralPatternMatcher extends A_NonIteratingPatternMatcher {
    public StructuralPatternMatcher(A_PatternMatcher parent) {
        super(parent);
    }

    @Override
    protected void initializeMatchers() {
        getPatternMatchers().add(new CommitPatternMatcher(this));
        getPatternMatchers().add(new CouplePatternMatcher(this));
        getPatternMatchers().add(new LocatePatternMatcher(this));
        getPatternMatchers().add(new UncouplePatternMatcher(this));
    }
}
