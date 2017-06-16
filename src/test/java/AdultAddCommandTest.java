import org.junit.Before;
import pl.edu.agh.AdultAddCommand;
import config.Bucket;
import config.LocalMemoryDataManger;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.List;

/**
 * Created by damian on 16/06/2017.
 */
public class AdultAddCommandTest {

    LocalMemoryDataManger dataManager;

    @Before
    public void before() {
        dataManager = new LocalMemoryDataManger();
        dataManager.getAllBackets().add(new Bucket(new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis() + 5 * 1000 * 60), 0, 0));
    }

    @Test
    public void testAddingAdult() {
        Date currentTime = new Date();
        List<Bucket> bucketList = dataManager.getAllBackets();
        Bucket currentBucket = null;
        for( Bucket bucket : bucketList ) {
            if( currentTime.getTime() >= bucket.getStartDate().getTime()
                    && currentTime.getTime() <= bucket.getStopDate().getTime() ) {
                currentBucket = bucket;
                break;
            }
        }
        Assert.assertNotNull(currentBucket);
        int startAdultCount = currentBucket.getAdultNumber();

        AdultAddCommand adultAddCommand = new AdultAddCommand(dataManager);
        adultAddCommand.execute();
        Assert.assertTrue( currentBucket.getAdultNumber()==startAdultCount+1 );
    }
}
