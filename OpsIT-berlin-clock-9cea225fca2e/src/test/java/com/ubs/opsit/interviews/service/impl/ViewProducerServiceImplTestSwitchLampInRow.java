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
public class ViewProducerServiceImplTestSwitchLampInRow {

    ViewProducerServiceImpl serviceUnderTest = new ViewProducerServiceImpl();
    public StringBuilder row = new StringBuilder();

    @Parameter
    public String inputString;
    @Parameter(1)
    public int onLamp;
    @Parameter(2)
    public char label;
    @Parameter(3)
    public String expectedString;

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { "OOOOOOOOOOO", 2, 'R', "RROOOOOOOOO" },
                { "OOOOOOOOOOO", 0, 'R', "OOOOOOOOOOO" },
                { "OOOOOOOOOOO", -1, 'R', "OOOOOOOOOOO" },
                { "OOOOOO", 55, 'Y', "YYYYYY" },
                { "O", 1, 'Y', "Y" },

        });
    }

    @Test
    public void testSwitchLampInRow() {
        row.setLength(0);
        row.append(inputString);
        serviceUnderTest.switchLampInRow(row, onLamp, label);
        Assert.assertTrue(expectedString.equals(row.toString()));
    }

}
