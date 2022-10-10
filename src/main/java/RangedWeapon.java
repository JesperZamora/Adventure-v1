public class RangedWeapon extends Weapon {
    private int ammunition;
    public RangedWeapon(String itemName, String itemDescription, int ammunition) {
        super(itemName, itemDescription);
        this.ammunition = ammunition;
    }
    @Override
    public AttackEnum attack() {
        if(ammunition> 0) {
            ammunition--;
            return AttackEnum.FIRED;
        } else
            return AttackEnum.NO_AMMO;
    }

    @Override
    public int ammunitionCount() {
        return ammunition;
    }

    @Override
    public String toString() {
        return super.toString() + " [Ammo: " + ammunition + "]";
    }
}
