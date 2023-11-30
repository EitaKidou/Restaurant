package Model;

public class Customer {
    public static int idd=0 ;
    public int id;
    private String name;

    public Customer(String name) {
        this.id = ++idd;
        this.name = name;
    }

    public static int getIdd() {
        return idd;
    }

    public static void setIdd(int idd) {
        Customer.idd = idd;
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

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
