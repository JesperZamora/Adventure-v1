public class Enemy {
    private String enemyName;
    private String enemyDescription;
    private int enemyHealth;
    private Weapon enemyCurrentWeapon;


    Enemy(String enemyName, String enemyDescription, int enemyHealth, Weapon enemyCurrentWeapon) {
        this.enemyName = enemyName;
        this.enemyDescription = enemyDescription;
        this.enemyHealth = enemyHealth;
        this.enemyCurrentWeapon = enemyCurrentWeapon;
    }


    public String getEnemyName() {
        return enemyName;
    }

    public int getEnemyHealth() {
        return enemyHealth;
    }

    public void updateEnemyHealth (int enemyHealthDamage) {
        this.enemyHealth = enemyHealth-enemyHealthDamage;
    }

    public boolean enemyAlive() {
        if (enemyHealth > 0) {
            return true;
        } else {
            return false;
        }
    }


    public int enemyAttack() {
        return enemyCurrentWeapon.getItemDamage();
    }

    public void dropEnemyWeapon(Room currentRoom) {
        currentRoom.addEnemyItemToRoom(enemyCurrentWeapon);
    }



    public String toString() {
        return enemyName + " " + enemyDescription + "\nHP: " + enemyHealth + "\nAtk weapon: " + enemyCurrentWeapon;
    }
}
