package wg.cointrends.services;

import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

public class DateTimeServiceTest {

    final String TEST_DATE = "1970-01-01 00:00:00";
    final long MILLISECONDS = -3600000L;

    @Test
    public void getMilliseconds_should_return_correct_value() {

        assertThat(DateTimeService.getMilliseconds(TEST_DATE)).isEqualTo(MILLISECONDS);
    }
}