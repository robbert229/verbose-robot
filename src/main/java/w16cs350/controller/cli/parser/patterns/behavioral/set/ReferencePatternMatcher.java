package w16cs350.controller.cli.parser.patterns.behavioral.set;

import w16cs350.controller.cli.parser.patterns.A_PatternMatcher;
import w16cs350.controller.cli.parser.patterns.A_SubPatternMatcher;
import w16cs350.controller.command.A_Command;
import w16cs350.controller.command.behavioral.CommandBehavioralSetReference;

import java.util.ListIterator;

/**
 * Utility methods to recognize and handle "REFERENCE" commands
 *
 * @author Josh Cotes
 * @version 1.1
 */
public class ReferencePatternMatcher extends A_SubPatternMatcher {

    /**
     * Constructor initializes the pattern matcher using the parent class
     *
     * @param parent - The parent class
     */
    public ReferencePatternMatcher(A_PatternMatcher parent) {
        super(parent, "REFERENCE");
    }

    @Override
    protected boolean isMatch(ListIterator<String> tokens) {
        _tokensSet(tokens, null);
        previousToken("advance token");
        return peekNextToken("matching token").equals("REFERENCE");
    }

    @Override
    protected void initializeMatchers() {
        throw new UnsupportedOperationException();
    }

    @Override
    protected A_Command parseCommand(ListIterator<String> tokens) {
        _tokensSet(tokens, null);
        nextTokenIs("ENGINE", "ENGINE command");
        String reference_id = getNextToken("reference ID");
        return new CommandBehavioralSetReference(reference_id);
    }

    @Override
    protected boolean isLeaf() {
        return true;
    }
}
