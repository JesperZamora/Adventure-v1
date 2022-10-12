public abstract class Weapon extends Item{
    private int itemDamage;

    public Weapon(String itemName, String itemDescription, int itemDamage) {
        super(itemName, itemDescription);
        this.itemDamage = itemDamage;
    }

    public abstract AttackEnum attack();

    public abstract int getAmmunition();

    public int getItemDamage() {
        return itemDamage;
    }
}