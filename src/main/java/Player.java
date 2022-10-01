import java.util.ArrayList;

public class Player {
    private Room currentRoom;

    ArrayList<Item> inventory = new ArrayList<>();

    public void takeItemInRoom (String itemName){
        Item takeItem = currentRoom.findRoomItems(itemName);
        if (takeItem == null) {
            System.out.println("There is nothing like " + itemName + " to take around here!");
        }else {
            addItemtoInventory(itemName);
            currentRoom.getItems().remove(takeItem);
            System.out.println("Item " + itemName + " added to your inventory");
        }
    }



    public void addItemtoInventory(String itemName) {
        Item newItem = new Item (itemName);
        inventory.add(newItem);
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

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

    public boolean goNorth() {
        if (currentRoom.getNorth() != null) {
            setCurrentRoom(getCurrentRoom().getNorth());
            return true;
        } else {
            return false;
        }
    }

    public boolean goSouth() {
        if (currentRoom.getSouth() != null) {
            setCurrentRoom(getCurrentRoom().getSouth());
            return true;
        } else {
            return false;
        }
    }

    public boolean goEast() {
        if (currentRoom.getEast() != null) {
            setCurrentRoom(getCurrentRoom().getEast());
            return true;
        } else {
            return false;
        }
    }

    public boolean goWest() {
        if (currentRoom.getWest() != null) {
            setCurrentRoom(getCurrentRoom().getWest());
            return true;
        } else {
            return false;
        }
    }


}

/*
    public Item lookForItems(){
        Item itemInRoom = null;
        for (int i = 0; i < currentRoom.getItems().size(); i++) {
            itemInRoom = currentRoom.getItems().get(i);
        }
        return itemInRoom;
    }

 */