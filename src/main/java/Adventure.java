import java.util.ArrayList;

public class Adventure {
    private Map map;
    private Player player;

    public Adventure() {
        map = new Map();
        player = new Player();
        player.setCurrentRoom(map.getStarterRoom());
    }

    //UserInterface -> Adventure -> Player -> Room -> Items

    public Room getCurrentRoom() {
        return player.getCurrentRoom();
    }

    public ArrayList<Item> currentRoomGetItems() {
        return player.getCurrentRoom().getItems();
    }

    public boolean takeItem(String itemName) {
        return player.takeItemInRoom(itemName);
    }
    public boolean dropItem(String itemName) {
        return player.dropItemInRoom(itemName);
    }

    public boolean eatItem(String foodName) {
        return player.eatItem(foodName);
    }

    public boolean equipItem(String weaponName) {
        return player.equipWeapon(weaponName);
    }

    public boolean attack() {
        return player.attack();
    }

    public ArrayList<Item> getInventory() {
        return player.getInventory();
    }

    public Item getCurrentWeapon(){
        return player.getCurrentWeapon();
    }

    public String look() {
        return player.look();
    }

    public String roomNumber() {
        return player.roomNumber();
    }

    public boolean goNorth() {
        return player.goNorth();
    }

    public boolean goSouth() {
        return player.goSouth();
    }

    public boolean goEast() {
        return player.goEast();
    }

    public boolean goWest() {
        return player.goWest();
    }

    public int getHealth() {
        return player.getPlayerHealth();
    }


}
