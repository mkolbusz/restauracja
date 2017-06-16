import config.Bucket;
import config.LocalMemoryDataManger;
import config.RaportManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

/**
 * Created by Krzysztof on 16.06.2017.
 */
public class BucketClearTest {

    RaportManager dataManager;

    @Before
    public void before() {
        dataManager = new LocalMemoryDataManger();
        dataManager.getAllBackets().add(new Bucket(new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis() + 5 * 1000 * 60), 0, 0));
    }

    @Test
    public void shouldClearBuckets() {
        for (Bucket bucket : dataManager.getAllBackets()) {
            bucket.setAdultNumber(5);
            bucket.setChildNumber(4);
        }

        // when
        dataManager.clearAllBackets();

        // then
        for (Bucket bucket : dataManager.getAllBackets()) {
            int adultNumber = bucket.getAdultNumber();
            int childNumber = bucket.getChildNumber();

            Assert.assertEquals(0, adultNumber);
            Assert.assertEquals(0, childNumber);
        }
    }
}
