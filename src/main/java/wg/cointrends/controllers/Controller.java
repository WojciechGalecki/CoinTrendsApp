package wg.cointrends.controllers;

import wg.cointrends.services.ApiService;

@org.springframework.stereotype.Controller
public class Controller {

    private ApiService apiService;

    public Controller(ApiService apiService) {
        this.apiService = apiService;
    }


}
