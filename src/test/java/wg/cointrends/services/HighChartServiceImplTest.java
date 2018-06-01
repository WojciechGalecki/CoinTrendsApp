package wg.cointrends.services;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.web.client.RestTemplateBuilder;
import wg.cointrends.api.domain.CoinCode;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class HighChartServiceImplTest {

    HighChartService service;
    ApiService apiService;

    @Before
    public void setUp() throws Exception {
        apiService = new ApiServiceImpl(new RestTemplateBuilder().build());
        service = new HighChartServiceImpl(apiService);
    }

    @Test
    public void prepareDataToChart_should_return_not_empty_data() {

        assertThat(service.prepareDataToChart(CoinCode.BTCUSD)).isNotEmpty();
    }

    @Test
    public void prepareDateToChart_should_return_list_of_arrays_with_the_size_2(){

        List<Object[]> data = service.prepareDataToChart(CoinCode.ETHUSD);

        assertThat(data.get(0).length).isEqualTo(2);
    }
}