package service;

import model.Customer;
import model.IRoom;
import model.Reservation;

import java.util.*;

public class ReservationService {

    public static Set<IRoom> rooms = new HashSet<>();
    static Set<Reservation> reservations = new HashSet<>();

    private static ReservationService reservationService;

    private ReservationService() {
        this.rooms = new HashSet<>();
        this.reservations = new HashSet<>();
    }

//    public Collection<Reservation> reservations = new HashSet<>();


    public static ReservationService getInstance() {

        if (null == reservationService) {
            reservationService = new ReservationService();
        }

        return reservationService;
    }

//    List<String> rooms = new ArrayList<String>();


    public void addRoom(IRoom room) {

        rooms.add(room);

    }

    public IRoom getARoom(String roomId) {

        for (IRoom room: rooms) {
            if (room.getRoomNumber().equals(roomId)) {
                return room;
            }
        }
        return null;
    }

    public Reservation reserveARoom (Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {

        Reservation reservation = new Reservation(customer, room, checkInDate, checkOutDate);
        reservations.add(reservation);
        return reservation;
    }



    public Collection<IRoom> findRooms (Date checkInDate, Date checkOutDate) {

        return findRooms(checkInDate, checkOutDate);
    }

    public Collection<Reservation> getCustomersReservation (Customer customer) throws InstantiationException, IllegalAccessException {
        List<Reservation> reservationList = new ArrayList<Reservation>();

        for (Reservation r: reservations) {
            if (r.getCustomer().getEmail() == customer.getEmail()){
                System.out.println("Printing Reservation" + r);
                reservationList.add(r);
            }
//            System.out.println("Printing Reservation" + r.getCustomer().getEmail());
        }

        return reservationList;


    }

    public Collection<Reservation> printAllReservation() {
        if (reservations.isEmpty()) {
            System.out.println("Reservations are empty. No one has booked yet.");
        } else {
            System.out.println(reservations);
//            return reservations;
        }
        return reservations;
    }

    public Collection<IRoom> getAllRooms() {
        return rooms;
    }
}
