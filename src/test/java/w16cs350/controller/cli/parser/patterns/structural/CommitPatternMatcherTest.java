package w16cs350.controller.cli.parser.patterns.structural;

import org.junit.Test;
import w16cs350.controller.cli.parser.CommandParser;
import w16cs350.controller.cli.parser.ParserFactory;
import w16cs350.controller.command.A_Command;
import w16cs350.controller.command.structural.CommandStructuralCommit;

import static org.junit.Assert.assertTrue;

/**
 * Created by michael on 3/7/16.
 */
public class CommitPatternMatcherTest {
    @Test
    public void commitPatternMatcherTest(){
        CommandParser p = new CommandParser(ParserFactory.buildHelper(), "COMMIT");
        A_Command c = p.parseCommand();
        assertTrue("Commit test fail", c instanceof CommandStructuralCommit);
        CommandStructuralCommit csc = (CommandStructuralCommit) c;
    }
}
