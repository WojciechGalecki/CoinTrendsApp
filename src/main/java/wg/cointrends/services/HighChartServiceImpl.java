package wg.cointrends.services;

import org.springframework.stereotype.Service;
import wg.cointrends.api.domain.CoinCode;
import java.util.LinkedList;
import java.util.List;

@Service
public class HighChartServiceImpl implements HighChartService {

    private final ApiService apiService;

    public HighChartServiceImpl(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public List<Object[]> prepareDataToChart(CoinCode code) {

        List<Object[]> chartData = new LinkedList<>();

        apiService.getCoinData(code).stream().iterator().forEachRemaining(coin -> {

            Object[] coinData = new Object[2];
            coinData[0] = DateTimeService.getMilliseconds(coin.getTime());
            coinData[1] = coin.getAverage();

            chartData.add(coinData);
        });

        return chartData;
    }
}
