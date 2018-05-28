package wg.cointrends.services;

import wg.cointrends.api.domain.BtcUsd;

import java.util.List;

public interface ApiService {

    List<BtcUsd> getBtcUsd();
}
