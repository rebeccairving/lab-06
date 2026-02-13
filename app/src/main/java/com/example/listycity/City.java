package com.example.listycity;

/**
 * This is a class that defines a City.
 */
public class City implements Comparable<City> {
    private String city;
    private String province;

    /**
     * Creates a City with city name and province name
     *
     * @param city City name
     * @param province Province name
     */
    City(String city, String province){
        this.city = city;
        this.province = province;
    }

    /**
     * Gets  city name.
     *
     * @return City name
     */
    String getCityName(){
        return this.city;
    }

    /**
     * Gets province name.
     *
     * @return province name
     */
    String getProvinceName(){
        return this.province;
    }

    /**
     * Compares current City with another City by city its name attribute
     *
     * @param o The other City compared to
     * @return A negative value if this city name comes before the other,
     *         0 if equal, and a positive value if after
     */
    @Override
    public int compareTo(City o) {//change to Object city
        City city = (City) o;
        return this.city.compareTo(city.getCityName()); // this.city refers to the city name
    }
}
