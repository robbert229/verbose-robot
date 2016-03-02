package w16cs350.controller.cli.parser.patterns;

import w16cs350.controller.cli.parser.patterns.meta.MetaCategoryPatternMatcher;

/**
 * Created by RowleyJohn on 2/25/2016.
 */
public class RootPatternMatcher extends A_NonIteratingPatternMatcher {
    public RootPatternMatcher(A_PatternMatcher parent) {
        super(parent);
    }

    @Override
    protected void initializeMatchers() {
        getPatternMatchers().add(new MetaCategoryPatternMatcher(this));
    }
}
