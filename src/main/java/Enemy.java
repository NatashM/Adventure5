public class Enemy {


    private String enemyName;
    private int enemyHealth;
    private Weapon enemyWeapon;
    private Room currentRoom;
    private int damage;


    public Enemy(String enemyName,int enemyHealth,Weapon enemyWeapon, Room currentRoom) {
        this.enemyName = enemyName;
        this.enemyHealth = enemyHealth;
        this.enemyWeapon = enemyWeapon;
        this.currentRoom = currentRoom;
    }

    public int getDamage() {
        return damage;
    }

    public String getEnemyName() {
        return enemyName;
    }

    public int getEnemyHealth() {
        return enemyHealth;
    }

    public Weapon getEnemyWeapon() {
        return enemyWeapon;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setEnemyName(String enemyName) {
        this.enemyName = enemyName;
    }

    public void setEnemyHealth(int enemyHealth) {
        this.enemyHealth = enemyHealth;
    }

    public void setEnemyWeapon(Weapon enemyWeapon) {
        this.enemyWeapon = enemyWeapon;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }



    public void reduceHealth(int damage) {
       enemyHealth -= damage;
        if (enemyHealth < 0) {
            enemyHealth= 0;
        }
    }



    @Override
    public String toString() {
        return "\n" + "Enemy:" +
                " " + enemyName + '\'' +
                "enemy health" + "=" + enemyHealth ;
    }




}
