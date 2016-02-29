package w16cs350.controller.cli.parser.patterns;

import org.junit.Test;
import w16cs350.controller.cli.parser.CommandParser;
import w16cs350.controller.cli.parser.ParserFactory;

/**
 * Created by Josh on 2/27/2016.
 */
public class CommandsSchedule_TEST {

    @Test
    public void test_PatternMatch() throws Exception {
        CommandParser P = new CommandParser(ParserFactory.buildHelper(), "DO SELECT DRAWBRIDGE testID1 POSITION DOWN ;" +
                "DO SELECT ROUNDHOUSE TestID2 POSITION 212 CLOCKWISE ;" +
                "DO SELECT SWITCH testID3 PATH PRIMARY");

    }
}
