package w16cs350.controller.cli.parser;

import org.junit.Test;

/**
 * Created by Josh on 2/27/2016.
 */
public class MultipleCommandParsing_TEST {

    @Test
    public void test_PatternMatch() throws Exception {
        CommandParser P = new CommandParser(ParserFactory.buildHelper(), "DO SELECT DRAWBRIDGE testID1 POSITION DOWN ;" +
                "DO SELECT ROUNDHOUSE TestID2 POSITION 212 CLOCKWISE ;" +
                "DO SELECT SWITCH testID3 PATH PRIMARY");

    }
}
