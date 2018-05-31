package wg.cointrends.services;

import wg.cointrends.api.domain.CoinCode;

import java.util.List;

public interface HighChartService {

    List<Object[]> prepareDataToChart(CoinCode code);
}
