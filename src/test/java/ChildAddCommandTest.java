import config.Bucket;
import config.LocalMemoryDataManger;
import org.junit.Test;
import org.junit.Assert;

import java.util.Date;
import java.util.List;

/**
 * Created by damian on 16/06/2017.
 */
public class ChildManagerTest {

    LocalMemoryDataManger dataManager;

    @Test
    public void testAddingChild() {
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
        int startChildCount = currentBucket.getChildNumber();

        ChildManager childManager = new ChildManager();
        childManager.saveChild(dataManager);
        Assert.assertTrue( currentBucket.getChildNumber()==startChildCount+1 );
    }
}
