import api.AdminResource;
import model.*;

import java.text.ParseException;
import java.util.Collection;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;

public class AdminMenu {

    private static AdminResource adminResource = AdminResource.getInstance();

    public static void adminMenuDisplay() {

        System.out.println("Administrator Menu");
        System.out.println("Please select an option");
        System.out.println("-------------------------");
        System.out.println("--------- Time ----------");
        System.out.println("-------------------------");
        System.out.println("1. See all customers");
        System.out.println("2. See all Rooms");
        System.out.println("3. See all Reservations");
        System.out.println("4. Add a Room");
        System.out.println("5. Back to Main Menu");

    }

    public static void adminMenu() throws ParseException, InstantiationException, IllegalAccessException {
        adminMenuDisplay();
        int userChoiceAdmin;

        Scanner scanner = new Scanner(System.in);
        userChoiceAdmin = scanner.nextInt();

        switch (userChoiceAdmin) {
            case 1:
                displayAllCustomers();
                break;
            case 2:
                displayAllRooms();
                break;
            case 3:
                displayAllReservations();
                break;
            case 4:
                addARoom();
                break;
            case 5:
                System.out.println("Returning to main menu. Goodbye");
                MainMenu.mainMenu();
                break;
            default:
                System.out.println("Invalid input!");
        }
    }

    private static void addARoom() throws ParseException, InstantiationException, IllegalAccessException {
        System.out.println("Enter Room #");
        Scanner scanner = new Scanner(System.in);
        String roomNumber = scanner.nextLine();

        System.out.println("Enter Price: ");
        double roomPrice = Double.parseDouble(scanner.nextLine());

        System.out.println("SINGLE or DOUBLE?");
//        System.out.println("SINGLE");
//        System.out.println("DOUBLE");

        RoomType roomType = RoomType.valueOf(scanner.nextLine().toUpperCase(Locale.ROOT));
//
//        if (roomType == RoomType.SINGLE){
//            addRoomType(scanner) == 1;
//        } else if (addRoomType(scanner) == 2) {
//            // Double
//        } else {
//            System.out.println("Invalid Input!");
//        }

        switch (roomType) {
            case SINGLE:
                System.out.println("Single");
            break;
            case DOUBLE:
                System.out.println("Double");
            break;
            default:
                System.out.println("Invalid Input!");
        }

        Room room = new Room(roomNumber, roomPrice, roomType);

        adminResource.addRoom(Collections.singletonList(room));
        System.out.println("Room has been added to system");
        adminMenu();
    }

    public static void displayAllReservations() throws ParseException, InstantiationException, IllegalAccessException {
        Collection<Reservation> reservations = adminResource.displayAllReservations();
//        adminResource.displayAllReservations();
//        if (reservations.isEmpty()) {
//            System.out.println("No reservations found.");
//            adminMenu();
//        } else {
//            for (Reservation reservation : reservations) {
//                System.out.println(reservation);
//
//        }
        for (Reservation reservation : reservations) {
            System.out.println(reservation);
//            adminMenu();
        }
        adminMenu();
    }

    private static void displayAllRooms() throws ParseException, InstantiationException, IllegalAccessException {
        Collection<IRoom> rooms = adminResource.getAllRooms();
        if (rooms.isEmpty()) {
            System.out.println("No rooms found.");
            adminMenu();
        } else {
            for (IRoom room : rooms) {
                System.out.println(room);
            }
            adminMenu();
        }
    }

    private static void displayAllCustomers() throws ParseException, InstantiationException, IllegalAccessException {
        Collection<Customer> customers = adminResource.getAllCustomers();

        if (customers.isEmpty()) {
            System.out.println("No customers in database.");
            adminMenu();
        } else {
            for (Customer customer : customers) {
                System.out.println(customer);
            }
            adminMenu();
        }

//        adminResource.getAllCustomers();
    }
}
