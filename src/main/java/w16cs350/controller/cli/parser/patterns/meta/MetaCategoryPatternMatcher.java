package w16cs350.controller.cli.parser.patterns.meta;

import w16cs350.controller.cli.parser.patterns.A_NonIteratingPatternMatcher;
import w16cs350.controller.cli.parser.patterns.A_PatternMatcher;

/**
 * Created by RowleyJohn on 2/23/2016.
 */
public class MetaCategoryPatternMatcher extends A_NonIteratingPatternMatcher {
    public MetaCategoryPatternMatcher(A_PatternMatcher parent) {
        super(parent);
    }

    @Override
    protected void initializeMatchers() {
        getPatternMatchers().add(new SyncViewPatternMatcher(this));
        getPatternMatchers().add(new CloseViewPatternMatcher(this));
        getPatternMatchers().add(new WaitPatternMatcher(this));
        getPatternMatchers().add(new UsePatternMatcher(this));
    }
}
