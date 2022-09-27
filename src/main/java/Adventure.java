public class Adventure {
    private Room currentRoom;

    public Adventure() {
        Room room1 = new Room("Room 1", "Theres nothing but two doors");
        Room room2 = new Room("Room 2", "Not much to see in this room");
        Room room3 = new Room("Room 3", "This room is also empty");
        Room room4 = new Room("Room 4","Nothing");
        Room room5 = new Room("Room 5","There is a chest");
        Room room6 = new Room("Room 6","Nothing");
        Room room7 = new Room("Room 7","Nothing");
        Room room8 = new Room("Room 8","There is a panda");
        Room room9 = new Room("Room 9","There is another panda");

        currentRoom = room1;

        room1.setEast(room2);
        room1.setSouth(room4);
        room4.setNorth(room1);
        room2.setWest(room1);
        room2.setEast(room3);
        room3.setWest(room2);
        room3.setSouth(room6);
        room6.setNorth(room3);
        room6.setSouth(room9);
        room9.setNorth(room6);
        room9.setWest(room8);
        room8.setEast(room9);
        room8.setNorth(room5);
        room5.setSouth(room8);
        room8.setWest(room7);
        room7.setEast(room8);
        room7.setNorth(room4);
        room4.setSouth(room7);
    }


    public boolean goSouth() {
        if (currentRoom.getSouth() != null) {
            currentRoom = currentRoom.getSouth();
            return true;
        }
        else {
            return false;
        }
    }

    public boolean goEast() {
        if (currentRoom.getEast() != null) {
            currentRoom = currentRoom.getEast();
            return true;
        }
        else {
            return false;
        }
    }

    public boolean goNorth() {
        if (currentRoom.getNorth() != null) {
            currentRoom = currentRoom.getNorth();
            return true;
        }
        else {
            return false;
        }
    }

    public boolean goWest() {
        if (currentRoom.getWest() != null) {
            currentRoom = currentRoom.getWest();
            return true;
        }
        else {
            return false;
        }
    }


    public String look(){
        return currentRoom.getDescriptionOfRoom();
    }

    public String getRoomNumber() {
        return currentRoom.getNameOfRoom();
    }
}
