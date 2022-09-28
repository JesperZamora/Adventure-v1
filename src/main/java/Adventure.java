public class Adventure {
    private Room currentRoom;



        currentRoom = room1;



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
