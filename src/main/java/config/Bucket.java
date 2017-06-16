package config;

import java.util.Date;

/**
 * Created by mkolbusz on 16.06.17.
 */
public class Bucket {
    private Date date;
    private int adultNumber;
    private int childNumber;

    public Bucket(Date date, int adultNumber, int childNumber) {
        this.date = date;
        this.adultNumber = adultNumber;
        this.childNumber = childNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getAdultNumber() {
        return adultNumber;
    }

    public void setAdultNumber(int adultNumber) {
        this.adultNumber = adultNumber;
    }

    public int getChildNumber() {
        return childNumber;
    }

    public void setChildNumber(int childNumber) {
        this.childNumber = childNumber;
    }
}
