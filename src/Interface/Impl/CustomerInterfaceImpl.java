package Interface.Impl;

import Interface.CustomerInterface;
import Model.Customer;
import Model.Reservation;
import Model.Restaurant;

import java.util.Arrays;

public class CustomerInterfaceImpl implements CustomerInterface {
    private DataBase dataBase;

    public CustomerInterfaceImpl(DataBase dataBase) {
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
        return "CustomerInterfaceImpl{" +
                "dataBase=" + dataBase +
                '}';
    }

    @Override
    public void addCustomer(Customer customer, int reservationId) {
        Customer[] customers;
        for (Restaurant restaurant:dataBase.getRestaurants()) {
            for (Reservation reservation:restaurant.getReservations()) {
                if (reservation.getId()==reservationId){
                    customers= Arrays.copyOf(reservation.getCustomer(), reservation.getCustomer().length+1);
                    customers[customers.length-1]=customer;
                    reservation.setCustomer(customers);
                    System.out.println(Arrays.toString(customers));
                }
            }
        }
    }

    @Override
    public void updateCustomer(String customerName, Customer customer) {
        for (Restaurant restaurant: dataBase.getRestaurants()) {
            for (Reservation reservation:restaurant.getReservations()) {
                for (Customer customer1: reservation.getCustomer()) {
                    if (customer1.getName().equals(customerName)){
                        customer1.setName(customer.getName());
                    }
                }
            }
        }
        System.out.println("Customer with name"+customerName+"is successfully updated!!!");
    }

    @Override
    public void deleteCustomer(String customerName) {
        Customer[] customers;
        int counter = 0;
        for (Restaurant restaurant: dataBase.getRestaurants()) {
            for (Reservation reservation:restaurant.getReservations()) {
                for (Customer customer1: reservation.getCustomer()) {
                    if (customer1.getName().equals(customerName)){
                        customers= new Customer[reservation.getCustomer().length-1];
                        for (int i = 0; i < reservation.getCustomer().length; i++) {
                            if (!(reservation.getCustomer()[i].getName().equals(customerName))){
                                customers[counter]=reservation.getCustomer()[i];
                                counter++;
                            }
                        }
                        reservation.setCustomer(customers);
                        System.out.println("Successfully deleted");
                        break;
                    }
                }
            }
        }
    }

    @Override
    public Customer getCustomerByReservationId(int reservationId, String customerName) {
        for (Restaurant restaurant: dataBase.getRestaurants()) {
            for (Reservation reservation : restaurant.getReservations()) {
                for (Customer customer1 : reservation.getCustomer()) {
                    if (reservation.getId() == reservationId && customer1.getName().equals(customerName)) {
                        return customer1;
                    }
                }
            }
        }
        return null;
    }
}
