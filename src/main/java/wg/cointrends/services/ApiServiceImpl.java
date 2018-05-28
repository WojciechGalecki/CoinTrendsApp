package wg.cointrends.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import wg.cointrends.api.domain.BtcUsd;

import java.util.Arrays;
import java.util.List;

@Service
public class ApiServiceImpl implements ApiService {

    private RestTemplate restTemplate;

    private final String API_URL;

    public ApiServiceImpl(RestTemplate restTemplate, @Value("${api.url}") String API_URL) {
        this.restTemplate = restTemplate;
        this.API_URL = API_URL;
    }

    @Override
    public List<BtcUsd> getBtcUsd() {

        UriComponentsBuilder uriBuilder = UriComponentsBuilder
                .fromUriString(API_URL);


        BtcUsd[] response = restTemplate.getForObject(uriBuilder.build().toString(), BtcUsd[].class);


        return Arrays.asList(response);
    }
}
