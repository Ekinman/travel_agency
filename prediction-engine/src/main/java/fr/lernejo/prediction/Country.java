package fr.lernejo.prediction;

import java.util.List;

public class Country {
    private final String country;
    private final List<Temperature> temperatures;

    public Country(String country, List<Temperature> temperatures)
    {
        this.country = country;
        this.temperatures = temperatures;
    }

    public String getCountry()
    {
        return country;
    }

    public List<Temperature> getTemperatures() {
        return temperatures;
    }
}
