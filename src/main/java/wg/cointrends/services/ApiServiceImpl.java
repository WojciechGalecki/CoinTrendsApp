package wg.cointrends.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import wg.cointrends.api.domain.BtcUsd;
import wg.cointrends.api.domain.BtcUsdData;

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

        BtcUsdData btcUsdData = restTemplate.getForObject(uriBuilder.toString(), BtcUsdData.class);

        return btcUsdData.getData();
    }
}
