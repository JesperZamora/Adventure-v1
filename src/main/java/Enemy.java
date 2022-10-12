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

    public int getEnemyHealth() {
        return enemyHealth;
    }

    public void updateEnemyHealth (int enemyHealthDamage) {
        this.enemyHealth = enemyHealth-enemyHealthDamage;
    }

    public boolean enemyAlive() {
        return enemyHealth > 0;
    }


    public int enemyAttack() {
        return enemyCurrentWeapon.getItemDamage();
    }

    public void dropEnemyWeapon(Room currentRoom) {
        currentRoom.addEnemyItemToRoom(enemyCurrentWeapon);
    }



    public String toString() {
        return enemyName + " " + enemyDescription + "\n> HP: " + enemyHealth + "\n> Weapon: " + enemyCurrentWeapon;
    }
}
