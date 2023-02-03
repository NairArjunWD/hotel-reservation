import api.HotelResource;
import model.Customer;
import model.Reservation;
import model.IRoom;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Scanner;

import static service.ReservationService.rooms;


public class MainMenu {

    private static HotelResource hotelResource = HotelResource.getInstance();
    private static String date_format = "mm/dd/yyyy";

    public static void main(String[] args) throws ParseException, InstantiationException, IllegalAccessException {
        MainMenu.mainMenu();
//        MainMenu.mainMenuDisplay();
    }

    public static void mainMenuDisplay() {

        System.out.println("Welcome to Orion Hotels");
        System.out.println("Please select an option");
        System.out.println("-------------------------");
        System.out.println("--------- Time ----------");
        System.out.println("-------------------------");
        System.out.println("1. Find and reserve a room");
        System.out.println("2. See my reservations");
        System.out.println("3. Create an account");
        System.out.println("4. Admin");
        System.out.println("5. Exit");

    }

    public static void mainMenu() throws ParseException, InstantiationException, IllegalAccessException {
        mainMenuDisplay();

//        int userChoiceMain;

        Scanner scanner = new Scanner(System.in);
        int userChoiceMain = scanner.nextInt();



        switch (userChoiceMain) {
            case 1:
                findAndReserveARoom();
                break;
            case 2:
                seeMyReservation();
                break;
            case 3:
                createAccount();
                break;
            case 4:
                AdminMenu.adminMenu();
                AdminMenu.adminMenuDisplay();
                break;
            case 5:
                System.out.println("Please visit again soon. Goodbye");
                break;
            default:
                System.out.println("Invalid input!");
        }
    }

    private static void findAndReserveARoom() throws ParseException, InstantiationException, IllegalAccessException {
        Scanner scanner = new Scanner(System.in);
//        Collection<IRoom> rooms = hotelResource.findARoom();

        System.out.println("Enter Check In Day: dd/mm/yyyy");
//        Date checkIn = getInputDate(scanner);
        String checkInDate = scanner.nextLine();
        Date checkIn = new SimpleDateFormat("dd/MM/yyyy").parse(checkInDate);
        System.out.println(checkIn);

        System.out.println("Enter Check Out Day: dd/mm/yyyy");
//        Date checkOut = getInputDate(scanner);
        String checkOutDate = scanner.nextLine();
        Date checkOut = new SimpleDateFormat("dd/MM/yyyy").parse(checkOutDate);
        System.out.println(checkOut);

        System.out.println("Reserve a room?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        String bookRoom = scanner.nextLine();

        if("1".equals(bookRoom)) {
            System.out.println("Do you have an account with us?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            String accountMember = scanner.nextLine();

            if ("1".equals(accountMember)) {
                System.out.println("Account Email: ");
                String accountEMail = scanner.nextLine();

                if (hotelResource.getCustomer(accountEMail) == null) {
                    System.out.println("No account found associated with this email address.");
                    createAccount();
                } else {
                    System.out.println("Welcome! Which room would you like to book?");
//                    adminResource.getAllRooms().forEach(System.out::println);
                    for (IRoom room : rooms) {
                        System.out.println(room);
                    }
                    String roomNumber = scanner.nextLine();
                    IRoom room = hotelResource.getRoom(roomNumber);

                    hotelResource.bookARoom(accountEMail, room, checkIn, checkOut);
                    System.out.println("Room has been booked!");
                    mainMenu();
                }
//                mainMenu();
            } else {
                System.out.println("Make an account before booking a room.");
                createAccount();
            }
        } else {
            System.out.println("Returning to Main Menu");
            mainMenu();
        }


    }

    private static void seeMyReservation() throws ParseException, InstantiationException, IllegalAccessException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter email: (john@email.com)");
        String customerEMail = scanner.nextLine();

//        hotelResource.getCustomersReservations(customerEMail).forEach(reservation -> System.out.println("\n" + reservation));
//        mainMenu();
        Collection<Reservation> reservations = hotelResource.getCustomersReservations(customerEMail);

        for (Reservation reservation : reservations) {
            System.out.println(reservation);
            mainMenu();
        }

//        if (hotelResource.getCustomersReservations(customerEMail) == null) {
//            System.out.println("No reservations found.");
////            for (Reservation reservation : hotelResource.getCustomersReservations(customerEMail))
////                System.out.println(reservation);
//            mainMenu();
//        } else {
////            hotelResource.getCustomersReservations(customerEMail).forEach(reservation -> System.out.println("\n" + reservation));
////            System.out.println("No reservations found.");
//            for (Reservation reservation : hotelResource.getCustomersReservations(customerEMail))
//                System.out.println(reservation);
//            mainMenu();
//        }
    }

    private static void createAccount() throws ParseException, InstantiationException, IllegalAccessException {
        Scanner scanner = new Scanner(System.in);


        System.out.println("First Name:");
        String firstName = scanner.nextLine();

        System.out.println("Last Name:");
        String lastName = scanner.nextLine();

        System.out.println("Enter Email: (john@email.com)");
        String email = scanner.nextLine();

        hotelResource.createACustomer(firstName, lastName, email);
        System.out.println("Account created!");
        mainMenu();
    }

//    private static void adminMenu() {
//
//    }
}
