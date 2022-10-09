public class MeleeWeapon extends Weapon {
    public MeleeWeapon(String itemName, String itemDescription) {
        super(itemName, itemDescription);
    }

    @Override
    public AttackEnum attack() {
        return AttackEnum.MELEE;
    }
}
