package w16cs350.controller.cli.parser.patterns.meta;

import org.junit.Test;
import w16cs350.controller.cli.parser.CommandParser;
import w16cs350.controller.cli.parser.ParserFactory;
import w16cs350.controller.command.A_Command;
import w16cs350.controller.command.meta.CommandMetaDoSchedule;
import w16cs350.controller.command.meta.CommandMetaViewDestroy;

import static junit.framework.Assert.assertTrue;

/**
 * Created by RowleyJohn on 2/25/2016.
 */
public class SchedulePatternMatcherTest {
    @Test
    public void test(){
        CommandParser p = new CommandParser(ParserFactory.buildHelper(), "@SCHEDULE AT 100.00 CLOSE VIEW FOO");
        A_Command c = p.parseCommand();
        assertTrue("Returned command not Schedule", c instanceof CommandMetaDoSchedule);
        CommandMetaDoSchedule command = (CommandMetaDoSchedule)c;
        assertTrue("Scheduled command not CommandMetaViewDestroy", command.getCommand() instanceof CommandMetaViewDestroy);
        assertTrue("Scheduled command has invalid parameter", ((CommandMetaViewDestroy) command.getCommand()).getID().equals("FOO"));
    }

}