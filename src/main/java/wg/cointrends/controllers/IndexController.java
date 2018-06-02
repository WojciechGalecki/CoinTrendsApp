package wg.cointrends.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import wg.cointrends.api.domain.CoinCode;
import wg.cointrends.chart.ChartValues;
import wg.cointrends.services.ChartTimeRangeService;
import wg.cointrends.services.DateTimeService;
import wg.cointrends.services.HighChartService;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Controller
public class IndexController {

    private final HighChartService chartService;
    private final ChartTimeRangeService rangeService;

    private final String END_TIME_PATTERN = " 00:00:00";
    private Long startRange;
    private Long endRange;

    public IndexController(HighChartService chartService, ChartTimeRangeService rangeService) {
        this.chartService = chartService;
        this.rangeService = rangeService;
    }

    @GetMapping("/coin")
    public String getIndexPage(Model model) {

        model.addAttribute("values", new ChartValues());
        model.addAttribute("max", LocalDate.now());
        model.addAttribute("min", LocalDate.of(2010, 7, 16));

        List<Object[]> chartDataBTCUSD = chartService.prepareDataToChart(CoinCode.BTCUSD);
        List<Object[]> chartDataETHUSD = chartService.prepareDataToChart(CoinCode.ETHUSD);
        List<Object[]> chartDataLTCUSD = chartService.prepareDataToChart(CoinCode.LTCUSD);


        if (startRange != null && endRange != null) {
            model.addAttribute("BTCUSD", rangeService.changeTimeRange(chartDataBTCUSD, startRange, endRange));
            model.addAttribute("ETHUSD", rangeService.changeTimeRange(chartDataETHUSD, startRange, endRange));
            model.addAttribute("LTCUSD", rangeService.changeTimeRange(chartDataLTCUSD, startRange, endRange));
        } else {
            model.addAttribute("BTCUSD", chartDataBTCUSD);
            model.addAttribute("ETHUSD", chartDataETHUSD);
            model.addAttribute("LTCUSD", chartDataLTCUSD);
        }

        return "index";
    }

    @PostMapping("/coin")
    public String getChartTimeRange(@Valid @ModelAttribute("values") ChartValues values, BindingResult result) {

        if (!result.hasErrors()) {

            String start = values.getStartDate() + END_TIME_PATTERN;
            String end = values.getEndDate() + END_TIME_PATTERN;

            startRange = DateTimeService.getMilliseconds(start);
            endRange = DateTimeService.getMilliseconds(end);
        }

        return "redirect:/coin";
    }
}
