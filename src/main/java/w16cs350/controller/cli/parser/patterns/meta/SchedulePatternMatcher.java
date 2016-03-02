package w16cs350.controller.cli.parser.patterns.meta;

import w16cs350.controller.cli.parser.patterns.A_PatternMatcher;
import w16cs350.controller.cli.parser.patterns.A_SubPatternMatcher;
import w16cs350.controller.cli.parser.patterns.RootPatternMatcher;
import w16cs350.controller.command.A_Command;
import w16cs350.controller.command.meta.CommandMetaDoSchedule;
import w16cs350.support.Assert;

import java.util.ListIterator;

/**
 * Created by RowleyJohn on 2/24/2016.
 */
public class SchedulePatternMatcher extends A_SubPatternMatcher {
    public SchedulePatternMatcher(A_PatternMatcher parent) {
        super(parent, "@SCHEDULE");
    }

    @Override
    protected boolean isMatch(ListIterator<String> tok) {
        return peekNextToken("@SCHEDULE").equals("@SCHEDULE");
    }

    @Override
    protected void initializeMatchers() {
        throw new UnsupportedOperationException();
    }

    @Override
    protected A_Command parseCommand(ListIterator<String> tokens) {
        Assert.isTrue(getNextToken("matching AT").equals("AT"), "Token should be AT");
        double simulationTimeNumber = Double.parseDouble(getNextToken("matching simulationTimeNumber"));

        RootPatternMatcher root = new RootPatternMatcher(this);
        return new CommandMetaDoSchedule(simulationTimeNumber, root.parse(tokens));
    }

    @Override
    protected boolean isLeaf() {
        return true;
    }
}
