public class RangedWeapon extends Weapon {
    private int ammunition;
    public RangedWeapon(String itemName, String itemDescription, int ammunition) {
        super(itemName, itemDescription);
        this.ammunition = ammunition;
    }

    public int getAmmunition() {
        return ammunition;
    }

    public void setAmmunition(int leftAmmunition) {
        ammunition = leftAmmunition;
    }

    @Override
    public String toString() {
        return super.toString() + " ammo " + ammunition;
    }
}
