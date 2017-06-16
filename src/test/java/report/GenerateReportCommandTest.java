package report;

import config.Bucket;
import config.RaportManager;
import org.junit.After;
import org.junit.Test;

import pl.edu.agh.report.GenerateReportCommand;

import java.io.File;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class GenerateReportCommandTest {
    private File reportsTestDir = new File("reportsTestDir");

    @Test
    public void canExecute() throws Exception {
        GenerateReportCommand command = new GenerateReportCommand(getReportManager(), reportsTestDir);
        assertTrue(command.canExecute("r"));
    }

    @Test
    public void execute() throws Exception {
        GenerateReportCommand command = new GenerateReportCommand(getReportManager(), reportsTestDir);
        assertTrue(command.execute());
    }

    @After
    public void deleteFiles() {
        File[] files = reportsTestDir.listFiles();
        if (files != null) {
            for (File file : files) {
                file.delete();
            }
        }
        reportsTestDir.delete();
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