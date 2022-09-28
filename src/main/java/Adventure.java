public class Adventure {
    private  Map map;
    private Player player;


    public Adventure() {
        map = new Map();
        player = new Player();
        player.setCurrentRoom(map.getStarterRoom());
    }


    public boolean goSouth() {
        if (player.getCurrentRoom().getSouth() != null) {
            player.setCurrentRoom(player.getCurrentRoom().getSouth());
            return true;
        }
        else {
            return false;
        }
    }

    public boolean goEast() {
        if (player.getCurrentRoom().getEast() != null) {
            player.setCurrentRoom(player.getCurrentRoom().getEast());
            return true;
        }
        else {
            return false;
        }
    }

    public boolean goNorth() {
        if (currentRoom.getNorth() != null) {
            currentRoom = currentRoom.getNorth();
            return true;
        }
        else {
            return false;
        }
    }

    public boolean goWest() {
        if (currentRoom.getWest() != null) {
            currentRoom = currentRoom.getWest();
            return true;
        }
        else {
            return false;
        }
    }

    public String look(){
        return currentRoom.getDescriptionOfRoom();
    }

    public String getRoomNumber() {
        return currentRoom.getNameOfRoom();
    }
}
