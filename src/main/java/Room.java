import java.util.ArrayList;

public class Room {
    private String nameOfRoom;
    private String descriptionOfRoom;
    private Room north;
    private Room south;
    private Room east;
    private Room west;

    private ArrayList<Item> items = new ArrayList<>();

    public void addItem(String itemName, String itemDescription) {
        Item newItem = new Item(itemName, itemDescription);
        items.add(newItem);
    }

    public void addFoodItem(String foodName, String foodDescription, int healthPoints) {
        Item newFood = new Food(foodName, foodDescription, healthPoints);
        items.add(newFood);
    }

    public void addMeleeWeapon(String weaponName, String weaponDescription){
        Item newMeleeWeapon = new MeleeWeapon(weaponName,weaponDescription);
        items.add(newMeleeWeapon);
    }

    public void addRangedWeapon(String weaponName, String weaponDescription, int ammunition) {
        Item newRangedWeapon = new RangedWeapon(weaponName, weaponDescription, ammunition);
        items.add(newRangedWeapon);
    }

    // Del 5
    private ArrayList<Enemy> enemies = new ArrayList<>();

    public void addEnemy(String enemyName, String enemyDescription, int enemyHealth, Weapon enemyWeapon){
        Enemy newEnemy = new Enemy(enemyName, enemyDescription, enemyHealth, enemyWeapon);
        enemies.add(newEnemy);
    }
    // Del 5
    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }
    // Del 5
    public void removeEnemy(Enemy enemyName) {
        enemies.remove(enemyName);
    }
    public Weapon addEnemyItemToRoom(Item enemyItem) {
        items.add(enemyItem);
        return null;
    }

    // Del 5
    public Enemy findEnemyInRoom(){
        for(Enemy findEnemy : enemies) {
            return findEnemy;
        }
        return null;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public Item findRoomItems(String name) {
        for (Item i : items) {
            if (i.getItemName().equals(name)) {
                return i;
            }
        }
        return null;
    }

    public void removeItemFromRoom(Item item) {
        items.remove(item);
    }

    public void addItemFromInventory (Item itemName) {
        items.add(itemName);
    }


    public Room(String nameOfRoom, String descriptionOfRoom) {
        this.nameOfRoom = nameOfRoom;
        this.descriptionOfRoom = descriptionOfRoom;
    }

    public void setNorth(Room north) {
        this.north = north;
    }

    public void setEast(Room east) {
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

    public String getDescriptionOfRoom() {
        return descriptionOfRoom;
    }

    public String getNameOfRoom() {
        return nameOfRoom;
    }
}