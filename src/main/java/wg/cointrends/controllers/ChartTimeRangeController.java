package wg.cointrends.controllers;


import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import wg.cointrends.chart.ChartValues;
import wg.cointrends.services.DateTimeService;

import javax.validation.Valid;

@Controller
@Log
public class ChartTimeRangeController {

    private final String END_TIME_PATTERN = " 00:00:00";

   @PostMapping("/coin")
    public String getChartTimeRange(@Valid @ModelAttribute("values") ChartValues values, BindingResult result){

        if(!result.hasErrors()){

            String start = values.getStartDate() + END_TIME_PATTERN;
            String end = values.getEndDate() + END_TIME_PATTERN;

            values.setStartMilliseconds(DateTimeService.getMilliseconds(start));
            values.setEndMilliseconds(DateTimeService.getMilliseconds(end));
        }

        return "redirect:/coin";
    }
}
