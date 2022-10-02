import java.util.ArrayList;

public class Player {
    private Room currentRoom;

    ArrayList<Item> inventory = new ArrayList<>();

    public boolean takeItemInRoom (String itemName){
        Item takeItem = currentRoom.findRoomItems(itemName);
        if (takeItem != null) {
            addItemtoInventory(itemName);
            currentRoom.getItems().remove(takeItem);
            return true;
        } else {
            return false;
        }
    }

    public boolean dropItemInRoom (String itemName) {
        Item dropItem = findInventoryItems(itemName);
        if (dropItem != null) {
            currentRoom.addItem(itemName);
            inventory.remove(dropItem);
            return true;
        } else {
            return false;

        }
    }

    public Item findInventoryItems(String name) {
        for(Item i : inventory) {
            if(i.getItemName().equals(name)) {
                return i;
            }
        }
        return null;
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