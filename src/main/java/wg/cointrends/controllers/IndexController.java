package wg.cointrends.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import wg.cointrends.api.domain.CoinCode;
import wg.cointrends.chart.ChartValues;
import wg.cointrends.services.HighChartService;

import java.time.LocalDate;

@Controller
public class IndexController {

    private final HighChartService chartService;

    public IndexController(HighChartService chartService) {
        this.chartService = chartService;
    }

    @GetMapping("/coin")
    public String getIndexPage(Model model) {

        ChartValues values = new ChartValues();

        model.addAttribute("values", values);
        model.addAttribute("max", LocalDate.now());
        model.addAttribute("min", LocalDate.of(2010, 7, 16));

        model.addAttribute("BTCUSD", chartService.prepareDataToChart(CoinCode.BTCUSD));
        model.addAttribute("ETHUSD", chartService.prepareDataToChart(CoinCode.ETHUSD));
        model.addAttribute("LTCUSD", chartService.prepareDataToChart(CoinCode.LTCUSD));

        return "index";
    }
}
