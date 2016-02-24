package w16cs350.parser.patterns.meta;

import w16cs350.controller.command.A_Command;
import w16cs350.controller.command.meta.CommandMetaDoWait;
import w16cs350.controller.timing.Time;
import w16cs350.parser.A_IteratingPatternMatcher;
import w16cs350.parser.A_PatternMatcher;

import java.util.ListIterator;

/**
 * Created by RowleyJohn on 2/23/2016.
 */
public class WaitPatternMatcher extends A_IteratingPatternMatcher{
    public WaitPatternMatcher(A_PatternMatcher parent) {
        super(parent);
    }

    @Override
    protected boolean isMatch(ListIterator<String> tok) {
        String token = tok.next();
        tok.previous();

        return token.equals("@WAIT");
    }

    @Override
    protected void initializeMatchers() {
        throw new UnsupportedOperationException();
    }

    @Override
    protected A_Command parseCommand(ListIterator<String> tokens) {
        String token = tokens.next();
        Long time = Long.parseLong(token);
        return new CommandMetaDoWait(new Time(time));
    }

    @Override
    protected boolean isLeaf() {
        return true;
    }
}
