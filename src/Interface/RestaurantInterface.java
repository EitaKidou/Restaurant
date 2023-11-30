package Interface;

import Model.Restaurant;

public interface RestaurantInterface {
    void addRestaurant(Restaurant restaurant);
    void updateRestaurant(String restaurantName, Restaurant restaurant);
    void deleteRestaurant(String restaurantName);
    Restaurant[] getRestaurantByName(String restaurantName);
}
