package wg.cointrends.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import wg.cointrends.services.ApiService;

@org.springframework.stereotype.Controller
public class Controller {

    private ApiService apiService;

    public Controller(ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping("/home")
    public String test(Model model){

        model.addAttribute("list", apiService.getBtcUsd());
        return "test";
    }
}
