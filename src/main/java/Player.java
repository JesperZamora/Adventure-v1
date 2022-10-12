import java.util.ArrayList;

public class Player {
    private Room currentRoom;
    private Weapon currentWeapon;
    private int playerHealth = 50;
    private ArrayList<Item> inventory = new ArrayList<>();

    public boolean takeItemInRoom(String itemName) {
        Item takeItem = currentRoom.findRoomItems(itemName);
        if (takeItem != null) {
            addFoundItemToInventory(takeItem);
            currentRoom.removeItemFromRoom(takeItem);
            return true;
        } else {
            return false;
        }
    }

    public boolean dropItemInRoom(String itemName) {
        Item dropItem = findInventoryItems(itemName);
        if (dropItem != null) {
            currentRoom.addItemFromInventory(dropItem);
            removeItemFromInventory(dropItem);
            return true;
        } else {
            return false;
        }
    }

    public boolean eatItem(String foodName) {
        Item foodItem = findInventoryItems(foodName);
        if (foodItem != null) {
            if (foodItem instanceof Food) {
                updatePlayerHealth(getFoodHealth((Food) foodItem));
                inventory.remove(foodItem);
                return true;
            }
        }
        return false;
    }

    public WeaponEnum equipWeapon(String weaponName) {
        Item equipWeapon = findInventoryItems(weaponName);
        if (equipWeapon instanceof Weapon) {
            currentWeapon = (Weapon) equipWeapon;
            inventory.remove(equipWeapon);
            return WeaponEnum.WEAPON;
        } else if (equipWeapon == null) {
            return WeaponEnum.NOT_WEAPON;
        } else
        return WeaponEnum.NOT_FOUND;
    }

    public AttackEnum attack() {
        Enemy attackEnemy = currentRoom.findEnemyInRoom();
        if(currentWeapon != null) {
            if(currentWeapon instanceof RangedWeapon && currentWeapon.getAmmunition() < 1)
                return AttackEnum.NO_AMMO;
            if (attackEnemy != null) {
                attackEnemy.updateEnemyHealth(currentWeapon.getItemDamage());
                takePlayerHealth(attackEnemy.enemyAttack());

                if (!attackEnemy.enemyAlive()) {
                    currentRoom.removeEnemy(attackEnemy);
                    attackEnemy.dropEnemyWeapon(currentRoom);
                }
            }
            return currentWeapon.attack();

        } else
            return AttackEnum.NO_WEAPON_EQUIPPED;
    }

    public int enemyHealth() {
        return currentRoom.findEnemyInRoom().getEnemyHealth();
    }

    public int enemyDamage() {
        return currentRoom.findEnemyInRoom().enemyAttack();
    }

    public int getAmmunition() {
        return currentWeapon.getAmmunition();
    }

    public Item getCurrentWeapon() {
        return currentWeapon;
    }

    public Item findInventoryItems(String name) {
        for (Item i : inventory) {
            if (i.getItemName().contains(name)) {
                return i;
            }
        }
        return null;
    }

    public void addFoundItemToInventory(Item item) {
        inventory.add(item);
    }

    public void removeItemFromInventory(Item itemName){
        inventory.remove(itemName);
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public int getPlayerHealth() {
        return playerHealth;
    }

    public int getFoodHealth(Food food) {
        return food.getHealthPoints();
    }

    public void takePlayerHealth(int health) {
        playerHealth -= health;
    }

    public void updatePlayerHealth(int healthPoints) {
        playerHealth += healthPoints;
        playerHealth = Integer.min(playerHealth, 100);
    }

    public String playerHealthDescription (int playerHealth) {
        String healthMsg = "";
        if (playerHealth > -100 && playerHealth <= 10) {
            healthMsg = "You are in critical condition and will die soon! Find food now!";
        } else if (playerHealth <= 20) {
            healthMsg = "Your health is very low! Do not engaged in battle!";
        } else if (playerHealth <= 30) {
            healthMsg = "You are in okay condition, but avoid battle";
        } else if (playerHealth <= 40) {
            healthMsg = "You are in great condition! But could be better. Find more food!";
        } else if (playerHealth <= 50) {
            healthMsg = "You are in very good condition!";
        }
        return healthMsg;
    }


    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public String descriptionOfRoom() {
        return currentRoom.getDescriptionOfRoom();
    }

    public String nameOfRoom() {
        return currentRoom.getNameOfRoom();
    }


    public boolean move(char direction) {
        Room requestedRoom = null;
        if(direction == 'n') {
            requestedRoom = currentRoom.getNorth();
        } else if (direction == 's') {
            requestedRoom = currentRoom.getSouth();
        } else if (direction == 'e') {
            requestedRoom = currentRoom.getEast();
        } else if (direction == 'w') {
            requestedRoom = currentRoom.getWest();
        }

        if(requestedRoom != null) {
            currentRoom = requestedRoom;
            return true;
        } else {
            return false;
        }
    }
}