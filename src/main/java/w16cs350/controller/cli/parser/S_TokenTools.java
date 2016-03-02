package w16cs350.controller.cli.parser;

import w16cs350.support.Assert;

import java.util.ListIterator;


public class S_TokenTools {

    private static S_TokenTools ourInstance = new S_TokenTools();
    private ListIterator<String> _tokens;
    private String _pattern;

    private S_TokenTools() {
    }

    public static S_TokenTools getInstance() {
        return ourInstance;
    }

    /**
     * builds a string providing more details
     * about the error conditions
     *
     * @param where         - the class where the fault occurs
     * @param error_postfix - optional postfix to error message
     * @return - the error string
     */
    public String buildError(String where, String error_postfix) {

        return "\nclass   : " + getClass().getSimpleName() +
                "\nmethod  : " + where +
                "\npattern : " + (_pattern == null ? "null\n" : "\"" + _pattern) + "\"\n" +
                (error_postfix == null ? "" : "message : " + error_postfix);
    }

    /**
     * overload of class buildError(String where, String error_postfix
     *
     * @param where - the class where the fault occurs
     */
    public String buildError(String where) {
        return buildError(where, "");
    }

    /**
     * Assert that there is a next token then return it as a string,
     * Advances the iterator
     *
     * @param error_postfix - Error details statement
     * @throws IllegalArgumentException
     */
    public String getNextToken(String error_postfix) {
        Assert.isTrue(_tokens.hasNext(), buildError("getNextToken", error_postfix));
        return _tokens.next();
    }

    /**
     * Assert the next token is the last one in the iterator,
     * the last token gets returned
     *
     * @param error_postfix - Error details statement
     * @throws IllegalArgumentException
     */
    public String getLastToken(String error_postfix) {
        Assert.isTrue(_tokens.hasNext(), buildError("getLastToken", error_postfix));
        String next_token = _tokens.next();
        Assert.isFalse(_tokens.hasNext(), buildError("getLastToken", error_postfix));
        return next_token;
    }

    /**
     * Assert that there is a previous token then return it as a string,
     * Advances the iterator
     *
     * @param error_postfix - Error details statement
     * @throws IllegalArgumentException
     */
    public String getPreviousToken(String error_postfix) {
        Assert.isTrue(_tokens.hasPrevious(), buildError("getPreviousToken", error_postfix));
        String previous = _tokens.previous();
        _tokens.next();
        return previous;
    }

    /**
     * Assert that there is a next token and it matches the expected string,
     * advances the iterator
     *
     * @param error_postfix - Error details statement
     * @throws IllegalArgumentException
     */
    public void hasNextToken(String error_postfix) {
        Assert.isTrue(_tokens.hasNext(), buildError("nextTokenIs", error_postfix));
    }

    /**
     * Assert that there is a next token and advances the iterator
     *
     * @param error_postfix - Error details statement
     * @throws IllegalArgumentException
     */
    public void nextToken(String error_postfix) {
        Assert.isTrue(_tokens.hasNext(), buildError("nextTokenIs", error_postfix));
        _tokens.next();
    }

    /**
     * Assert that there is a next token and statement
     *
     * @throws IllegalArgumentException
     */
    public void nextTokenIs(String expected, String error_postfix) {
        Assert.isNonnull(expected, buildError("nextTokenIs", error_postfix));
        Assert.isTrue(_tokens.hasNext(), buildError("nextTokenIs", error_postfix));
        String t_next = _tokens.next();
        Assert.isTrue(t_next.equals(expected), buildError("nextTokenIs", error_postfix));
    }

    /**
     * Gets a copy of the next token then rewinds the iterator to
     * the original location
     *
     * @param error_postfix - Error details statement
     * @throws IllegalArgumentException
     */
    public String peekNextToken(String error_postfix) {
        Assert.isTrue(_tokens.hasNext(), buildError("peekNextToken", error_postfix));
        String next_token = _tokens.next();
        _tokens.previous();
        return next_token;
    }

    /**
     * Gets a copy of the next next token then rewinds the iterator to
     * the original location
     *
     * @param error_postfix - Error details statement
     * @throws IllegalArgumentException
     */
    public String peekNextNextToken(String error_postfix) {
        nextToken("advance token");
        String next_token = peekNextToken("peek next next");
        previousToken("previous token");
        return next_token;
    }

    /**
     * Assert the next token is the last one in the iterator,
     * the last token gets returned
     *
     * @param error_postfix - Error details statement
     * @throws IllegalArgumentException
     */
    public void previousToken(String error_postfix) {
        Assert.isTrue(_tokens.hasPrevious(), buildError("previousToken", error_postfix));
        _tokens.previous();
    }

    public void setPattern(String pattern) {
        Assert.isNonnull(pattern, buildError("setPattern", "pattern null"));
        _pattern = pattern;
    }

    /**
     * Boxes a string into a double
     *
     * @param token - the token to convert to a double
     * @return - the string boxed to a double
     */
    public double toDouble(String token) {
        try {
            return Double.parseDouble(token);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(buildError("toDouble"));
        }
    }

    /**
     * Sets the _tokens pointer
     *
     * @param tokens - the current token list
     */
    public void _tokensSet(ListIterator<String> tokens, String error_postfix) {
        Assert.isNonnull(tokens, buildError("_tokenSet", error_postfix));
        _tokens = tokens;
    }
}


