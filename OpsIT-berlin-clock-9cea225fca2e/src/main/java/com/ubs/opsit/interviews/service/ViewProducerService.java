package com.ubs.opsit.interviews.service;

import com.ubs.opsit.interviews.model.TimeKeeper;
import com.ubs.opsit.interviews.view.BerlinClockVo;

public interface ViewProducerService {
    char TURN_OFF_LABEL = 'O';
    char TURN_ON_RED_LABEL = 'R';
    char TURN_ON_YELLOW_LABEL = 'Y';

    /**
     * fill in berlinClockVo with proper value in each row of lamp
     * from timeKeeper time
     * @param timeKeeper
     * @param berlinClockVo
     */
    void renderView(TimeKeeper timeKeeper, BerlinClockVo berlinClockVo);

}
