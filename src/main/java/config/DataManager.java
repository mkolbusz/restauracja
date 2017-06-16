package config;

import java.util.Date;

/**
 * Created by mkolbusz on 16.06.17.
 */
interface DataManager {
    void add(Date date, Type type);
}
