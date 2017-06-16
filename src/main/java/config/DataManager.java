package config;

import java.util.Date;
import java.util.List;

/**
 * Created by mkolbusz on 16.06.17.
 */
interface DataManager {
    void add(Date date, Type type);
    List<Bucket> getAllBackets();
}
