package fr.lernejo.travelsite;
import org.springframework.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utilisateur {

    private final String regex = "^(.+)@(.+)$";
    private final String userEmail;
    private final String userName;
    private final String userCountry;
    private final String weatherExpectation;
    private final int  minimumTemperatureDistance;






    public Utilisateur(String userEmail, String userName, String userCountry, String weatherExpectation, int minimumTemperatureDistance)
    {

        this.userEmail = userEmail;
        this.userName = userName;
        this.userCountry = userCountry;
        this.weatherExpectation = weatherExpectation;
        this.minimumTemperatureDistance = minimumTemperatureDistance;
    }


    public boolean validInscription() {

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(this.userEmail);
        boolean resultat = false;
        if (StringUtils.hasLength(userEmail) && matcher.matches() && StringUtils.hasLength(userName) && StringUtils.hasLength(userCountry) && StringUtils.hasLength(weatherExpectation)) {
            if (this.minimumTemperatureDistance > 0) {
                resultat = true;
            }
        }
        return resultat;
    }


    public String getUserEmail() {
        return userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserCountry() {
        return userCountry;
    }

    public String getWeatherExpectation() {
        return weatherExpectation;
    }

    public int getMinimumTemperatureDistance() {
        return minimumTemperatureDistance;
    }


}
