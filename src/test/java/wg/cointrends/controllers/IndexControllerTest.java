package wg.cointrends.controllers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import wg.cointrends.api.domain.CoinCode;
import wg.cointrends.chart.ChartValues;
import wg.cointrends.services.ApiService;
import wg.cointrends.services.ApiServiceImpl;
import wg.cointrends.services.ChartTimeRangeService;
import wg.cointrends.services.HighChartService;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrlTemplate;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.assertj.core.api.Assertions.*;

public class IndexControllerTest {

    IndexController controller;
    ApiService apiService;
    ChartValues values;

    MockMvc mockMvc;

    @Mock
    HighChartService chartService;
    @Mock
    ChartTimeRangeService rangeService;
    @Mock
    Model model;
    @Mock
    BindingResult result;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        apiService = new ApiServiceImpl(new RestTemplateBuilder().build());
        controller = new IndexController(chartService, rangeService);
        values = new ChartValues();

        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void getIndexPage_should_return_index_view() throws Exception {

        mockMvc.perform(get("/coin"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }

    @Test
    public void getIndexPageTest() {

        //given
        List<Object[]> responseData = new LinkedList<>();
        Object[] coinData = new Object[2];
        coinData[0] = 111111111111111111L;
        coinData[1] = 10.0466;
        responseData.add(coinData);

        when(chartService.prepareDataToChart(CoinCode.BTCUSD)).thenReturn(responseData);

        ArgumentCaptor<List<Object[]>> argumentCaptor = ArgumentCaptor.forClass(List.class);

        //when
        String viewName = controller.getIndexPage(model);

        //then
        assertThat(viewName).isEqualTo("index");
        verify(chartService, times(1)).prepareDataToChart(CoinCode.BTCUSD);
        verify(model, times(1)).addAttribute(eq("BTCUSD"), argumentCaptor.capture());
        List<Object[]> listInController = argumentCaptor.getValue();
        assertThat(listInController.size()).isEqualTo(1);
    }

    @Test
    public void getChartTimeRange_should_redirect_coin_url() throws Exception {

        mockMvc.perform(post("/coin"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrlTemplate("/coin"));
    }
}
