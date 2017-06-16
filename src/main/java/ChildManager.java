/**
 * Created by damian on 16/06/2017.
 */

import config.BucketManager;
import config.Type;

import java.util.Date;

public class ChildManager {

    public void saveChild(BucketManager bucketManager) {
        bucketManager.add(new Date(), Type.CHILD);
    }
}
