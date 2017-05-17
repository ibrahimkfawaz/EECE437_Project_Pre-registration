package sample;

import java.io.Serializable;

/**
 * Created by Hasan Fakih on 4/30/2017.
 * a class that represent the time slot of the class
 * it holds the starting time - end time (AM/PM indicator)
 * the duration of the class
 * and an enumerated type Days which could be M T W R F MWF TR MW
 * when a class is proposed it will be assigned a slot
 * and when checking overlapping it would be easy to check start end and in between
 */
public class TimeSlot implements Serializable {
    private Days d;
    private String day;
    private int duration; //in minutes
    private String start;
    private String end;
    private String am_pm;


    public TimeSlot() {
    }

    public TimeSlot(int duration, String start, String end,String am_pm, Days d) {
        this.duration = duration;
        this.start = start;
        this.end = end;
        this.d=d;
        this.am_pm=am_pm;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "TimeSlot{" +
                "d=" + d +
                ", duration=" + duration +
                ", start='" + start + '\'' +
                ", end='" + end + '\'' +
                ", am_pm='" + am_pm + '\'' +
                '}';
    }

    public String getAm_pm() {
        return am_pm;
    }

    public void setAm_pm(String am_pm) {
        this.am_pm = am_pm;
    }

    public Days getD() {
        return d;
    }

    public int getDuration() {
        return duration;
    }

    public String getStart() {
        return start;
    }

    public String getEnd() {
        return end;
    }

    public void setD(Days d) {
        this.d = d;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public void setEnd(String end) {
        this.end = end;
    }
}
