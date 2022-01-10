package fr.lernejo.prediction;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/api")
public class PingController {

    final TemperatureService temperatureService = new TemperatureService();


    @GetMapping(path = "/ping")
    String ping() {
        return "OK";
    }

    @GetMapping("/temperature")
    public ResponseEntity<?> getTemperature(@RequestParam String country){
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Calendar c = Calendar.getInstance(); // starts with today's date and time
        Calendar c1 = Calendar.getInstance(); // starts with today's date and time
        String ajd = simpleDateFormat.format(c1.getTime());
        c.add(Calendar.DAY_OF_YEAR, -1);  // advances day by 2
        String hier = simpleDateFormat.format(c.getTime());
        try{List<Temperature> TempList = new ArrayList<>();
            var temp1 = temperatureService.getTemperature(country);
            var temp2 = temperatureService.getTemperature(country);
            TempList.add(new Temperature(ajd, temp1));
            TempList.add(new Temperature(hier, temp2));
            Country unPays = new Country(country,TempList);
            return new ResponseEntity<>(unPays, HttpStatus.OK);}
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.EXPECTATION_FAILED);}}
}
