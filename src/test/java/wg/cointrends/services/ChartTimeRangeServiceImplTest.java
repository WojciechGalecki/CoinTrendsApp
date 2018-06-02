package wg.cointrends.services;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class ChartTimeRangeServiceImplTest {

    ChartTimeRangeService service;
    List<Object[]> testData;

    @Before
    public void setUp() throws Exception {
        service = new ChartTimeRangeServiceImpl();

        testData = new LinkedList<>();
        Object[] data1 = new Object[2];
        data1[0] = 1000L;
        data1[1] = 10.50;
        Object[] data2 = new Object[2];
        data2[0] = 2000L;
        data2[1] = 0.00;
        testData.add(data1);
        testData.add(data2);
    }

    @Test
    public void changeTimeRange_should_return_correct_data_size() {

        assertThat(service.changeTimeRange(testData, 1100L, 2100L).size()).isEqualTo(1);
        assertThat(service.changeTimeRange(testData, 1000L, 2000L).size()).isEqualTo(2);
        assertThat(service.changeTimeRange(testData, 900L, 990L).size()).isEqualTo(0);
    }
}