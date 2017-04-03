package com.ubs.opsit.interviews.view;

public class BerlinClockVo {

    public static final int SCALE_FACTOR = 5;
    public static final int NTH_OF_RED_IN_FIRST_MINUTE_ROW = 3;
    
    private StringBuilder topRow = new StringBuilder("O");
    private StringBuilder hoursFirstRow = new StringBuilder("OOOO");
    private StringBuilder hoursSecondRow = new StringBuilder("OOOO");
    private StringBuilder minutesFirstRow = new StringBuilder("OOOOOOOOOOO");
    private StringBuilder minutesSecondRow = new StringBuilder("OOOO");
    private StringBuilder allRow = new StringBuilder();

    public StringBuilder getTopRow() {
        return topRow;
    }

    public StringBuilder getHoursFirstRow() {
        return hoursFirstRow;
    }

    public StringBuilder getHoursSecondRow() {
        return hoursSecondRow;
    }

    public StringBuilder getMinutesFirstRow() {
        return minutesFirstRow;
    }

    public StringBuilder getMinutesSecondRow() {
        return minutesSecondRow;
    }

    public String getAllRows() {
        allRow.setLength(0);
        return allRow.append(topRow).append(System.lineSeparator())
                .append(hoursFirstRow).append(System.lineSeparator())
                .append(hoursSecondRow).append(System.lineSeparator())
                .append(minutesFirstRow).append(System.lineSeparator())
                .append(minutesSecondRow)
                .toString();
    }
}
