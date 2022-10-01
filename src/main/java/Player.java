public class Player {
    private Room currentRoom;

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public String look() {
        return currentRoom.getDescriptionOfRoom();
    }

    public String roomNumber() {
        return currentRoom.getNameOfRoom();
    }


    public boolean goSouth() {
        if (currentRoom.getSouth() != null) {
            setCurrentRoom(getCurrentRoom().getSouth());
            return true;
        }
        else {
            return false;
        }
    }

    public boolean goEast() {
        if (currentRoom.getEast() != null) {
            setCurrentRoom(getCurrentRoom().getEast());
            return true;
        }
        else {
            return false;
        }
    }

    public boolean goNorth() {
        if (currentRoom.getNorth() != null) {
            setCurrentRoom(getCurrentRoom().getNorth());
            return true;
        }
        else {
            return false;
        }
    }

    public boolean goWest() {
        if (currentRoom.getWest() != null) {
            setCurrentRoom(getCurrentRoom().getWest());
            return true;
        }
        else {
            return false;
        }
    }

    public Item lookForItems(){
        Item itemInRoom = null;
        for (int i = 0; i < currentRoom.getItems().size(); i++) {
            itemInRoom = currentRoom.getItems().get(i);
        }
        return itemInRoom;
    }

}
