package report;

import config.Bucket;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class GenerateReportCommandTest {
    @Test
    public void getKey() throws Exception {
        GenerateReportCommand command = new GenerateReportCommand();
        assertEquals("r",command.getKey());
    }

    @Test
    public void execute() throws Exception {
        GenerateReportCommand command = new GenerateReportCommand();
        assertTrue(command.execute());
    }

}