package com.ubs.opsit.interviews.service.impl;

import java.time.LocalTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ubs.opsit.interviews.model.TimeKeeper;
import com.ubs.opsit.interviews.service.ConverterService;

public class ConverterServiceImpl implements ConverterService {
    private static final Logger LOG = LoggerFactory.getLogger(ConverterServiceImpl.class);

    @Override
    public TimeKeeper convert(String timeString) {
        LOG.info("timeString = " + timeString);
        
        // The 24:00:00 is not parsed by LocalTime.parse so handle it here
        if ("24:00:00".equals(timeString)) {
            return new TimeKeeper(24, 0, 0);
        }
        
        // Let LocalTime.parse do all job - validate and parse
        LocalTime parsedLocalTime = LocalTime.parse(timeString);
        return new TimeKeeper(parsedLocalTime.getHour(), parsedLocalTime.getMinute(), parsedLocalTime.getSecond());
    }

}
