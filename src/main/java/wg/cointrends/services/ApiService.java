package wg.cointrends.services;

import wg.cointrends.api.domain.Coin;
import wg.cointrends.api.domain.CoinCode;

import java.util.List;

public interface ApiService {

    List<Coin> getCoinData(CoinCode code);
}
