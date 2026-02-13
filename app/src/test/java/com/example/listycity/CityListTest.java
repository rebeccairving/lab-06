package com.example.listycity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }
    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());// 1 bcs size of get cities is 1
        City city = new City("Calgary", "Alberta");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Winnepeg", "Manitoba");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    void testGetCities() {
        CityList cityList = mockCityList();
        // This line checks if the first city in the cityList (retrieved by cityList.getCities().get(0))
        // is the same as the city returned by mockCity()
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
        // This pushes down the original city
        City city = new City("Calgary", "Alberta");
        cityList.add(city);
        // Now the original city should be at position 1
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }


    @Test
    void testHasCityTrue() {
        CityList cityList = new CityList();
        City city = new City("Edmonton", "Alberta");
        cityList.add(city);
        assertTrue(cityList.hasCity(city));
    }

    @Test
    void testHasCityFalse() {
        CityList cityList = new CityList();
        City cityInList = new City("Edmonton", "Alberta");
        cityList.add(cityInList);
        City differentCityObject = new City("Edmonton", "Alberta"); // same values, different object
        assertFalse(cityList.hasCity(differentCityObject)); // will be false without equals/hashCode
    }

    @Test
    void testDeleteRemovesCity() {
        CityList cityList = new CityList();
        City city = new City("Edmonton", "Alberta");
        cityList.add(city);
        assertEquals(1, cityList.countCities());
        cityList.delete(city);
        assertEquals(0, cityList.countCities());
        assertFalse(cityList.hasCity(city));
    }

    @Test
    void testDeleteThrowsException() {
        CityList cityList = new CityList();
        City city = new City("Edmonton", "Alberta"); // not added
        assertThrows(IllegalArgumentException.class, () -> cityList.delete(city));
    }

    @Test
    void testCountCities() {
        CityList cityList = new CityList();
        assertEquals(0, cityList.countCities());
        City city1 = new City("Edmonton", "Alberta");
        City city2 = new City("Calgary", "Alberta");
        cityList.add(city1);
        cityList.add(city2);
        assertEquals(2, cityList.countCities());
    }

}
