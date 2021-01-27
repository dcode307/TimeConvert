package de.schulz.exercise.timeformatter.model;

public class Time {
    private String time;
    private String locale;
    private int accuracy;

    public Time() { }

    public Time(String time, String locale, int accuracy) {
        this.time = time;
        this.locale = locale;
        this.accuracy = accuracy;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    @Override
    public String toString() {
        return "Time{" +
                "time='" + time + '\'' +
                ", locale='" + locale + '\'' +
                ", accuracy=" + accuracy +
                '}';
    }
}
