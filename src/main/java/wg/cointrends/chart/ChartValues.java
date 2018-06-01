package wg.cointrends.chart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChartValues {

    @NotNull
    @NotEmpty
    private String startDate;
    @NotNull
    @NotEmpty
    private String endDate;
    private Long startMilliseconds;
    private Long endMilliseconds;
}
