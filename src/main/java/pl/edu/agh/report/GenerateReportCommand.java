package pl.edu.agh.report;

import config.Bucket;
import config.RaportManager;
import pl.edu.agh.Command;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class GenerateReportCommand implements Command {
    private RaportManager reportManager;
    private File dir;

    public GenerateReportCommand(RaportManager reportManager, File dir) {
        this.reportManager = reportManager;
    }

    public boolean canExecute(String input) {
        return "r".equals(input);
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
            writer = new FileWriter(new File(dir, "report_" + generationDate + ".txt"));
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
        return reportManager.getAllBackets();
    }
}
