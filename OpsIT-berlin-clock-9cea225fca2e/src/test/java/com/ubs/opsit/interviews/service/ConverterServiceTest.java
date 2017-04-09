package com.ubs.opsit.interviews.service;

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
public class ConverterServiceTest {

    ConverterService testService = new ConverterServiceImpl();

    @Parameter
    public String timeString;

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { "00:00:00" },
                { "14:34:27" },
                { "24:00:00" }

        });
    }

    @Test
    public void testConvert() {
        Assert.assertTrue(timeString.equals(
                testService.convert(timeString).toString()));
    }

}
