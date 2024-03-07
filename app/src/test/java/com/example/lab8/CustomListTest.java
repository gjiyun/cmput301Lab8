package com.example.lab8;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;


//import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return CustomList list
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }
    @Test
    public void countCitiesTest(){
        list = MockCityList();
        assertEquals(list.countCities(), 0);
        list.addCity(new City("Halifax", "NS"));
        assertEquals(list.countCities(), 1);
    }
    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size plus one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.countCities();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.countCities(),listSize + 1);
    }
    /**
     * check if city is contained in list
     * add city to list
     * check again if city is now contained in list
     */
    @Test
    public void testHasCity(){
        list = MockCityList();
        City city = new City("Vancouver","British Columbia");
        assertFalse(list.hasCity(city));
        list.addCity(city);
        assertTrue(list.hasCity(city));
    }
    /**
     * get the size of the list
     * decrease the list by deleting a city
     * check if our current size matches the initial ize minus one
     */
    @Test
    public void testDeleteCity(){
        list = MockCityList();
        int listSize = list.getCount();
        City city = new City("Edmonton", "AB");
        list.addCity(city);
        assertEquals(list.countCities(), listSize + 1);
        list.deleteCity(city);
        assertEquals(list.countCities(), listSize);
    }
}
