package wg.cointrends.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import wg.cointrends.services.ApiService;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {

    private ApiService apiService;

    public Controller(ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping("/coin")
    public String test(Model model){

        List<Double> avgs = new LinkedList<>();
        List<String> data = new LinkedList<>();

        apiService.getBtcUsd().stream().iterator().forEachRemaining(avg -> {
                    avgs.add(avg.getAverage());
                    data.add(avg.getTime());
        });

        model.addAttribute("avg", Arrays.asList(avgs));
        model.addAttribute("data", Arrays.asList(data));



        return "index";
    }
}
