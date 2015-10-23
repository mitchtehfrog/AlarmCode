package edu.elon.cs.gamealarm;

/**
 * Created by Michael on 10/22/2015.
 */
public class Alarm {

    private int day;
    private int hours;
    private int minutes;
    private boolean am;
    private boolean on;

    public Alarm (int day, int hours, int minutes, boolean am) {
        this.day = day;
        this.hours = hours;
        this.minutes = minutes;
        this.am = am;
        on = true;
    }

    public int getDay () {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getHours () {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getMinutes () {
        return minutes;
    }

    public void setMinutes (int minutes) {
        this.minutes = minutes;
    }

    public boolean isAm () {
        return am;
    }

    public void setAm(boolean am) {
        this.am = am;
    }

    public boolean isOn () {
        return on;
    }

    public void setOn (boolean on){
        this.on = on;
    }

    @Override
    public String toString() {
        String alarm = hours + ":";

        if (minutes < 10){
            alarm += "0";
        }

        alarm += minutes + " ";

        if (am){
            alarm += "am";
        }
        else{
            alarm += "PM";
        }

        return alarm;
    }
}
