package w16cs350.controller.cli.parser;

import org.junit.Test;

/**
 * Created by Josh on 2/27/2016.
 */
public class MultipleCommandParsingTest {

    @Test
    public void test_PatternMatch() throws Exception {
        CommandParser P = new CommandParser(ParserFactory.buildHelper(), "@RUN C:\\Users\\Josh\\Documents\\GitHub");
        P.parse();
    }
}
