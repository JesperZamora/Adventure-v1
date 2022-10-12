public class MeleeWeapon extends Weapon {

    public MeleeWeapon(String itemName, String itemDescription, int itemDamage) {
        super(itemName, itemDescription, itemDamage);

    }

    @Override
    public AttackEnum attack() {
        return AttackEnum.FIRED;
    }

    @Override
    public int getAmmunition() {
        return 0;
    }

}
