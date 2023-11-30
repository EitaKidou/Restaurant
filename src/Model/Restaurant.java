package Model;

import java.util.Arrays;

public class Restaurant {
    public static int idd=0 ;
    public int id;
    private String name;
    private String capacity;
    private Reservation[] reservations;

    public Restaurant( String name, String capacity, Reservation[] reservations) {
        this.id = ++idd;
        this.name = name;
        this.capacity = capacity;
        this.reservations = reservations;
    }

    public static int getIdd() {
        return idd;
    }

    public static void setIdd(int idd) {
        Restaurant.idd = idd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public Reservation[] getReservations() {
        return reservations;
    }

    public void setReservations(Reservation[] reservations) {
        this.reservations = reservations;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", capacity='" + capacity + '\'' +
                ", reservations=" + Arrays.toString(reservations) +
                '}';
    }
}
