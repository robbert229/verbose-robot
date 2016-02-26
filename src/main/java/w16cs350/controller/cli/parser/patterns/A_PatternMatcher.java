package w16cs350.controller.cli.parser.patterns;
import w16cs350.controller.command.A_Command;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by johnrowleyster on 2/23/16.
 */

public abstract class A_PatternMatcher {
    private List<A_PatternMatcher> patternMatchers;
    private A_PatternMatcher parent;

    public A_PatternMatcher(A_PatternMatcher parent){
        patternMatchers = new LinkedList<>();
        if(!isLeaf())
            initializeMatchers();
        this.parent = parent;
    }

    /**
     * Returns this pattern matcher's parent pattern matcher.
     * @return this pattern matcher's parent.
     */
    public A_PatternMatcher getParent(){
        return parent;
    }

    /**
     * Returns the root of the pattern matcher tree
     * @return The root node of the tree
     */
    public A_PatternMatcher getRoot(){
        A_PatternMatcher p = this;
        while(p.getParent() != null)
            p = p.getParent();

        return p;
    }

    /**
     * Returns all Child Pattern Matchers that this node can delegate to.
     * @return The Children PatternMatcher for this node
     */
    public List<A_PatternMatcher> getPatternMatchers(){
        return patternMatchers;
    }

    /**
     * Returns true if this matcher can process the token.
     * @param tok The token to be processed.
     * @return Returns true if this pattern matcher can process the token.
     */
    protected abstract boolean isMatch(ListIterator<String> tok);

    /**
     * Adds all of the patternMatchers to the patternMatcher list (called from constructor)
     */
    protected abstract void initializeMatchers();

    /**
     * Returns a command built with the remaining tokens
     * @param tokens Used as parameters for commands.
     * @return Returns the fully parsed command
     */
    protected abstract A_Command parseCommand(ListIterator<String> tokens);

    /**
     * Returns true if this patternmatcher is a leaf node and should execute a command instead of delegating.
     * @return True if this node is a leaf.
     */
    protected abstract boolean isLeaf();

    /**
     * Parses a string and executes the command, or delegates that to a child patternMatcher if it is a leaf node.
     * @param iterator the iterator to be parsed.
     */
    public A_Command parse(ListIterator<String> iterator){
        traverse(iterator);
        if(isLeaf()){
            return parseCommand(iterator);
        } else {
            return delegate(iterator);
        }
    }

    /**
     * Delegates processing of a token to children matchers and returns the build command.
     * @param iterator the iterator containing the tokens.
     * @return Returns the command built by the tree
     */
    private A_Command delegate(ListIterator<String> iterator){
        String next = iterator.next();
        iterator.previous();

        for (A_PatternMatcher pattern : patternMatchers) {
            if (pattern.isMatch(iterator)) {
                return pattern.parse(iterator);
            }
        }
        throw new RuntimeException("No PatternMatcher For Token: " + next);
    }

    /**
     * called upon delegating a command to a child node. Is used in subclasses to rewind or fast-forward if needed.
     * @param iterator The iterator that is to be fast-forwarded or rewound.
     */
    protected abstract void traverse(ListIterator<String> iterator);
}
