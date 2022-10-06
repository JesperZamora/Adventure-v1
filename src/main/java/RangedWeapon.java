public class RangedWeapon extends Weapon {
    private int ammunition;
    public RangedWeapon(String itemName, String itemDescription, int ammunition) {
        super(itemName, itemDescription);
        this.ammunition = ammunition;
    }
}
