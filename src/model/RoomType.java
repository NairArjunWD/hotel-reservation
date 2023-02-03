package model;

public enum RoomType {
    SINGLE ("1"), DOUBLE("2");

    public String typeChoice;

    private RoomType(String typeChoice) {
        this.typeChoice = typeChoice;
    }

    public static RoomType enumTypeChoice(String typeChoice) {
        for (RoomType roomType : values()) {
            if (roomType.typeChoice.equals(typeChoice)) {
                return roomType;
            }
        }
        throw new IllegalArgumentException();
    }


}
