package w16cs350.controller.cli.parser.patterns.behavioral.do_.set;

import w16cs350.controller.cli.parser.patterns.A_IteratingPatternMatcher;
import w16cs350.controller.cli.parser.patterns.A_PatternMatcher;
import w16cs350.controller.command.A_Command;
import w16cs350.controller.command.behavioral.CommandBehavioralSetReference;
import w16cs350.support.Assert;

import java.util.ListIterator;

/**
 * Utility methods to recognize and handle "REFERENCE" commands
 *
 * @author Josh Cotes
 * @version 1.0
 */
public class ReferencePatternMatcher extends A_IteratingPatternMatcher {
    private static String errorString = "user input error \"REFERENCE\" pattern matcher";

    /**
     * Constructor builds from the parent class
     *
     * @param parent - The parent class
     */
    public ReferencePatternMatcher(A_PatternMatcher parent) {
        super(parent);
    }

    @Override
    protected void initializeMatchers() {
        throw new UnsupportedOperationException();
    }

    @Override
    protected boolean isMatch(ListIterator<String> tokens) {
        Assert.isTrue(tokens.hasNext(), errorString);
        String token = tokens.next();
        tokens.previous();
        return token.equals("REFERENCE");
    }

    @Override
    protected A_Command parseCommand(ListIterator<String> tokens) {
        Assert.isTrue(tokens.hasNext(), errorString);
        Assert.isTrue(tokens.next().equals("ENGINE"), errorString);

        Assert.isTrue(tokens.hasNext(), errorString);
        String reference_id = tokens.next();
        Assert.isID(reference_id, errorString);

        return new CommandBehavioralSetReference(reference_id);
    }

    @Override
    protected boolean isLeaf() {
        return true;
    }
}
