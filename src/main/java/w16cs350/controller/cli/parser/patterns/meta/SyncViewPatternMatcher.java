package w16cs350.controller.cli.parser.patterns.meta;

import w16cs350.controller.command.A_Command;
import w16cs350.controller.command.meta.CommandMetaViewSync;
import w16cs350.controller.cli.parser.patterns.A_IteratingPatternMatcher;
import w16cs350.controller.cli.parser.patterns.A_PatternMatcher;

import java.util.ListIterator;

/**
 * Created by RowleyJohn on 2/23/2016.
 */
public class SyncViewPatternMatcher extends A_IteratingPatternMatcher {
    public SyncViewPatternMatcher(A_PatternMatcher parent) {
        super(parent);
    }

    @Override
    protected boolean isMatch(ListIterator<String> tokens) {
        String token = tokens.next();
        tokens.previous();

        return token.equals("SYNC");
    }

    @Override
    protected void initializeMatchers() {
        throw new UnsupportedOperationException();
    }

    @Override
    protected A_Command parseCommand(ListIterator<String> tokens) {
        assert(tokens.next().equals("VIEW")); // Remove View
        String viewId = tokens.next();
        boolean isNorthElseTrack = tokens.next().equals("NORTH");
        tokens.next(); // Remove ON
        String stockId = tokens.next();

        return new CommandMetaViewSync(viewId, stockId, isNorthElseTrack);
    }

    @Override
    protected boolean isLeaf() {
        return true;
    }
}
