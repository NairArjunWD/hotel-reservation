package api;

import model.Customer;
import model.IRoom;
import model.Reservation;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;

public class HotelResource {

    private static HotelResource hotelResource;

    private CustomerService customerService = CustomerService.getInstance();
    private ReservationService reservationService = ReservationService.getInstance();

    public static HotelResource getInstance() {

        if (null == hotelResource) {
            hotelResource = new HotelResource();
        }

        return hotelResource;
    }

    public Customer getCustomer(String email) {

        return customerService.getCustomer(email);
    }

    public void createACustomer(String email, String firstName, String lastName) {
        customerService.addCustomer(email, firstName, lastName);
    }

    public IRoom getRoom(String roomNumnber) {

        return reservationService.getARoom(roomNumnber);
    }

    public Reservation bookARoom(String customerEmail, IRoom room, Date checkInDate, Date checkOutDate) {
        return reservationService.reserveARoom(getCustomer(customerEmail), room, checkInDate, checkOutDate);
    }

    public Collection<Reservation> getCustomersReservations(String customerEmail) throws InstantiationException, IllegalAccessException {
        Customer customer = getCustomer(customerEmail);

        if (customer == null) {
            return Collections.emptyList();
        }
        return reservationService.getCustomersReservation(getCustomer((customerEmail)));
    }

    public Collection<IRoom> findARoom(Date checkIn, Date checkOut) {
        return reservationService.findRooms(checkIn, checkOut);
    }

//    public Collection<IRoom> findFreeRooms(Date checkIn, Date checkOut) {
//        return reservationService.findFreeRooms(checkIn, checkOut);
//    }
//
//    public Date days(Date date) {
//        return reservationService.days(date);
//    }
}
