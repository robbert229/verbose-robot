package w16cs350.controller.cli.parser.patterns.creational;

import w16cs350.controller.cli.parser.patterns.A_IteratingPatternMatcher;
import w16cs350.controller.cli.parser.patterns.A_PatternMatcher;
import w16cs350.controller.cli.parser.patterns.creational.power.PowerPatternMatcher;
import w16cs350.controller.cli.parser.patterns.creational.stock.StockPatternMatcher;
import w16cs350.controller.cli.parser.patterns.creational.track.TrackPatternMatcher;
import w16cs350.controller.command.A_Command;

import java.util.ListIterator;

/**
 * Created by michael on 2/24/16.
 */
public class CreationalCategoryPatternMatcher extends A_IteratingPatternMatcher{
    public CreationalCategoryPatternMatcher(A_PatternMatcher parent) { super(parent); }

    @Override
    protected boolean isMatch(ListIterator<String> tok) {
        String token = tok.next();
        tok.previous();
        return token.equals("CREATE");
    }

    @Override
    protected void initializeMatchers() {
        getPatternMatchers().add(new StockPatternMatcher(this));
        getPatternMatchers().add(new PowerPatternMatcher(this));
        getPatternMatchers().add(new TrackPatternMatcher(this));
    }

    @Override
    protected A_Command parseCommand(ListIterator<String> tokens) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected boolean isLeaf() {
        return false;
    }
}
