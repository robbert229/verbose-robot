package w16cs350.controller.cli.parser.patterns.behavioral;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import w16cs350.controller.cli.parser.patterns.behavioral.brake.BrakePatternMatcherTest;
import w16cs350.controller.cli.parser.patterns.behavioral.select.DrawbridgePatternMatcherTest;
import w16cs350.controller.cli.parser.patterns.behavioral.select.RoundhousePatternMatcherTest;
import w16cs350.controller.cli.parser.patterns.behavioral.select.SwitchPatternMatcherTest;
import w16cs350.controller.cli.parser.patterns.behavioral.set.DirectionPatternMatcherTest;
import w16cs350.controller.cli.parser.patterns.behavioral.set.ReferencePatternMatcherTest;
import w16cs350.controller.cli.parser.patterns.behavioral.set.SpeedPatternMatcherTest;

/**
 * Created by johnrowleyster on 3/2/16.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        DirectionPatternMatcherTest.class,
        ReferencePatternMatcherTest.class,
        SpeedPatternMatcherTest.class,
        SwitchPatternMatcherTest.class,
        RoundhousePatternMatcherTest.class,
        DrawbridgePatternMatcherTest.class,
        BrakePatternMatcherTest.class
})

public class BehavioralTestSuite {
}
