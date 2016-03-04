package w16cs350.controller.cli.parser;

import w16cs350.controller.ActionProcessor;
import w16cs350.controller.Controller;
import w16cs350.controller.cli.CommandLineInterface;

/**
 * Created by johnrowleyster on 2/24/16.
 */

public class ParserFactory {
    public static MyParserHelper buildHelper(){
        return new MyParserHelper(new ActionProcessor(new CommandLineInterface(new Controller())));
    }
}
