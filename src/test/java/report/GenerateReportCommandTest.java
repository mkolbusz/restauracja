package java.report;

import config.Bucket;
import config.RaportManager;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class GenerateReportCommandTest {
    @Test
    public void canExecute() throws Exception {
        GenerateReportCommand command = new GenerateReportCommand(getReportManager());
        assertTrue(command.canExecute("r"));
    }

    @Test
    public void execute() throws Exception {
        GenerateReportCommand command = new GenerateReportCommand(getReportManager());
        assertTrue(command.execute());
    }

    private static RaportManager getReportManager() {
        return new RaportManager() {
            public List<Bucket> getAllBackets() {
                return Collections.emptyList();
            }

            public void clearAllBackets() {}
        };
    }
}