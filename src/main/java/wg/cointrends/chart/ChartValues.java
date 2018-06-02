package wg.cointrends.chart;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class ChartValues {

    @NotNull
    @NotEmpty
    private String startDate;
    @NotNull
    @NotEmpty
    private String endDate;
}
