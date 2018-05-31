package wg.cointrends.controllers;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import wg.cointrends.api.domain.CoinCode;
import wg.cointrends.services.HighChartService;

@org.springframework.stereotype.Controller
public class CoinController {

    private final HighChartService chartService;

    public CoinController(HighChartService chartService) {
        this.chartService = chartService;
    }

    @GetMapping("/coin")
    public String getIndexPage(Model model) {

        model.addAttribute("BTCUSD", chartService.prepareDataToChart(CoinCode.BTCUSD));

        return "index";
    }
}
