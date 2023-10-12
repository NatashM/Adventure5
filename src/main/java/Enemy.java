public class Enemy {


    private String enemyName;
    private int enemyhealth;
    private Weapon enemyWeapon;
    private Room currentRoom;
    private int damage;



    public Enemy(String enemyName,int enemyhealth,Weapon enemyWeapon, Room currentRoom) {
        this.enemyName = enemyName;
        this.enemyhealth = enemyhealth;
        this.enemyWeapon = enemyWeapon;
        this.currentRoom = currentRoom;
    }

    public int getDamage() {
        return damage;
    }

    public String getEnemyName() {
        return enemyName;
    }

    public int getEnemyhealth() {
        return enemyhealth;
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

    public void setEnemyhealth(int enemyhealth) {
        this.enemyhealth = enemyhealth;
    }

    public void setEnemyWeapon(Weapon enemyWeapon) {
        this.enemyWeapon = enemyWeapon;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }



    public void reduceHealth(int damage) {
       enemyhealth -= damage;
        if (enemyhealth < 0) {
            enemyhealth= 0;
        }
    }



    @Override
    public String toString() {
        return "\n" + "Enemy:" +
                " " + enemyName + '\'' +
                "enemy health" + "=" + enemyhealth ;
    }




}
