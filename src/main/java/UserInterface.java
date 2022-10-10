import java.util.Scanner;

public class UserInterface {
    private Scanner input;
    private Adventure adventure;

    public UserInterface(Adventure a) {
        input = new Scanner(System.in);
        adventure = a;
    }

    public void startProgram() {
        System.out.println("\n\tWelcome to The Adventure Game!\n");
        System.out.println("----------- Gameplay Commands ----------");
        System.out.println(adventure.gameplayCommands());
        System.out.println("----------------------------------------\n");

        System.out.println("You start in " + adventure.currentRoom());
        System.out.println("Take a look around and choose a direction!");

        userCommands();
    }

    public void userCommands() {
        String userChoice = "";
        while(!userChoice.equals("exit")) {

            userChoice = input.nextLine();
            userChoice = userChoice.toLowerCase();
            String[] userInput = userChoice.split(" ");
            String command = userInput[0];
            String userCommand = "";
            if (userInput.length > 1) {
                userCommand = userInput[1];
            }

            switch (command) {
                case "go":
                    boolean canGo = adventure.go(userCommand);
                    if (canGo) {
                        System.out.println("You have gone " + userCommand);
                    } else {
                        System.out.println("You can not go that way!");
                    }
                    break;

                case "take","t":
                    boolean canTakeItem = adventure.takeItem(userCommand);
                    if(canTakeItem) {
                        System.out.println("You have taken " + userCommand + "!");
                    } else {
                        System.out.println("There is no such item to be taken");
                    }
                    break;

                case "drop", "d":
                    boolean canDropItem = adventure.dropItem(userCommand);
                    if(canDropItem) {
                        System.out.println("You have dropped " + userCommand + "!");
                    } else {
                        System.out.println("You have no such item to drop!");
                    }
                    break;

                case "eat", "e":
                    boolean canEatFood = adventure.eatItem(userCommand);
                    if(canEatFood) {
                        System.out.println("You have eaten " + userCommand + "!");
                    } else {
                        System.out.println("You can not eat that!");
                    }
                    break;

                case "equip", "eq":
                    WeaponEnum isWeapon = adventure.equipItem(userCommand);
                    switch (isWeapon) {
                        case WEAPON:
                            System.out.println("You have now equipped " + userCommand + "!");
                            break;
                        case NOT_FOUND:
                            System.out.println(userCommand + " not found in inventory!");
                            break;
                        case NOT_WEAPON:
                            System.out.println("This is not a weapon!");
                            break;
                    }
                    break;

                case "attack", "atk":
                    AttackEnum attack = adventure.attackWithWeapon();
                    switch (attack) {
                        case FIRED:
                            System.out.println("You attacked and fired " + adventure.equippedWeapon() + "!");
                            System.out.println("Ammunition count: " + adventure.ammunitionCount());
                            break;
                        case MELEE:
                            System.out.println("You attacked and swung " + adventure.equippedWeapon() + "!");
                            break;
                        case NO_WEAPON_EQUIPPED:
                            System.out.println("You need to equip a weapon first!");
                            break;
                        case NO_AMMO:
                            System.out.println("No ammunition left!");
                            break;
                    }
                    break;

                case "look", "l":
                    System.out.println("This is " + adventure.currentRoom());
                    System.out.println("Room description: " + adventure.currentRoomDescription());
                    System.out.println("You found item(s): ");
                    for (Item i : adventure.ShowItemsInRoom()) {
                        System.out.println("> " + i);
                    }
                    break;

                case "health", "hp":
                    System.out.println("Your health points is " + adventure.playerHealth());
                    System.out.println(adventure.playerHealthDescription());
                    break;

                case "inventory", "inv":
                    System.out.println("Your inventory contains: ");
                    for (Item i : adventure.showInventory()) {
                        System.out.println("> " + i);
                    }
                    break;

                case "help", "h":
                    System.out.println(adventure.gameplayCommands());
                    break;

                case "exit":
                    System.out.println("Exiting game. Goodbye!");
                    int exit = 0;
                    System.exit(exit);
                    break;

                default:
                    System.out.println("Invalid command! Try again");
            }
        }
    }
}