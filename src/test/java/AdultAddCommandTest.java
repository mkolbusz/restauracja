import config.AdultManager;
import config.Bucket;
import config.LocalMemoryDataManger;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.List;

/**
 * Created by damian on 16/06/2017.
 */
public class AdultManagerTest {
    LocalMemoryDataManger dataManager;

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

        AdultManager adultManager = new AdultManager();
        adultManager.saveAdult(dataManager);
        Assert.assertTrue( currentBucket.getAdultNumber()==startAdultCount+1 );
    }
}
