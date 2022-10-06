import java.util.ArrayList;

public class Player {
    private Room currentRoom;
    private Item currentWeapon;
    private ArrayList<Item> inventory = new ArrayList<>();
    private int playerHealth = 100;

    public boolean takeItemInRoom(String itemName) {
        Item takeItem = currentRoom.findRoomItems(itemName);
        if (takeItem != null) {
            addItemtoInventory(takeItem);
            currentRoom.getItems().remove(takeItem);
            return true;
        } else {
            return false;
        }
    }

    public boolean dropItemInRoom(String itemName) {
        Item dropItem = findInventoryItems(itemName);
        if (dropItem != null) {
            currentRoom.getItems().add(dropItem);
            inventory.remove(dropItem);
            return true;
        } else {
            return false;
        }
    }

    public boolean equipWeapon(String weaponName) {
        Item equipWeapon = findInventoryItems(weaponName);
        if (equipWeapon != null) {
            if (equipWeapon instanceof Weapon) {
                currentWeapon = equipWeapon;
                inventory.remove(equipWeapon);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean attack() {
        if (currentWeapon != null) {
            if (currentWeapon instanceof RangedWeapon) {
                if(((RangedWeapon) currentWeapon).getAmmunition()> 0) {
                    ((RangedWeapon) currentWeapon).setAmmunition(((RangedWeapon) currentWeapon).getAmmunition()-1);
                    return true;
                } else {
                    return false;
                }
            } else return false;
        } else return false;
    }




    public Item findInventoryItems(String name) {
        for (Item i : inventory) {
            if (i.getItemName().contains(name)) {
                return i;
            }
        }
        return null;
    }

    public int getFoodHealth(Food food) {
        return food.getHealthPoints();
    }

    public int updatePlayerHealth(int healthPoints) {
        playerHealth += healthPoints;
        playerHealth = Integer.min(playerHealth, 100);
        return playerHealth;
    }

    public int getPlayerHealth() {
        return playerHealth;
    }

    public boolean eatItem(String foodName) {
        Item foodItem = findInventoryItems(foodName);
        if (foodItem != null) {
            if (foodItem instanceof Food) {
                updatePlayerHealth(getFoodHealth((Food) foodItem));
                inventory.remove(foodItem);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public void addItemtoInventory(Item item) {
        inventory.add(item);
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public Item getCurrentWeapon() {
            return currentWeapon;
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