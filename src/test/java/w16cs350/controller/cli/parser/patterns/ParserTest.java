package w16cs350.controller.cli.parser.patterns;

import org.junit.Test;
import w16cs350.controller.cli.parser.CommandParser;
import w16cs350.controller.cli.parser.ParserFactory;

/**
 * Created by RowleyJohn on 2/25/2016.
 */
public class ParserTest {
    @Test(expected = Exception.class)
    public void testNodeNotFound(){
        CommandParser parser = new CommandParser(ParserFactory.buildHelper(), "FOO BAR IS COOL");
        parser.parseCommand();
    }

    @Test(expected = Exception.class)
    public void testParseCommand(){
        CommandParser parser = new CommandParser(ParserFactory.buildHelper(), "FOO BAR IS COOL");
        parser.parseCommand(CommandParser.getIteratorFromString(""));

    }
}
