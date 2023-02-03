package model;

public class Room implements IRoom {

    public String roomNumber;
    public Double price;

    public RoomType enumeration;

    public Room(String roomNumber, Double price, RoomType enumeration){
        this.roomNumber = roomNumber;
        this.price = price;
        this.enumeration = enumeration;
    }

    public String getRoomNumber() {
        return this.roomNumber;
    }

    public Double getRoomPrice() {
        return this.price;
    }

    public RoomType getRoomType() {
        return this.enumeration;
    }

    public boolean isFree() {
        return this.price != null && this.price.equals(0.0);
    }

    @Override
    public String toString() {
        return super.toString() + " Room Number: " + roomNumber + " price: $" + price + " Room Type: " + enumeration;
    }
}
