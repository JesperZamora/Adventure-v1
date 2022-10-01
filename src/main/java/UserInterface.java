import java.util.Scanner;

public class UserInterface {
    private Scanner input;
    private Adventure adventure;
    private String userChoice;
    private boolean isPossible;

    public UserInterface() {
        input = new Scanner(System.in);
        adventure = new Adventure();
    }

    public void startProgram() {
        System.out.println("\n\tWelcome to The Adventure Game!\n");
        System.out.println("----------- Gameplay Commands ----------");
        gameplayCommands();
        System.out.println("Type your first command and press ENTER!");

        userChoice = "";
        while (!userChoice.equals("exit")) {
            userChoice = input.nextLine();
            userChoice = userChoice.toLowerCase();
            userCommands(userChoice);
        }
    }

    public void userCommands(String userChoice) {
        switch(userChoice) {
            case "go north", "north", "n":
                System.out.println("> Going north...");
                isPossible = adventure.getPlayer().goNorth();
                checkIsPossible(isPossible);
                break;
            case "go south", "south", "s":
                System.out.println("> Going south...");
                isPossible = adventure.getPlayer().goSouth();
                checkIsPossible(isPossible);
                break;
            case "go east", "east", "e":
                System.out.println("> Going east...");
                isPossible = adventure.getPlayer().goEast();
                checkIsPossible(isPossible);
                break;
            case "go west", "west", "w":
                System.out.println("> Going west...");
                isPossible = adventure.getPlayer().goWest();
                checkIsPossible(isPossible);
                break;
            case "look", "l":
                System.out.println("> Looking around...");
                System.out.println(adventure.getPlayer().look());
                System.out.println(adventure.getPlayer().lookForItems());
                break;
            case "help", "h":
                gameplayCommands();
                break;
            case "exit":
                startProgram();
            default:
                System.out.println("> Invalid command! Try again");
        }
    }

    public void checkIsPossible(boolean isPossible) {
        if (isPossible) {
            System.out.println("> You are now in " + adventure.getPlayer().roomNumber());
            System.out.println("> " + adventure.getPlayer().look());
        } else {
            System.out.println("> You can not go that way!");
        }
    }


    public void gameplayCommands(){
        System.out.println("""
                Movement commands:
                "Go North"   (N) - move north
                "Go South"   (S) - move south
                "Go East"    (E) - move east
                "Go West     (W) - move west
                
                In-game commands:
                "Look"       (L) - to look arounds
                "Take"       (T) - take an item
                "Drop"       (D) - drop item
                "Inventory"  (I) - show inventory
                
                Other commands:
                "Help"       (H) - list of commands
                "Exit"           - exit gameplay
                """);
    }

}