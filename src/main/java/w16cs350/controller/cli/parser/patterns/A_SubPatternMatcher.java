package w16cs350.controller.cli.parser.patterns;

import w16cs350.controller.cli.parser.EmptyCommand;
import w16cs350.controller.cli.parser.patterns.A_IteratingPatternMatcher;
import w16cs350.controller.cli.parser.patterns.A_PatternMatcher;
import w16cs350.controller.cli.parser.patterns.behavioral.do_.S_TokenTools;
import w16cs350.controller.command.A_Command;

import java.util.ListIterator;

/**
 * A_SubPatternMatcher contains a set of tools needed to
 * match SELECT commands with proxy calls
 *
 * @author Josh Cotes
 * @version 1.1
 */
public abstract class A_SubPatternMatcher extends A_IteratingPatternMatcher {

    private S_TokenTools tokenTools;

    /**
     * Constructor initializes the pattern matcher using the parent class
     *
     * @param parent - The parent pattern matches
     * @throws IllegalArgumentException
     */
    protected A_SubPatternMatcher(A_PatternMatcher parent, String pattern) {
        super(parent);
        tokenTools = S_TokenTools.getInstance();
        tokenTools.setPattern(pattern);
    }

    @Override
    protected void initializeMatchers() {
        throw new UnsupportedOperationException();
    }

    @Override
    protected boolean isLeaf() {
        return true;
    }

    @Override
    protected A_Command parseCommand(ListIterator<String> tokens) {
        _tokensSet(tokens, null);
        hasNextToken("check for next token");
        return new EmptyCommand();
    }

    // Proxy method calls, see TokenTools///
    protected String buildError(String where, String error_postfix) {return tokenTools.buildError(where, error_postfix);}
    protected String buildError(String where) {return tokenTools.buildError(where);}
    protected String getNextToken(String error_postfix) {return tokenTools.getNextToken(error_postfix);}
    protected String getLastToken(String error_postfix) {return tokenTools.getLastToken(error_postfix);}
    protected String getPreviousToken(String error_postfix) {return tokenTools.getPreviousToken(error_postfix);}
    protected void hasNextToken(String error_postfix) {tokenTools.hasNextToken(error_postfix);}
    protected void nextToken(String error_postfix) {tokenTools.nextToken(error_postfix);}
    protected void nextTokenIs(String expected, String error_postfix) {tokenTools.nextTokenIs(expected, error_postfix);}
    protected String peekNextToken(String error_postfix) {return tokenTools.peekNextToken(error_postfix); }
    public String peekNextNextToken(String error_postfix) {return tokenTools.peekNextNextToken(error_postfix); }
    protected void previousToken(String error_postfix) {tokenTools.previousToken(error_postfix);}
    protected void setPattern(String pattern) {tokenTools.setPattern(pattern);}
    protected double toDouble(String token) {return tokenTools.toDouble(token);}
    protected void _tokensSet(ListIterator<String> tokens, String error_postfix) {tokenTools._tokensSet(tokens, error_postfix);}
}