package report;

import config.Bucket;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ReportGeneratorTest {
    @Test
    public void ratortTest() {
        List<Bucket> bucketList = new ArrayList<Bucket>();
        int adultNumer = 19;
        int childNumber = 6;
        Date startDate = new Date(1234567832);
        Date endDate = new Date(1984567832);
        bucketList.add(new Bucket(startDate,endDate, adultNumer, childNumber));
        RaportGenerator reportGenerator = new RaportGenerator();
        Date generateDate = new Date(1232132132);
        String expectedRaport = generateDate.toString() + " Generated Report:\n" + startDate.toString() + " to " + endDate.toString() + ":\n" + "Adults: " + adultNumer
                + " Children:" + childNumber + "\n";
        assertEquals(expectedRaport,reportGenerator.generateRaport(bucketList,generateDate));
    }
}
