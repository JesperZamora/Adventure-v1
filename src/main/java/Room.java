import java.util.ArrayList;

public class Room {
    private final String nameOfRoom;
    private final String descriptionOfRoom;
    private Room north;
    private Room south;
    private Room east;
    private Room west;

    private ArrayList<Item> items = new ArrayList<>();

    public void addItem(String itemName) {
        Item newItem = new Item(itemName);
        items.add(newItem);
    }

    public ArrayList<Item> getItems(){
        return items;
    }

    public Item findRoomItems (String name) {
        for (Item i : items) {
            if(i.getItemName().equals(name)) {
                return i;
            }
        }
        return null;
    }


    public Room(String nameOfRoom, String descriptionOfRoom){
        this.nameOfRoom = nameOfRoom;
        this.descriptionOfRoom = descriptionOfRoom;
    }

    public void setNorth(Room north) {
        this.north = north;
    }
    public void setEast (Room east) {
        this.east = east;
    }
    public void setSouth(Room south) {
        this.south = south;
    }
    public void setWest(Room west) {
        this.west = west;
    }

    public Room getSouth() {
        return south;
    }
    public Room getEast() {
        return east;
    }
    public Room getWest() {
        return west;
    }
    public Room getNorth() {
        return north;
    }
    public String getDescriptionOfRoom () {
        return descriptionOfRoom;
    }
    public String getNameOfRoom() {
        return nameOfRoom;
    }

}