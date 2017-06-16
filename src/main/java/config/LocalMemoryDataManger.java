package config;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by mkolbusz on 16.06.17.
 */
public class LocalMemoryDataManger implements RaportManager, BucketManager {
    private List<Bucket> allBuckets = new ArrayList<Bucket>();


    public void add(Date date, Type type) {
        for(Bucket bucket : allBuckets) {
            bucket.add(date, type);
        }
    }

    public List<Bucket> getAllBackets() {
        return allBuckets;
    }

    public void clearAllBackets() {
        for (Bucket bucket : allBuckets) {
            bucket.clearAll();
        }
    }
}
