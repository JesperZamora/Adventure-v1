public class Map {
    private Room starterRoom;

    public Map() {
        Room room1 = new Room("Room 1", "There is nothing but two doors");
        Room room2 = new Room("Room 2", "There is very dark in the room but there is one door");
        Room room3 = new Room("Room 3", "There are paintings on the wall and one door");
        Room room4 = new Room("Room 4", "There is nothing in the room but one door");
        Room room5 = new Room("Room 5", "There is a chest");
        Room room6 = new Room("Room 6", "There is nothing but a door");
        Room room7 = new Room("Room 7", "Nothing but on door");
        Room room8 = new Room("Room 8", "There is a panda and two doors");
        Room room9 = new Room("Room 9", "There is another panda");

        room1.addItem("lamp");
        room2.addItem("oil");
        room2.addItem("lighter");
        room3.addItem("key");
        room3.addItem("wick");
        room3.addItem("key");
        room5.addItem("chest");
        room9.addItem("sword");
        room7.addItem("shield");

        room1.setEast(room2);
        room1.setSouth(room4);
        room4.setNorth(room1);
        room2.setWest(room1);
        room2.setEast(room3);
        room3.setWest(room2);
        room3.setSouth(room6);
        room6.setNorth(room3);
        room6.setSouth(room9);
        room9.setNorth(room6);
        room9.setWest(room8);
        room8.setEast(room9);
        room8.setNorth(room5);
        room5.setSouth(room8);
        room8.setWest(room7);
        room7.setEast(room8);
        room7.setNorth(room4);
        room4.setSouth(room7);

        starterRoom = room1;

    }

    public Room getStarterRoom() {
        return starterRoom;
    }


}
