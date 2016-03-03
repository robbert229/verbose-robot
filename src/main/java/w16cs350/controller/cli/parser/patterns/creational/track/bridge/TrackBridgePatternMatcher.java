package w16cs350.controller.cli.parser.patterns.creational.track.bridge;

import w16cs350.controller.cli.parser.patterns.A_NonIteratingPatternMatcher;
import w16cs350.controller.cli.parser.patterns.A_PatternMatcher;

/**
 * Created by michael on 2/26/16.
 */
public class TrackBridgePatternMatcher extends A_NonIteratingPatternMatcher {
    public TrackBridgePatternMatcher(A_PatternMatcher parent) {
        super(parent);
    }

    @Override
    protected void initializeMatchers() {
        getPatternMatchers().add(new TrackBridgeFixedPatternMatcher(this));
        getPatternMatchers().add(new TrackBridgeDrawPatternMatcher(this));
    }
}
