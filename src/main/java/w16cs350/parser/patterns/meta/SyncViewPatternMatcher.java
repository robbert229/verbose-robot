package w16cs350.parser.patterns.meta;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import w16cs350.controller.command.A_Command;
import w16cs350.controller.command.meta.CommandMetaViewSync;
import w16cs350.parser.A_IteratingPatternMatcher;
import w16cs350.parser.A_PatternMatcher;

import java.util.ListIterator;

/**
 * Created by RowleyJohn on 2/23/2016.
 */
public class SyncViewPatternMatcher extends A_IteratingPatternMatcher {
    public SyncViewPatternMatcher(A_PatternMatcher parent) {
        super(parent);
    }

    @Override
    protected boolean isMatch(String tok) {
        return tok.equals("VIEW");
    }

    @Override
    protected void initializeMatchers() {
        throw new UnsupportedOperationException();
    }

    @Override
    protected A_Command parseCommand(ListIterator<String> tokens) {
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
