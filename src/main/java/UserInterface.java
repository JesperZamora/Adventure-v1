import java.util.Scanner;

public class UserInterface {
    private Scanner input;
    private Adventure adventure;
    private String userChoice, takeItem, dropItem, eatItem, equipWeapon;
    private boolean isPossible, isPossibleToTakeItem, isPossibleToDropItem,
            isPossibleToEatItem, isPossibleToEquipWeapon, isPossibleToAttack;

    public UserInterface(Adventure a) {
        input = new Scanner(System.in);
        adventure = a;
    }

    public void startProgram() {
        System.out.println("\n\tWelcome to The Adventure Game!\n");
        System.out.println("----------- Gameplay Commands ----------");
        gameplayCommands();
        System.out.println("----------------------------------------\n");
        //Starting point
        System.out.println("You are now in " + adventure.roomNumber());
        System.out.println(adventure.look());

        userChoice = "";
        while (!userChoice.equals("exit")) {
            userChoice = input.nextLine();
            userChoice = userChoice.toLowerCase();
            userCommands(userChoice);
        }
    }

    public void userCommands(String userChoice) {
        switch (userChoice) {
            case "go north", "north", "n":
                System.out.println("Going north...");
                isPossible = adventure.goNorth();
                checkIsPossible(isPossible);
                break;
            case "go south", "south", "s":
                System.out.println("Going south...");
                isPossible = adventure.goSouth();
                checkIsPossible(isPossible);
                break;
            case "go east", "east", "e":
                System.out.println("Going east...");
                isPossible = adventure.goEast();;
                checkIsPossible(isPossible);
                break;
            case "go west", "west", "w":
                System.out.println("Going west...");
                isPossible = adventure.goWest();
                checkIsPossible(isPossible);
                break;
            case "look", "l":
                System.out.println("Looking around...");
                System.out.println(adventure.look());
                System.out.println("Found: " + adventure.currentRoomGetItems());
                break;
            case "take", "t":
                System.out.println("Do you want to take an item?");
                takeItem = input.nextLine();
                isPossibleToTakeItem = adventure.takeItem(takeItem);
                checkIsPossibleToTakeItem(isPossibleToTakeItem);
                break;
            case "drop", "d":
                System.out.println("Which item do you want to drop?");
                dropItem = input.nextLine();
                isPossibleToDropItem = adventure.dropItem(dropItem);
                checkIsPossibleToDropItem(isPossibleToDropItem);
                break;
            case "eat":
                System.out.println("Which food do you want to eat?");
                eatItem = input.nextLine();
                isPossibleToEatItem = adventure.eatItem(eatItem);
                checkIsPossibleToEatItem(isPossibleToEatItem);
                break;
            case "inventory", "i":
                System.out.println("Your inventory contains...");
                System.out.println(adventure.getInventory());
                System.out.println(adventure.getCurrentWeapon());
                break;
            case "health", "hp":
                System.out.println("Your current health: " + adventure.getHealth());
                break;
            case "equip":
                System.out.println("Which weapon do want to equip?");
                equipWeapon = input.nextLine();
                isPossibleToEquipWeapon = adventure.equipItem(equipWeapon);
                checkIsPossibleToEquipWeapon(isPossibleToEquipWeapon);
                break;
            case "attack":
                isPossibleToAttack = adventure.attack();
                checkIsPossibleToAttack();
                break;
            case "help", "h":
                gameplayCommands();
                break;
            case "exit":
                System.out.println("Exiting game. Goodbye!");
                int exit = 0;
                System.exit(exit);
            default:
                System.out.println("Invalid command! Try again");
        }
    }

    public void checkIsPossible(boolean isPossible) {
        if (isPossible) {
            System.out.println("You are now in " + adventure.roomNumber());
            System.out.println(adventure.look());
        } else {
            System.out.println("You can not go that way!");
        }
    }

    public void checkIsPossibleToTakeItem(boolean isPossibleToTakeItem) {
        if (isPossibleToTakeItem) {
            System.out.println(takeItem + " added to your inventory!");
        } else {
            System.out.println("There is no such item to take around here");
        }
    }

    public void checkIsPossibleToDropItem(boolean isPossibleToDropItem) {
        if (isPossibleToDropItem) {
            System.out.println(dropItem + " dropped in " + adventure.roomNumber());
        } else {
            System.out.println("You do not have that item!");
        }
    }

    public void checkIsPossibleToEatItem(boolean isPossibleToEatItem) {
        if(isPossibleToEatItem) {
            System.out.println("You have eaten " + eatItem + " and your health is now " + adventure.getHealth());
        } else {
            System.out.println("You can not eat that");
        }
    }

    public void checkIsPossibleToAttack() {
        if (isPossibleToAttack) {
            System.out.println("You have attacked!");
        } else {
            System.out.println("You can not attack!");
        }
    }

    public void checkIsPossibleToEquipWeapon(boolean isPossibleToEquipWeapon) {
        if (isPossibleToEquipWeapon) {
            System.out.println("You have equipped " + equipWeapon);
        }
    }

    public void gameplayCommands() {
        System.out.println("""
                Movement commands:
                "Go North"   (N) - move north
                "Go South"   (S) - move south
                "Go East"    (E) - move east
                "Go West     (W) - move west
                                
                In-game commands:
                "Look"       (L) - to look around
                "Health"     (HP) - show your health
                "Take"       (T) - take an item
                "Drop"       (D) - drop item
                "Eat"            - eat food
                "Inventory"  (I) - show inventory
                                
                Other commands:
                "Help"       (H) - list of commands
                "Exit"           - exit gameplay
                """);
    }

}