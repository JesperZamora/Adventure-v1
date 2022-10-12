public class Main {
    public static void main(String[] args) {
        runGame();
    }

    public static void runGame() {
        Adventure adventure = new Adventure();
        UserInterface ui = new UserInterface(adventure);
        ui.startProgram();
    }
}
