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


    public Room getCurrentRoom(){
        return player.getCurrentRoom();
    }

    public boolean getGoDirection(){
        return player.goDirection();
    }

    public boolean takeItem(String itemName) {
        return player.takeItemInRoom(itemName);
    }
    public boolean dropItem(String itemName) {
        return player.dropItemInRoom(itemName);
    }

    public ArrayList<Item> getInventory() {
        return player.getInventory();
    }

    public String look() {
        return player.look();
    }

    public String roomNumber() {
        return player.roomNumber();
    }
}
