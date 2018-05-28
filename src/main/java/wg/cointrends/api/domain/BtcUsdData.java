package wg.cointrends.api.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class BtcUsdData {

    private List<BtcUsd> data;
}
