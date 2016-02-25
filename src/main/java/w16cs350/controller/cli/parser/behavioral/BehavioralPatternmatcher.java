package w16cs350.controller.cli.parser.behavioral;

import w16cs350.controller.cli.parser.patterns.A_PatternMatcher;
import w16cs350.controller.command.A_Command;

import java.util.List;
import java.util.ListIterator;


public class BehavioralPatternmatcher extends A_PatternMatcher {

    public BehavioralPatternmatcher(A_PatternMatcher parent) {
        super(parent);
    }

    @Override
    protected boolean isMatch(ListIterator<String> tokens) {
        return !tokens.hasNext() && tokens.next().equals("Behavioral");
    }

    @Override
    public A_PatternMatcher getParent() {
        return super.getParent();
    }

    @Override
    public A_PatternMatcher getRoot() {
        return super.getRoot();
    }

    @Override
    protected void traverse(ListIterator<String> iterator) {

    }

    @Override
    public A_Command parse(ListIterator<String> iterator) {
        return super.parse(iterator);
    }

    @Override
    protected boolean isLeaf() {
        return false;
    }

    @Override
    protected A_Command parseCommand(ListIterator<String> tokens) {
        return null;
    }

    @Override
    protected void initializeMatchers() {
        getPatternMatchers().add(new BrakePatternMatcher(this));
    }

    @Override
    public List<A_PatternMatcher> getPatternMatchers() {
        return super.getPatternMatchers();
    }


}
