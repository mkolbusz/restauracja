import com.sun.media.sound.InvalidDataException;
import config.LocalMemoryDataManger;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

/**
 * Created by mkolbusz on 16.06.17.
 */
public class ConfigReaderTest {

    private String path = "config.txt";

    @Test
    public void testLoadConfig() throws Exception {

        PrintWriter writer = new PrintWriter(this.path, "UTF-8");
        writer.println("19:00 20:00");
        writer.println("18:00 19:00");
        writer.close();

        ConfigReader reader = new ConfigReader();
        LocalMemoryDataManger manger = reader.load(path);

        assertEquals(manger.getAllBackets().size(), 2);
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(manger.getAllBackets().get(0).getStartDate());
        assertEquals(19,calendar.get(Calendar.HOUR_OF_DAY));
    }

    @Test(expected = NumberFormatException.class)

    public void testBadFormat() throws Exception {

        PrintWriter writer = new PrintWriter(this.path, "UTF-8");
        writer.println("19:00 20:00");
        writer.println(":00 19:00");
        writer.close();

        ConfigReader reader = new ConfigReader();
        LocalMemoryDataManger manger = reader.load(path);

    }

    @Test(expected = Exception.class)
    public void testBadDateOrder() throws Exception {

        PrintWriter writer = new PrintWriter(this.path, "UTF-8");
        writer.println("19:00 20:00");
        writer.println("21:00 19:00");
        writer.close();

        ConfigReader reader = new ConfigReader();
        LocalMemoryDataManger manger = reader.load(path);


    }

}