package Interface.Impl;

import Model.Restaurant;

import java.util.Arrays;

public class DataBase {
    private Restaurant[] restaurants;

    public DataBase(Restaurant[] restaurants) {
        this.restaurants = restaurants;
    }

    public Restaurant[] getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(Restaurant[] restaurants) {
        this.restaurants = restaurants;
    }

    @Override
    public String toString() {
        return "DataBase{" +
                "restaurants=" + Arrays.toString(restaurants) +
                '}';
    }
}
