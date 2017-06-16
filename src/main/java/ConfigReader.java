import com.sun.media.sound.InvalidDataException;
import config.Bucket;
import config.LocalMemoryDataManger;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by mkolbusz on 16.06.17.
 */
public class ConfigReader {
    public LocalMemoryDataManger load(String path) throws Exception {
        LocalMemoryDataManger manger = new LocalMemoryDataManger();
        try {
            File file = new File(path);
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] hours = line.split(" ");

                if(hours.length != 2) {
                    throw new InvalidDataException("Bad hour");
                }

                Date startDate = this.readDate(hours[0]);
                Date stopDate = this.readDate(hours[1]);

                if(startDate.after(stopDate)) {
                    throw new Exception();
                }

                manger.getAllBackets().add(new Bucket(startDate, stopDate, 0, 0));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return manger;
    }


    public Date readDate(String hour) throws InvalidDataException {
        Date startDate = new Date();
        String[] h = hour.split(":");

        if(h.length != 2) {
            throw new InvalidDataException("Bad time item");
        }

        startDate.setHours(Integer.parseInt(h[0]));
        startDate.setMinutes(Integer.parseInt(h[1]));

        return startDate;
    }
}
