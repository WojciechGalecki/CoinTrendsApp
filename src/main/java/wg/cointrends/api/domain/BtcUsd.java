package wg.cointrends.api.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BtcUsd {

    private Double volume;
    private Integer open;
    private Double low;
    private Double average;
    private Double high;
    private String time;
}
