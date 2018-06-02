package wg.cointrends.services;

import java.util.List;

public interface ChartTimeRangeService {

    List<Object[]> changeTimeRange(List<Object[]> coinData, Long startMilliseconds, Long endMilliseconds);
}
