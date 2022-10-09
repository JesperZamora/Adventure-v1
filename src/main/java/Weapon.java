public abstract class Weapon extends Item{

    public Weapon(String itemName, String itemDescription) {
        super(itemName, itemDescription);
    }

    public abstract AttackEnum attack();

    public abstract int ammunitionCount();
}
