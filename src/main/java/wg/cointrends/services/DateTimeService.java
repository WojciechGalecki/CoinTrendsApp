package wg.cointrends.services;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Service
public interface DateTimeService {

    static Long getMilliseconds(String dateTime) {

        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDate = LocalDateTime.parse(dateTime, df);

        return localDate.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }
}
