package fr.lernejo.travelsite;

public class Voyage {
    private final String country;
    private final float temperature;

    public Voyage(String country,float temperature){
        this.country = country;
        this.temperature = temperature;
    }

    public Voyage (){
        this.country = "";
        this.temperature = 0;
    }

    public String getCountry()
    {
    return country;
    }

    public float getTemperature()
    {
        return temperature;
    }


}
