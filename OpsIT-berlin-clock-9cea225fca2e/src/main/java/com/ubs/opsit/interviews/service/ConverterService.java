package com.ubs.opsit.interviews.service;

import com.ubs.opsit.interviews.model.TimeKeeper;

public interface ConverterService {

    /**
     * Convert input string to TimeKeeper - simple class just keeps
     * hours,minutes and seconds as int and expose them through getters
     * 
     * !!!be careful with format else you'll get DateTimeParseException!!!
     * 
     * @param aTime
     *            HH:MM:SS example 14:36:28 (24 hours formaat)
     * 
     * @return TimeKeeper
     */
    public TimeKeeper convert(String timeString);

}
