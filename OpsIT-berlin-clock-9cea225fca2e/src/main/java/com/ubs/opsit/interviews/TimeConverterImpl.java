package com.ubs.opsit.interviews;

import com.ubs.opsit.interviews.model.TimeKeeper;
import com.ubs.opsit.interviews.service.ConverterService;
import com.ubs.opsit.interviews.service.ViewProducerService;
import com.ubs.opsit.interviews.service.impl.ConverterServiceImpl;
import com.ubs.opsit.interviews.service.impl.ViewProducerServiceImpl;
import com.ubs.opsit.interviews.view.BerlinClockVo;

public class TimeConverterImpl implements TimeConverter {

    ConverterService vonverterService = new ConverterServiceImpl();
    ViewProducerService ViewProducerService = new ViewProducerServiceImpl();

    @Override
    public String convertTime(String aTime) {
        TimeKeeper timeKeeper = vonverterService.convert(aTime);
        BerlinClockVo berlinClockVo = new BerlinClockVo();
        ViewProducerService.renderView(timeKeeper, berlinClockVo);
        return berlinClockVo.getAllRows();
    }

}
