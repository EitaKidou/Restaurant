package Interface.Impl;

import Interface.ReservationInterface;
import Model.Reservation;
import Model.Restaurant;

import java.util.Arrays;

public class ReservationInterfaceImpl implements ReservationInterface {
    private DataBase dataBase;

    public ReservationInterfaceImpl(DataBase dataBase) {
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
        return "ReservationInterfaceImpl{" +
                "dataBase=" + dataBase +
                '}';
    }

    @Override
    public void addReservation(Reservation reservation, int restaurantId) {
        Reservation[] reservations;
        for (Restaurant restaurant: dataBase.getRestaurants()) {
            if (restaurant.getId()==restaurantId){
                reservations= Arrays.copyOf(restaurant.getReservations(),restaurant.getReservations().length+1);
                reservations[reservations.length-1]=reservation;
                restaurant.setReservations(reservations);
                System.out.println("Reservation added successfully");
            }
        }
    }

    @Override
    public void updateReservation(int reservationId, Reservation reservation) {
        for (Restaurant restaurant:dataBase.getRestaurants()) {
            for (Reservation reservation1: restaurant.getReservations()) {
                if (reservation1.getId()==reservationId){
                    reservation1.setCustomer(reservation.getCustomer());
                    reservation1.setDate(reservation.getDate());
                }
            }
        }
        System.out.println("Reservation with Id" + reservationId + "is successfully updated!!!");
    }

    @Override
    public void deleteReservation(int reservationId) {
        Reservation[] reservations;
        int counter=0;
        for (Restaurant restaurant:dataBase.getRestaurants()) {
            for (Reservation reservation: restaurant.getReservations()) {
                if (reservation.getId()==reservationId){
                    reservations= new Reservation[restaurant.getReservations().length-1];
                    for (int i = 0; i < restaurant.getReservations().length; i++) {
                        if (!(restaurant.getReservations()[i].getId() == reservationId)){
                            reservations[counter] = restaurant.getReservations()[i];
                            counter++;
                        }
                    }
                    restaurant.setReservations(reservations);
                    System.out.println("Successfully deleted");
                    break;

                }
            }
        }
    }

    @Override
    public Reservation getReservationById(int reservationId) {
        for (Restaurant restaurant: dataBase.getRestaurants()) {
            for (Reservation reservation: restaurant.getReservations()) {
                if (reservation.getId()==reservationId){
                    return reservation;
                }
            }
        }
        return null;
    }
}
