package w16cs350.controller.cli.parser.patterns.creational.track;

import w16cs350.controller.cli.parser.PrimitiveDeserializer;
import w16cs350.controller.cli.parser.patterns.A_IteratingPatternMatcher;
import w16cs350.controller.cli.parser.patterns.A_PatternMatcher;
import w16cs350.controller.command.A_Command;
import w16cs350.controller.command.creational.CommandCreateTrackLayout;
import w16cs350.support.Assert;

import java.util.List;
import java.util.ListIterator;

/**
 * Created by michael on 2/26/16.
 */
public class TrackLayoutPatternMatcher extends A_IteratingPatternMatcher{
    public TrackLayoutPatternMatcher(A_PatternMatcher parent) {
        super(parent);
    }

    @Override
    protected boolean isMatch(ListIterator<String> tok) {
        String token = tok.next();
        tok.previous();
        return token.equals("LAYOUT");
    }

    @Override
    protected void initializeMatchers() {
        throw new UnsupportedOperationException();
    }

    @Override
    protected A_Command parseCommand(ListIterator<String> tokens) {
        String idToken = tokens.next();

        String withToken = tokens.next();
        Assert.isTrue(withToken.equals("WITH"), "Incorrect input, expected: WITH");

        String tracksToken = tokens.next();
        Assert.isTrue(tracksToken.equals("TRACKS"), "Incorrect input, expected: TRACKS");

        List<String> idList = PrimitiveDeserializer.parserIDList(tokens);
        return new CommandCreateTrackLayout(idToken, idList);
    }

    @Override
    protected boolean isLeaf() {
        return true;
    }
}
