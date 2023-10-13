import java.util.ArrayList;

public class Adventure {
    Map map = new Map();
    Player player;

    public Adventure() {
        player = new Player(map.getCurrentRoom());
    }

    public void buildMap() {
        map.buildMap();
        player.setCurrentRoom(map.getStartingRoom());
    }

    public String getCurrentRoomDescription() {
        return player.getCurrentRoomDescription();
    }

    public String move(String direction) {
        return player.move(direction);
    }

    public String getDropItems() {
        return dropItems;
    }

    public String dropItems;

    public boolean takeItem(String itemName) {
        return player.takeItem(itemName);
    }


    public void setDropItem(String input) {
        player.dropItem(input);

    }

    public int getHealthPoints() {
        return player.getHealthPoint();
    }

    public String healthLevelPoint() {
        return player.healthLevelPoints();
    }

    public EatEnum eatFood(String food) {
        return player.eatFood(food);
    }

    public AttackEnum equip(String attack) {
        return player.equip(attack);
    }


    public ArrayList<Item> viewInventory() {
        return player.getInventory();
    }

    public ArrayList<Enemy> viewEnemy() {
        return player.getEnemies();
    }

    public Item findItem(String ItemName) {
        return player.FindItem(ItemName);
    }


    public void setCurrentWeapon(Weapon currentWeapon) {
        player.setCurrentWeapon(currentWeapon);
    }

    public Weapon getCurrentWeapon() {
        return player.getCurrentWeapon();
    }

    public int getAmmunition() {
        return player.getAmmunition();
    }

    public int getCanUse() {
        return player.getCanUse();
    }


    public int getDamage() {
        return player.getDamage();
    }

    public Player getPlayer() {
        return player;
    }

    public AttackEnum playerAttack(Enemy enemy) {
        return attack(enemy);
    }

    public AttackEnum attack(Enemy enemy) {
        return player.attack(enemy);
    }

}
