package w16cs350.controller.cli.parser;

import w16cs350.controller.cli.parser.patterns.A_NonIteratingPatternMatcher;
import w16cs350.controller.cli.parser.patterns.RootPatternMatcher;
import w16cs350.controller.command.A_Command;

import java.util.Arrays;
import java.util.ListIterator;
import java.util.stream.Collectors;

/**
 * Created by johnrowleyster on 2/23/16.
 */

/**
 * Parses commands, and executes the related commands.
 */
public class CommandParser extends A_NonIteratingPatternMatcher {
    private A_ParserHelper helper;
    private String line;

    public CommandParser(A_ParserHelper helper, String line) {
        super(null);

        this.helper = helper;
        this.line = line;
    }

    /**
     * Returns a ListIterator containing Strings from a String delimited by spaces.
     * @param string The command being split.
     * @return A ListIterator containing the string delimited by spaces.
     */
    public static ListIterator<String> getIteratorFromString(String string) {
        String[] tokens = string.split(" ");
        return Arrays.stream(tokens).collect(Collectors.toList()).listIterator();
    }

    /**
     * Returns the variables store used to keep track of all C DEFINE like operations
     * @return The variable store
     */
    public A_ParserHelper getHelper() {
        return helper;
    }

    /**
     * Parses the line of text and schedules it for execution via the action processor.
     */
    public void parse() {
        helper.getActionProcessor().schedule(parseCommand());
    }

    /**
     * Parses the command, and returns the constructed command.
     * @return The constructed command.
     */
    public A_Command parseCommand() {
        return parse(getIteratorFromString(line));
    }

    @Override
    protected void initializeMatchers() {
        getPatternMatchers().add(new RootPatternMatcher(this));
    }

    @Override
    public A_ParserHelper getParserHelper(){
        return helper;
    }
}
