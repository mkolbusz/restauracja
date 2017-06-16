package config;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by mkolbusz on 16.06.17.
 */
public class BucketTest {

    @Test
    public void addIfContains() throws Exception {
        SimpleDateFormat dt = new SimpleDateFormat("hh:mm:ss");

        Bucket bucket = new Bucket(dt.parse("19:00:00"), dt.parse("20:00:00"), 0,0);
        bucket.add(dt.parse("19:15:00"), Type.CHILD);
        assertEquals(1, bucket.getChildNumber());
    }

    @Test
    public void addIfNotContains() throws Exception {
        SimpleDateFormat dt = new SimpleDateFormat("hh:mm:ss");

        Bucket bucket = new Bucket(dt.parse("19:00:00"), dt.parse("20:00:00"), 0,0);
        bucket.add(dt.parse("20:15:00"), Type.CHILD);
        assertEquals(0, bucket.getChildNumber());
    }

}