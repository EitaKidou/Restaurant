package Interface.Impl;

import Interface.RestaurantInterface;
import Model.Restaurant;
import com.sun.source.tree.ArrayAccessTree;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.rmi.server.RemoteRef;
import java.util.Arrays;

public class RestaurantInterfaceImpl implements RestaurantInterface {
    private DataBase dataBase;

    public RestaurantInterfaceImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    public DataBase getDataBase() {
        return dataBase;
    }

    public void setDataBase(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public String toString() {
        return "RestaurantInterfaceImpl{" +
                "dataBase=" + dataBase +
                '}';
    }

    @Override
    public void addRestaurant(Restaurant restaurant) {
        Restaurant[] restaurants;
        restaurants= Arrays.copyOf(dataBase.getRestaurants(),dataBase.getRestaurants().length+1);
        restaurants[restaurants.length-1]=restaurant;
        dataBase.setRestaurants(restaurants);
        System.out.println(Arrays.toString(restaurants));
    }

    @Override
    public void updateRestaurant(String restaurantName, Restaurant restaurant) {
        for (Restaurant restaurant1: dataBase.getRestaurants()) {
            if (restaurant1.getName().equals(restaurantName)){
                restaurant1.setCapacity(restaurant.getCapacity());
                restaurant1.setName(restaurant.getName());
                restaurant1.setReservations(restaurant.getReservations());
            }
        }
    }

    @Override
    public void deleteRestaurant(String restaurantName) {
        Restaurant[] restaurants= Arrays.copyOf(dataBase.getRestaurants(),dataBase.getRestaurants().length-1);
        int counter=0;
        for (Restaurant restaurant:dataBase.getRestaurants()) {
            if (restaurant.getName().equals(restaurantName)){
                restaurants[counter]=restaurant;
                counter++;
            }
        }
        Restaurant[] restaurants1 = Arrays.copyOf(restaurants,counter);
        System.out.println(Arrays.toString(restaurants1));
    }

    @Override
    public Restaurant[] getRestaurantByName(String restaurantName) {
        Restaurant[] restaurants = new Restaurant[dataBase.getRestaurants().length];
        int counter=0;
        for (Restaurant restaurant: dataBase.getRestaurants()) {
            if (restaurant.getName().equals(restaurantName)){
                restaurants[counter]=restaurant;
                counter++;
            }
        }
        Restaurant[] restaurants1=Arrays.copyOf(restaurants,counter);
        return restaurants1;
    }
}
