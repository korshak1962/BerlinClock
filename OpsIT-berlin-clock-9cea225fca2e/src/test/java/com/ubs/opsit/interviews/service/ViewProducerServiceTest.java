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
import com.ubs.opsit.interviews.service.impl.ViewProducerServiceImpl;
import com.ubs.opsit.interviews.view.BerlinClockVo;

@RunWith(Parameterized.class)
public class ViewProducerServiceTest {
    ViewProducerService testService = new ViewProducerServiceImpl();

    @Parameter
    public int hours;
    @Parameter(1)
    public int minutes;
    @Parameter(2)
    public int seconds;
    @Parameter(3)
    public String expectedClock;

    static String expectedFor_0_0_0 = 
              "Y" + System.lineSeparator()
            + "OOOO" + System.lineSeparator()
            + "OOOO" + System.lineSeparator()
            + "OOOOOOOOOOO" + System.lineSeparator()
            + "OOOO";

    static String expectedFor_24_0_0 = 
              "Y" + System.lineSeparator()
            + "RRRR" + System.lineSeparator()
            + "RRRR" + System.lineSeparator()
            + "OOOOOOOOOOO" + System.lineSeparator()
            + "OOOO";

    static String expectedFor_14_34_27 = 
               "O" + System.lineSeparator()
            + "RROO" + System.lineSeparator()
            + "RRRR" + System.lineSeparator()
            + "YYRYYROOOOO" + System.lineSeparator()
            + "YYYY";

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { 0, 0, 0, expectedFor_0_0_0 },
                { 24, 0, 0, expectedFor_24_0_0 },
                { 14, 34, 27, expectedFor_14_34_27 },

        });
    }

    private BerlinClockVo berlinClockVo = new BerlinClockVo();

    @Test
    public void testRenderView() {
        testService.renderView(new TimeKeeper(hours, minutes, seconds), berlinClockVo);
        Assert.assertTrue(expectedClock.equals(berlinClockVo.getAllRows()));
    }

}
