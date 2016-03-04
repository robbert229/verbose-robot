package w16cs350.controller.cli.parser.patterns;

import w16cs350.controller.cli.parser.patterns.behavioral.BehavioralPatternmatcher;
import w16cs350.controller.cli.parser.patterns.creational.CreationalCategoryPatternMatcher;
import w16cs350.controller.cli.parser.patterns.meta.MetaCategoryPatternMatcher;
import w16cs350.controller.cli.parser.structural.StructuralPatternMatcher;

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
        getPatternMatchers().add(new BehavioralPatternmatcher(this));
        getPatternMatchers().add(new CreationalCategoryPatternMatcher(this));
        getPatternMatchers().add(new StructuralPatternMatcher(this));
    }
}
