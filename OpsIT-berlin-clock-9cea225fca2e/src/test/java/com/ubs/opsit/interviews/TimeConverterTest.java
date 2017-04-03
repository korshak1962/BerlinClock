package com.ubs.opsit.interviews;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TimeConverterTest {
    TimeConverter testService = new TimeConverterImpl();

    @Parameter
    public String timeString;
    @Parameter(1)
    public String expectedClock;

    static String expectedFor_0_0_0 = 
              "Y" + System.lineSeparator()
            + "OOOO" + System.lineSeparator()
            + "OOOO" + System.lineSeparator()
            + "OOOOOOOOOOO" + System.lineSeparator()
            + "OOOO";

    static String expectedFor_13_17_01 = 
              "O" + System.lineSeparator()
            + "RROO" + System.lineSeparator()
            + "RRRO" + System.lineSeparator()
            + "YYROOOOOOOO" + System.lineSeparator()
            + "YYOO";
    
    static String expectedFor_14_56_00 = 
            "Y" + System.lineSeparator()
          + "RROO" + System.lineSeparator()
          + "RRRR" + System.lineSeparator()
          + "YYRYYRYYRYY" + System.lineSeparator()
          + "YOOO";

    static String expectedFor_23_59_59 = 
               "O" + System.lineSeparator()
            + "RRRR" + System.lineSeparator()
            + "RRRO" + System.lineSeparator()
            + "YYRYYRYYRYY" + System.lineSeparator()
            + "YYYY";

    static String expectedFor_24_0_0 = 
              "Y" + System.lineSeparator()
            + "RRRR" + System.lineSeparator()
            + "RRRR" + System.lineSeparator()
            + "OOOOOOOOOOO" + System.lineSeparator()
            + "OOOO";

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { "00:00:00", expectedFor_0_0_0 },
                { "13:17:01", expectedFor_13_17_01 },
                { "24:00:00", expectedFor_24_0_0 },
                { "14:56:00",expectedFor_14_56_00}

        });
    }

    @Test
    public void testTimeConverter() {
        Assert.assertTrue(expectedClock.equals(
                testService.convertTime(timeString)));
    }

}
