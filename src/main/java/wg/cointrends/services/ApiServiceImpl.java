package wg.cointrends.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import wg.cointrends.api.domain.Coin;
import wg.cointrends.api.domain.CoinCode;

import java.util.Arrays;
import java.util.List;

@Service
public class ApiServiceImpl implements ApiService {

    private final RestTemplate restTemplate;

    public ApiServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Coin> getCoinData(CoinCode code) {

        UriComponentsBuilder uriBuilder = UriComponentsBuilder
                .fromUriString(code.getAPI_URL());

        Coin[] response = restTemplate.getForObject(uriBuilder.build().toString(), Coin[].class);

        return Arrays.asList(response);
    }
}
