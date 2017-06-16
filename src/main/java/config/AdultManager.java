package config;

import java.util.Date;

/**
 * Created by damian on 16/06/2017.
 */
public class AdultManager {

    public void saveAdult(BucketManager bucketManager) {
        bucketManager.add(new Date(), Type.ADULT);
    }
}
