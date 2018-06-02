package wg.cointrends.services;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class ChartTimeRangeServiceImpl implements ChartTimeRangeService {

    @Override
    public List<Object[]> changeTimeRange(List<Object[]> chartData, Long startMilliseconds, Long endMilliseconds) {


        return chartData.stream().filter(getRangePredicate(startMilliseconds, endMilliseconds)

        ).collect(Collectors.toList());
    }

    private Predicate<Object[]> getRangePredicate(Long startMilliseconds, Long endMilliseconds) {

        return data ->

            (Long) data[0] >= startMilliseconds && (Long) data[0] <= endMilliseconds;
    }
}
