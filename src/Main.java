import Interface.CustomerInterface;
import Interface.Impl.CustomerInterfaceImpl;
import Interface.Impl.DataBase;
import Interface.Impl.ReservationInterfaceImpl;
import Interface.Impl.RestaurantInterfaceImpl;
import Interface.ReservationInterface;
import Interface.RestaurantInterface;
import Model.Customer;
import Model.Reservation;
import Model.Restaurant;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Customer customer=new Customer("d1");
        Customer customer1 = new Customer("d2");
        Reservation reservation = new Reservation(new Customer[]{customer1}, LocalDate.of(2023,3,2));
        Reservation reservation1 = new Reservation(new Customer[]{customer},LocalDate.of(2023,4,3));
        Restaurant restaurant = new Restaurant("f1","30",new Reservation[]{reservation1});
        Restaurant restaurant1 = new Restaurant("f2","40",new Reservation[]{reservation});
        DataBase dataBase = new DataBase(new Restaurant[]{restaurant1,restaurant});
        CustomerInterface customerInterface = new CustomerInterfaceImpl(dataBase);
        ReservationInterface reservationInterface = new ReservationInterfaceImpl(dataBase);
        RestaurantInterface restaurantInterface = new RestaurantInterfaceImpl(dataBase);
        customerInterface.addCustomer(new Customer("d3"),1);
        customerInterface.deleteCustomer("d2");
        customerInterface.updateCustomer("d1",new Customer("d4"));
        System.out.println(customerInterface.getCustomerByReservationId(1, "d2"));
        reservationInterface.addReservation(new Reservation(new Customer[]{new Customer("d5")},LocalDate.of(2023,3,5)),1);
        reservationInterface.deleteReservation(2);
        reservationInterface.updateReservation(1,new Reservation(new Customer[]{new Customer("d6")},LocalDate.of(2023,6,5)));
        System.out.println(reservationInterface.getReservationById(1));
        restaurantInterface.addRestaurant(new Restaurant("f3","45", new Reservation[]{new Reservation(new Customer[]{new Customer("d7")},LocalDate.of(2023,7,5))}));
        restaurantInterface.deleteRestaurant("f2");
        restaurantInterface.updateRestaurant("f2",new Restaurant("f4","55", new Reservation[]{new Reservation(new Customer[]{new Customer("d8")},LocalDate.of(2023,7,8))}));
        System.out.println(Arrays.toString(restaurantInterface.getRestaurantByName("f1")));


    }
}