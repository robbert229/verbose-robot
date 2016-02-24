package w16cs350.parser.patterns;

import java.util.ListIterator;

/**
 * Created by RowleyJohn on 2/23/2016.
 */

/**
 * This pattern matcher is the standard pattern matcher that MOST if not ALL pattern matchers must inherit from.
 */
public abstract class A_IteratingPatternMatcher extends A_PatternMatcher {

    public A_IteratingPatternMatcher(A_PatternMatcher parent) {
        super(parent);
    }

    /**
     * Causes the iterator to move on to the next element.
     * @param iterator the iterator that is going to be incremented.
     */
    @Override
    protected final void traverse(ListIterator<String> iterator) {
        iterator.next();
    }
}
