package com.ubs.opsit.interviews;

public interface TimeConverter {

    /**
     * Convert input string to string represents  Berlin clock
     * !!!be careful with format else you'll get DateTimeParseException!!!
     * 
     * @param aTime HH:MM:SS example 14:36:28 (24 hours formaat)
     * 
     * @return string represents Berlin clock
     */
    String convertTime(String aTime);

}
