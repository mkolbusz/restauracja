package report;

import config.Bucket;
import pl.edu.agh.Command;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class GenerateReportCommand implements Command {
    public String getKey() {
        return "r";
    }

    public boolean execute() {
        ReportGenerator reportGenerator = new ReportGenerator();
        Date generationDate = new Date(System.currentTimeMillis());
        String report = reportGenerator.generateReport(getBucketList(), generationDate);
        System.out.println(report);
        writeReportFile(generationDate, report);
        return true;
    }

    private void writeReportFile(Date generationDate, String report) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(new File("report_" + generationDate + ".txt"));
            writer.write(report);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private List<Bucket> getBucketList() {
        return Collections.emptyList();
    }
}
