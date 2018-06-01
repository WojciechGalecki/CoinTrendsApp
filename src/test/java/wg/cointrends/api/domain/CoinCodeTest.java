package wg.cointrends.api.domain;

import org.junit.Test;
import static org.assertj.core.api.Assertions.*;


public class CoinCodeTest {

    final String API_URL_BTCUSD = "https://apiv2.bitcoinaverage.com/indices/global/history/BTCUSD?period=alltime&?format=json";

    @Test
    public void getAPI_URL_should_return_correct_value() {

        assertThat(CoinCode.BTCUSD.getAPI_URL()).isEqualTo(API_URL_BTCUSD);
    }
}