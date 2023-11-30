package Interface;

import Model.Customer;

public interface CustomerInterface {
    void addCustomer(Customer customer, int reservationId);
    void updateCustomer(String customerName, Customer customer);
    void deleteCustomer(String customerName);
    Customer getCustomerByReservationId(int reservationId, String customerName);
}
