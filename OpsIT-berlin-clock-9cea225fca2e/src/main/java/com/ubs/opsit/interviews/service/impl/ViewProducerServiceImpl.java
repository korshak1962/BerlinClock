package com.ubs.opsit.interviews.service.impl;

import com.ubs.opsit.interviews.model.TimeKeeper;
import com.ubs.opsit.interviews.service.ViewProducerService;
import com.ubs.opsit.interviews.view.BerlinClockVo;

public class ViewProducerServiceImpl implements ViewProducerService {

    @Override
    public void renderView(TimeKeeper timeKeeper, BerlinClockVo berlinClockVo) {
        // Get deal with hours
        int hours = timeKeeper.getHours();
        int onLampFirstHourRow = hours / BerlinClockVo.SCALE_FACTOR;
        switchLampInRow(berlinClockVo.getHoursFirstRow(), onLampFirstHourRow, TURN_ON_RED_LABEL);
        int numLampTurnOnHourSecondRow = hours - onLampFirstHourRow * BerlinClockVo.SCALE_FACTOR;
        switchLampInRow(berlinClockVo.getHoursSecondRow(), numLampTurnOnHourSecondRow, TURN_ON_RED_LABEL);

        // Get deal with minutes
        int minutes = timeKeeper.getMinutes();
        int onLampFirstMinuteRow = minutes / BerlinClockVo.SCALE_FACTOR;
        switchLampInRow(berlinClockVo.getMinutesFirstRow(), onLampFirstMinuteRow, TURN_ON_YELLOW_LABEL);
        changeColorEachNthLampInRow(BerlinClockVo.NTH_OF_RED_IN_FIRST_MINUTE_ROW, berlinClockVo.getMinutesFirstRow(),
                TURN_ON_YELLOW_LABEL, TURN_ON_RED_LABEL);
        int numLampTurnOnMinuteSecondRow = minutes - onLampFirstMinuteRow * BerlinClockVo.SCALE_FACTOR;
        switchLampInRow(berlinClockVo.getMinutesSecondRow(), numLampTurnOnMinuteSecondRow, TURN_ON_YELLOW_LABEL);

        // Get deal with seconds
        int seconds = timeKeeper.getSeconds();
        switchLampInRow(berlinClockVo.getTopRow(), (seconds + 1) % 2, TURN_ON_YELLOW_LABEL);
    }

    /**
     * Turn on numLampTurnOn first lamp in a row with onLabel and turns off
     * other lamps
     * 
     * @param row
     * @param numLampTurnOn
     * @param onLabel
     */
    void switchLampInRow(StringBuilder row, int numLampTurnOn, char onLabel) {
        for (int nLamp = 0; nLamp < row.length(); nLamp++) {
            if (nLamp < numLampTurnOn) {
                row.setCharAt(nLamp, onLabel);
            } else {
                row.setCharAt(nLamp, TURN_OFF_LABEL);
            }
        }
    }

    /**
     * Change color of nth lamp in a row from onLabel to onLabelNew
     * throws IllegalArgumentException if nth < 1
     * @param nth
     * @param row
     * @param onLabel
     * @param onLabelNew
     */
    void changeColorEachNthLampInRow(int nth, StringBuilder row, char onLabel, char onLabelNew) {
        if (nth < 1)
            throw new IllegalArgumentException();
        for (int nLamp = 0; nLamp < row.length(); nLamp++) {
            if ((nLamp + 1) % nth == 0 && row.charAt(nLamp) == onLabel) {
                row.setCharAt(nLamp, onLabelNew);
            }
        }
    }

}
