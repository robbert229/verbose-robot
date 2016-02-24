package w16cs350.parser.patterns.meta;

import w16cs350.parser.A_NonIteratingPatternMatcher;
import w16cs350.parser.A_PatternMatcher;

/**
 * Created by RowleyJohn on 2/23/2016.
 */
public class MetaCategoryPatternMatcher extends A_NonIteratingPatternMatcher {
    public MetaCategoryPatternMatcher(A_PatternMatcher parent) {
        super(parent);
    }

    @Override
    protected void initializeMatchers() {
        getPatternMatchers().add(new SyncPatternMatcher(this));
    }
}
