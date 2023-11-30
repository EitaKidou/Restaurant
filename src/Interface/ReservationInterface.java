package Interface;

import Model.Reservation;

public interface ReservationInterface {
    void addReservation(Reservation reservation, int restaurantId);
    void updateReservation(int reservationId, Reservation reservation);
    void deleteReservation(int reservationId);
    Reservation getReservationById(int reservationId);
}
