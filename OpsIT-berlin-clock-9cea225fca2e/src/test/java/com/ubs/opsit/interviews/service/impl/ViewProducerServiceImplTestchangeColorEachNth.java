package com.ubs.opsit.interviews.service.impl;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ViewProducerServiceImplTestchangeColorEachNth {

    ViewProducerServiceImpl serviceUnderTest = new ViewProducerServiceImpl();
    public StringBuilder row = new StringBuilder();

    @Parameter
    public String inputString;
    @Parameter(1)
    public int nth;
    @Parameter(2)
    public char onLabel;
    @Parameter(3)
    public char onLabelNew;
    @Parameter(4)
    public String expectedString;

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { "OOOOOOOOOOO", 2, 'Y', 'R', "OOOOOOOOOOO" },
                { "YYOOOOOOOOO", 2, 'Y', 'R', "YROOOOOOOOO" },
                { "YYYYYYYYYYY", 6, 'Y', 'R', "YYYYYRYYYYY" },
                { "YYYYYYYYYYY", 1, 'Y', 'R', "RRRRRRRRRRR" },
                { "YYYY", 4, 'Y', 'R', "YYYR" },
                { "RRRR", 4, 'R', 'Y', "RRRY" },
                { "RRRR", 24, 'R', 'Y', "RRRR" },

        });
    }

    @Test
    public void testSwitchLampInRow() {
        row.setLength(0);
        row.append(inputString);
        serviceUnderTest.changeColorEachNthLampInRow(nth, row, onLabel, onLabelNew);
        Assert.assertTrue(expectedString.equals(row.toString()));

    }

    @Test(expected = IllegalArgumentException.class)
    public void testExcepion() {
        serviceUnderTest.changeColorEachNthLampInRow(-1, row, onLabel, onLabelNew);
    }

}