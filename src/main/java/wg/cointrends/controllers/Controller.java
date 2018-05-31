package wg.cointrends.controllers;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import wg.cointrends.services.ApiService;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

@org.springframework.stereotype.Controller
public class Controller {

    private ApiService apiService;

    public Controller(ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping("/coin")
    public String test(Model model) {

        List<Double> avgs = new LinkedList<>();
        List<String> data = new LinkedList<>();

        apiService.getBtcUsd().stream().iterator().forEachRemaining(avg -> {
            avgs.add(avg.getAverage());
            data.add(avg.getTime());
        });

        ///////////////////////////////////

        List<Object[]> test1 = new ArrayList<>();

        List<Long> longs = new ArrayList<>();

        data.stream().iterator().forEachRemaining(l -> longs.add(getLongTime(l)));

        for (int i = 0; i <longs.size() ; i++) {

            Object[] value = new Object[2];
            value[0] = longs.get(i);
            value[1] = avgs.get(i);

            test1.add(value);
        }

        //////////////////////////////////



       List<Object[]> test = new ArrayList<>();

        apiService.getBtcUsd().stream().iterator().forEachRemaining( t -> {

            Object[] array = new Object[2];
            array[0] = getLongTime(t.getTime());
            array[1] = t.getAverage();

            test.add(array);
        });

        test.subList(90, test.size()).clear();

        model.addAttribute("test", test);

        return "index";
    }

    private Long getLongTime(String time){

        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDate = LocalDateTime.parse(time, df);

        return localDate.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }
}
