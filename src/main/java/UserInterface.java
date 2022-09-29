import java.util.Scanner;

public class UserInterface {
    private Scanner input;
    private Adventure adventure;
    private String userChoiceDirection;
    private boolean isPossible;

    public UserInterface() {
        input = new Scanner(System.in);
        adventure = new Adventure();
    }

    public void startProgram() {
        System.out.println("Welcome to The Adventure Game!\n");
        System.out.println("""
                ----- Menu -----
                1. Start playing
                2. Exit game""");

        int userChoice = input.nextInt();
        input.nextLine();
        userMenuChoice(userChoice);
    }

    public void userMenuChoice(int userChoice) {
        switch(userChoice){
            case 1:
                userInstuctions();
                break;
            case 2:
                System.out.println("Exiting game. Goodbye!");
                break;
            default:
                System.out.println("Wrong choice! Try again.");
        }
    }

    public void userInstuctions() {
        System.out.println("\n---------- Gameplay Instructions ---------");
        System.out.println("""
                Listen up! We have few instructions for you before we begin.
                To go through the rooms you have to choose a direction.
                Step 1. You have four choices you can go: North, South, East and West.
                Step 2. If you want to look around just type: Look.
                Step 3. If you forget Step 1. type: Help.
                Step 4. If you are a quitter type: Exit.
                We wish you good luck on your journey!""");

        System.out.println("\n> You are now in " + adventure.getPlayer().roomNumber());
        System.out.println(adventure.getPlayer().look());

        while (userChoiceDirection != "exit") {
            System.out.println("\nChoose a direction or take a look around");

            userChoiceDirection = input.nextLine();
            userChoiceDirection = userChoiceDirection.toLowerCase();
            if (userChoiceDirection.contains("north"))
                userChoiceDirection = "north";
            else if (userChoiceDirection.contains("south"))
                userChoiceDirection = "south";
            else if (userChoiceDirection.contains("east"))
                userChoiceDirection = "east";
            else if (userChoiceDirection.contains("west"))
                userChoiceDirection = "west";
            userCommands(userChoiceDirection);
        }

    }

    public void userCommands(String userChoiceDirection) {
        switch(userChoiceDirection) {
            case "north":
                isPossible = adventure.getPlayer().goNorth();
                checkIsPossible(isPossible);
                break;
            case "south":
                isPossible = adventure.getPlayer().goSouth();
                checkIsPossible(isPossible);
                break;
            case "east":
                isPossible = adventure.getPlayer().goEast();
                checkIsPossible(isPossible);
                break;
            case "west":
                isPossible = adventure.getPlayer().goWest();
                checkIsPossible(isPossible);
                break;
            case "look":
                System.out.println("> Looking around...");
                System.out.println(adventure.getPlayer().look());
                break;
            case "exit":
                startProgram();
            default:
                System.out.println("> Invalid direction! Try again");
        }
    }

    public void checkIsPossible(boolean isPossible) {
        if (isPossible) {
            System.out.println("> You are going " + userChoiceDirection + "...");
            System.out.println("> You are now in " + adventure.getPlayer().roomNumber());
            System.out.println(adventure.getPlayer().look());
        } else {
            System.out.println("> You can not go that way!");
        }
    }
}