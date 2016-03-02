package w16cs350.controller.cli.parser.patterns.meta;

import w16cs350.controller.cli.parser.patterns.A_IteratingPatternMatcher;
import w16cs350.controller.cli.parser.patterns.A_PatternMatcher;
import w16cs350.controller.cli.parser.patterns.RootPatternMatcher;
import w16cs350.controller.command.A_Command;
import w16cs350.controller.command.meta.CommandMetaDoSchedule;
import w16cs350.support.Assert;

import java.util.ListIterator;

/**
 * Created by RowleyJohn on 2/24/2016.
 */
public class SchedulePatternMatcher extends A_IteratingPatternMatcher {
    public SchedulePatternMatcher(A_PatternMatcher parent) {
        super(parent);
    }

    @Override
    protected boolean isMatch(ListIterator<String> tok) {
        String token = tok.next();
        tok.previous();

        return token.equals("@SCHEDULE");
    }

    @Override
    protected void initializeMatchers() {
        throw new UnsupportedOperationException();
    }

    @Override
    protected A_Command parseCommand(ListIterator<String> tokens) {
        Assert.isTrue(tokens.next().equals("AT"), "Token should be AT");
        double simulationTimeNumber = Double.parseDouble(tokens.next());

        RootPatternMatcher root = new RootPatternMatcher(this);
        return new CommandMetaDoSchedule(simulationTimeNumber, root.parse(tokens));
    }

    @Override
    protected boolean isLeaf() {
        return true;
    }
}
