package api;

import model.Customer;
import model.IRoom;
import model.Reservation;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;
import java.util.List;

public class AdminResource {

    private static AdminResource adminResource;

    private CustomerService customerService = CustomerService.getInstance();
    private ReservationService reservationService = ReservationService.getInstance();

    public static AdminResource getInstance() {
        if (null == adminResource) {
            adminResource = new AdminResource();
        }

        return adminResource;
    }

    public Customer getCustomer(String email) {

        return customerService.getCustomer(email);
    }

    public void addRoom(List<IRoom> rooms) {

//        rooms.forEach(reservationService::addRoom);

        for (IRoom room : rooms) {
            reservationService.addRoom(room);
        }
    }

    public Collection<IRoom> getAllRooms() {
        return reservationService.getAllRooms();
    }

    public Collection<Customer> getAllCustomers() {

        return customerService.getAllCustomers();
    }

    public Collection<Reservation> displayAllReservations() {
//        reservationService.printAllReservation();
        return reservationService.printAllReservation();
    }
}
