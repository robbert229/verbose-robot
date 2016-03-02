package w16cs350.controller.cli.parser.patterns.behavioral.do_;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import w16cs350.controller.cli.parser.patterns.behavioral.do_.brake.BrakePatternMatcher_TEST;
import w16cs350.controller.cli.parser.patterns.behavioral.do_.select.DrawbridgePatternMatcher_TEST;
import w16cs350.controller.cli.parser.patterns.behavioral.do_.select.RoundhousePatternMatcher_TEST;
import w16cs350.controller.cli.parser.patterns.behavioral.do_.select.SwitchPatternMatcher_TEST;
import w16cs350.controller.cli.parser.patterns.behavioral.do_.set.DirectionPatternMatcher_TEST;
import w16cs350.controller.cli.parser.patterns.behavioral.do_.set.ReferencePatternMatcher_TEST;
import w16cs350.controller.cli.parser.patterns.behavioral.do_.set.SpeedPatternMatcher_TEST;

/**
 * Created by RowleyJohn on 2/26/2016.
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({
        BrakePatternMatcher_TEST.class,
        DrawbridgePatternMatcher_TEST.class,
        RoundhousePatternMatcher_TEST.class,
        SwitchPatternMatcher_TEST.class,
        DirectionPatternMatcher_TEST.class,
        ReferencePatternMatcher_TEST.class,
        SpeedPatternMatcher_TEST.class
        })
public class BehavoiralTestSuite {
}
