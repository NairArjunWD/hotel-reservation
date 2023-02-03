package model;

public class FreeRoom extends Room{
    public FreeRoom(String roomNumber, RoomType enumeration) {
        super(roomNumber, 0.0, enumeration);
//        price = 0.0;
    }
    @Override
    public String toString() {
        return super.toString() + " Price: $ " + price;
    }
}
