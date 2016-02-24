package w16cs350.parser;

import w16cs350.controller.command.A_Command;

import java.util.ListIterator;

/**
 * Created by RowleyJohn on 2/23/2016.
 */

/**
 * This pattern matcher does not consume any tokens. It instead will match based on its children, allowing for meta and
 * catagorical PatternMatching for better organization. It MUST have children, as its matching is based off of its'
 * children.
 */
public abstract class A_NonIteratingPatternMatcher extends A_PatternMatcher {
    public A_NonIteratingPatternMatcher(A_PatternMatcher parent) {
        super(parent);
    }

    /**
     * Unlike A_PatternMatcher's isMatch, isMatch will return true, if and only if one of its children's isMatch returns
     * true on the specified token.
     * @param tok The token to be matched.
     * @return True if the token mathces a child, False otherwise.
     */
    @Override
    protected final boolean isMatch(ListIterator<String> tok) {
        for(A_PatternMatcher m : getPatternMatchers()){
            if(m.isMatch(tok))
                return true;
        }

        return false;
    }

    /**
     * Throws an exception.
     * @param tokens Used as parameters for commands.
     * @return The commadn that would be returned.
     */
    @Override
    protected final A_Command parseCommand(ListIterator<String> tokens) {
        throw new UnsupportedOperationException();
    }

    /**
     * Always returns false. Some A_NonIteratingPatternMatcher can not be a leaf node.
     * @return Returns false.
     */
    @Override
    protected final boolean isLeaf() {
        return false;
    }

    /**
     * Does nothing. The method is empty.
     * @param iterator the iterator.
     */
    @Override
    protected final void traverse(ListIterator<String> iterator) {
        //do nothing
    }
}
