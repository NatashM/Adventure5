public class Enemy {


    private String enemyName;
    private int enemyhealth;
    private Weapon enemyWeapon;
    private Room currentRoom;


    public Enemy(String enemyName,int enemyhealth,Weapon enemyWeapon, Room currentRoom) {
        this.enemyName = enemyName;
        this.enemyhealth = enemyhealth;
        this.enemyWeapon = enemyWeapon;
        this.currentRoom = currentRoom;
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

    public boolean Dead() {
        if (enemyhealth <= 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "\n" + "Enemy:" +
                " " + enemyName + '\'' +
                "enemy health" + "=" + enemyhealth ;
    }




}
