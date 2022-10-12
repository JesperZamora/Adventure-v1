public class RangedWeapon extends Weapon{
    private int ammunition;

    public RangedWeapon(String itemName, String itemDescription, int ammunition, int itemDamage) {
        super(itemName, itemDescription, itemDamage);
        this.ammunition = ammunition;
    }

    @Override
    public AttackEnum attack() {
        if (ammunition > 0) {
            ammunition -= 1;
            return AttackEnum.FIRED;
        } else
            return AttackEnum.NO_AMMO;
    }

    public int getAmmunition() {
        return ammunition;
    }


    @Override
    public String toString() {
        return super.toString() + " ammo count: " + ammunition;
    }
}