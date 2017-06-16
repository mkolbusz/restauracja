package config;

import java.util.Date;

/**
 * Created by mkolbusz on 16.06.17.
 */
public interface BucketManager {
    void add(Date date, Type type);
}
