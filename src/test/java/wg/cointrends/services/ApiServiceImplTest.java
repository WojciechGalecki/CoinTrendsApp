package wg.cointrends.services;

import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;
import org.springframework.boot.web.client.RestTemplateBuilder;
import wg.cointrends.api.domain.Coin;
import wg.cointrends.api.domain.CoinCode;

import java.util.List;


public class ApiServiceImplTest {

    ApiService service;

    @Before
    public void setUp() throws Exception {
        service = new ApiServiceImpl(new RestTemplateBuilder().build());
    }

    @Test
    public void getCoinData_should_return_not_empty_response_data() {

        List<Coin> responseData = service.getCoinData(CoinCode.BTCUSD);

        assertThat(responseData).isNotEmpty();
    }
}