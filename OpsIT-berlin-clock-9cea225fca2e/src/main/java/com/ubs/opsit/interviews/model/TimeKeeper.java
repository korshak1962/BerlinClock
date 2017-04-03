package com.ubs.opsit.interviews.model;

public class TimeKeeper {

    private int hours;
    private int minutes;
    private int seconds;

    public TimeKeeper(int hours, int minuts, int seconds) {
        this.hours = hours;
        this.minutes = minuts;
        this.seconds = seconds;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    @Override
    public String toString() {
        return String.format("%02d", hours) + ":" + String.format("%02d", minutes) + ":" + String.format("%02d", seconds);
    }

}
