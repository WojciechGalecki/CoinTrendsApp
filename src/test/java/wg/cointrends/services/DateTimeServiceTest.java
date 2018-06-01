package wg.cointrends.services;

import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

public class DateTimeServiceTest {



    final String testDate = "1970-01-01 00:00:00";
    final long milliseconds = -3600000L;

    @Test
    public void getMilliseconds_should_return_correct_value() {

        assertThat(DateTimeService.getMilliseconds(testDate)).isEqualTo(milliseconds);
    }
}