public class Map {
    private Room starterRoom;

    public Map() {
        Room room1 = new Room("Room 1", "There is nothing but two doors");
        Room room2 = new Room("Room 2", "There is very dark in the room but there is one door");
        Room room3 = new Room("Room 3", "There are paintings on the wall and one door");
        Room room4 = new Room("Room 4", "There is nothing in the room but one door");
        Room room5 = new Room("Room 5", "There is a chest");
        Room room6 = new Room("Room 6", "There is nothing but a door");
        Room room7 = new Room("Room 7", "Nothing but a door");
        Room room8 = new Room("Room 8", "There is a panda and two doors");
        Room room9 = new Room("Room 9", "There is another panda");

        // Items
        room1.addItem("lamp", "looks old");
        room2.addItem("oil", "loks greasy");
        room2.addItem("lighter", "stil works");
        room3.addItem("key", "looks rusty");
        room3.addItem("wick", "is nearly burned out");
        room3.addItem("cloth", "is dirty");
        room5.addItem("chest", "looks ancient");
        room9.addItem("sword", "is not that sharp, but looks pointy");
        room7.addItem("shield", "looks shiny and royal");

        // Food items
        room1.addFood("apple", "looks juicy", 20);
        room2.addFood("rat", "looks nasty", -75);
        room3.addFood("milk", "looks old", -10);
        room4.addFood("banana", "looks fresh", 25);
        room5.addFood("durum", "looks good", 75);
        room7.addFood("fish", "smells a bit", -50);

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
        room1.addRangedWeapon("bazooka", "huge Bazooka", 2);
        room3.addMeleeWeapon("knife", "long sharp knife");
        room5.addRangedWeapon("ak-47", "straight from russia", 10);
        room6.addMeleeWeapon("shoe", "size 46");
        room9.addRangedWeapon("pistol", " old desert eagle", 5);
    }

    public Room getStarterRoom() {
        return starterRoom;
    }


}
