package w16cs350.controller.cli.parser;

import w16cs350.controller.ActionProcessor;
import w16cs350.controller.Controller;
import w16cs350.controller.cli.CommandLineInterface;
import w16cs350.controller.cli.parser.patterns.A_NonIteratingPatternMatcher;
import w16cs350.controller.command.A_Command;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Iterator class that builds and iterates over multiple commands
 * from an input string delimited by ';'
 *
 * @author Josh Cotes
 * @version 1.0
 */
public class CommandsIterator extends A_NonIteratingPatternMatcher implements Iterator<A_Command> {

    private List<A_Command> _commands;
    private String _line;
    private A_ParserHelper _parserHelper;
    private int _position;

    /**
     * Constructor initializes the iterator dependencies
     *
     * @param line - The command line input
     */
    public CommandsIterator(String line) {
        super(null);
        this._line = line;
        initializeSessionParserHelper();
        buildList();
        _position = 0;
    }

    /**
     * Builds the list of A_Commands by splitting and extracting
     * each A_Command from the split tokens
     */
    public void buildList() {
        _commands =
                Arrays.stream(_line.split(";"))
                        .collect(Collectors.toList())
                        .stream() // list of token iterators
                        .map(this::extractCommand)
                        .collect(Collectors.toList());
    }

    /**
     * Gets a command from the current
     *
     * @param splitLine - Post split single line
     * @return -- The A_Command extracted from the line
     */
    private A_Command extractCommand(String splitLine) {
        return new CommandParser(_parserHelper, splitLine).parseCommand();
    }

    @Override
    public boolean hasNext() {
        return _position < _commands.size();
    }

    @Override
    protected void initializeMatchers() {
    }

    /**
     * Parser helper stays constant for all parsing operations,
     * CommandParser is created new for each pattern
     */
    private void initializeSessionParserHelper() {
        _parserHelper = new MyParserHelper(
                new ActionProcessor(
                        new CommandLineInterface(
                                new Controller())));
    }

    @Override
    public A_Command next() {
        if (!hasNext())
            throw new NullPointerException("no next element");
        return _commands.get(_position++);
    }

    /**
     * Get the count of remaining iterator elements
     *
     * @return --- The count of remaining iterator elements
     */
    public int remaining() {
        return _commands.size() - _position;
    }
}
