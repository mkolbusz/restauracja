package config;

import java.util.Date;

/**
 * Created by mkolbusz on 16.06.17.
 */
public class Bucket {
    private Date startDate;
    private Date stopDate;
    private int adultNumber;
    private int childNumber;

    public Bucket(Date startDate, Date stopDate, int adultNumber, int childNumber) {
        this.startDate = startDate;
        this.stopDate = stopDate;
        this.adultNumber = adultNumber;
        this.childNumber = childNumber;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getStopDate() {
        return stopDate;
    }

    public void setStopDate(Date stopDate) {
        this.stopDate = stopDate;
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

    public void add(Date date, Type type) {

        if(date.after(startDate) && date.before(stopDate)) {
            if(type == Type.CHILD) {
                this.childNumber++;
            }else {
                this.adultNumber++;
            }

        }
    }

    public void clearAdults() {
        setAdultNumber(0);
    }

    public void clearChilds() {
        setChildNumber(0);
    }

    public void clearAll() {
        clearAdults();
        clearChilds();
    }
}
