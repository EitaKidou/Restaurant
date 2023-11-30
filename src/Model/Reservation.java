package Model;

import java.time.LocalDate;
import java.util.Arrays;

public class Reservation {
    public static int idd=0 ;
    public int id;
    private Customer[] customer;
    private LocalDate date;

    public Reservation(Customer[] customer, LocalDate date) {
        this.id = ++idd;
        this.customer = customer;
        this.date = date;
    }

    public static int getIdd() {
        return idd;
    }

    public static void setIdd(int idd) {
        Reservation.idd = idd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer[] getCustomer() {
        return customer;
    }

    public void setCustomer(Customer[] customer) {
        this.customer = customer;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", customer=" + Arrays.toString(customer) +
                ", date=" + date +
                '}';
    }
}
