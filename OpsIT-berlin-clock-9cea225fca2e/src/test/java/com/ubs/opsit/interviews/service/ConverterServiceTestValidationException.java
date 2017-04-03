package com.ubs.opsit.interviews.service;

import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import com.ubs.opsit.interviews.model.TimeKeeper;
import com.ubs.opsit.interviews.service.impl.ConverterServiceImpl;

@RunWith(Parameterized.class)
public class ConverterServiceTestValidationException {

    ConverterService testService = new ConverterServiceImpl();

    @Parameter
    public String timeString;

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { "30:00:00" },
                { "14-4:27" },
                { "14-4a:27" },
                { "" }

        });
    }
    
    @Test(expected = DateTimeParseException.class)
    public void testConvert() {
        testService.convert(timeString);
    }

    
}
