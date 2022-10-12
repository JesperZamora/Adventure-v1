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

    public boolean go(String direction) {
        if(direction.length() > 0)
            return player.move(direction.charAt(0));
        else
            return false;
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

    public WeaponEnum equipItem(String weaponName) {
        return player.equipWeapon(weaponName);
    }



    public AttackEnum attackWithWeapon() {
        return player.attack();
    }

    public int enemyHealth() {
        return player.enemyHealth();
    }

    public int enemyAttack() {
        return player.enemyDamage();
    }

    public String equippedWeapon() {
        return player.getCurrentWeapon().getItemName();
    }

    public int ammunitionCount() {
        return player.getAmmunition();
    }


    public int playerHealth() {
        return player.getPlayerHealth();
    }

    public String playerHealthDescription() {
        int playerHealth = player.getPlayerHealth();
        return player.playerHealthDescription(playerHealth);
    }


    public ArrayList<Item> showInventory() {
        return player.getInventory();
    }

    public ArrayList<Item> ShowItemsInRoom() {
        return player.getCurrentRoom().getItems();
    }



    public String currentRoom() {
        return player.nameOfRoom();
    }

    public ArrayList<Enemy> ShowEnemyInRoom() {
        return player.getCurrentRoom().getEnemies();
    }

    public Item equippedWeaponType() {
        return player.getCurrentWeapon();
    }

    public String currentRoomDescription() {
        return player.descriptionOfRoom();
    }


    public String gameplayCommands() {
        String commandList = """
                Movement commands:
                Type "go" and choose direction (eg. go north / go n)
                "Go North"   (n) - move north
                "Go South"   (s) - move south
                "Go East"    (e) - move east
                "Go West     (w) - move west
                                
                In-game commands:
                "Look"       (l) - to look around
                "Take"       (t) - take an item
                "Drop"       (d) - drop item
                "Eat"        (e) - eat item
                "Health      (hp) - current health points
                "Equip"      (eq) - equip item
                "Attack"     (atk) - Attack with weapon
                "Inventory"  (inv) - show inventory
                                         
                Other commands:
                "Help"       (H) - list of commands
                "Exit"           - exit gameplay
                """;
        return commandList;
    }




}
