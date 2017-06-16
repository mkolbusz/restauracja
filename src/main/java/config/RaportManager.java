package config;

import java.util.List;

/**
 * Created by mkolbusz on 16.06.17.
 */
public interface RaportManager {
    List<Bucket> getAllBackets();
    void clearAllBackets();
}
