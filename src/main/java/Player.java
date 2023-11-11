import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    Scanner keyboard = new Scanner(System.in);

    private Room currentRoom;

    private RangedWeapon rangedWeapon;

    private Weapon currentWeapon;

    private int healthPoint;

    private int ammunition;

    private int canUse;

    private int damage;

    private int health;

    private final ArrayList<Item> inventory;

    private final ArrayList<Enemy> enemies = new ArrayList<>();

    ArrayList<Item> Inventory = getInventory();

    public Player(Room currentRoom) {
        this.currentRoom = currentRoom;
        this.inventory = new ArrayList<>();
        this.healthPoint = 50;

    }

    public void setCurrentWeapon(Weapon currentWeapon) {
        this.currentWeapon = currentWeapon;
    }

    public Weapon getCurrentWeapon() {
        return currentWeapon;
    }

    public int getHealthPoint() {
        return healthPoint;
    }
    public int getAmmunition() {
        return ammunition;
    }

    public int getCanUse() {
        return canUse;
    }

    public int getDamage() {
        return damage;
    }
    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public String getCurrentRoomDescription() {
        return currentRoom.getRoomDescription();
    }


    public boolean takeItem(Item items) {
        return inventory.add(items);
    }

    public void dropItem(Item items) {
        inventory.remove(items);
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public ArrayList<Enemy> getEnemies(){
        return enemies;
    }


    public void viewInventory() {
        if (inventory.isEmpty()) {
            System.out.println("There is no item in your inventory..");
        } else {
            System.out.println("Inventory:");
            for (Item item : inventory) {
                System.out.println("Your items" + item);
            }
        }

    }

    public boolean takeItem(String itemName) {
        Item item = FindItemInRoom(itemName);
        if (item != null) {
            inventory.add(item);
            System.out.println("You took: "+ item);
            currentRoom.removeItem(itemName);
            return true;
            }
        else
            System.out.println("You already have a weapon");
        return false;
    }

    public void viewListOfEnemy(){
        ArrayList<Enemy> enemies = currentRoom.getEnemies();

        if(enemies.isEmpty()) {
            System.out.println("You are safe,there is no enemies here!.");
        }else {
            System.out.println("The enemies in this room are:");
            for(Enemy enemy : enemies){
                System.out.println(enemy);
            }
        }
    }

    public Enemy FindEnemyInRoom(String enemyName) {
        for (Enemy enemy : currentRoom.getEnemies()) {

            if (enemy.getEnemyName().equalsIgnoreCase(enemyName)) {
                return enemy;
            }
        }
        return null;
    }

    public void dropItem(String itemName) {
        Item item = FindItem(itemName);
        for (Item items : inventory) {
            if (!inventory.isEmpty()) {
                inventory.remove(items);

            }
        }
        if (item != null) {
            dropItem(itemName);
            currentRoom.addItem(item);
            System.out.println("You have drop:" + itemName);
        }

    }

    public Item FindItem(String itemName) {

        for (Item item : inventory) {
            if (item.getItemName().equalsIgnoreCase(itemName)) {
                if(item instanceof Weapon)
                    return (Weapon)item;
                 else {
                     return item;
            }}
        }
        return null;
    }


    public Item FindItemInRoom(String itemName) {
        for (Item item : currentRoom.getItems()) {

            if (item.getItemName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }

    public EatEnum eatFood(String itemName) {
        Item eatItem = FindItem(itemName);
        if (eatItem == null) {
            return EatEnum.FOOD_NOT_FOUND;
        } else if (eatItem instanceof Food) {
            int foodPlayerHealthPoint = ((Food) eatItem).getHealthPoint();
            setPlayerHealthPoint(foodPlayerHealthPoint);
            inventory.remove(eatItem);
            return EatEnum.FOOD_FOUND;
        } else {
            return EatEnum.FOOD_NOT_EDIBLE;
        }

    }

    public AttackEnum equip(String weaponName) {
        Item equipItem = FindItem(weaponName);
        if (equipItem == null) {
            return AttackEnum.WEAPON_NOT_FOUND;
        } else if (equipItem instanceof Weapon) {
            setCurrentWeapon((Weapon) equipItem);
            return AttackEnum.WEAPON_EQUIP;
        } else {
            return AttackEnum.WEAPON_NOT_EQUIP;
        }

    }




    public void setPlayerHealthPoint(int PlayerHealthPoint) {
        this.healthPoint = PlayerHealthPoint;

        if (healthPoint > 50) {
            this.healthPoint = 50;
        }
    }

    public void reduceHealth(int damage) {
        health -= damage;
        if (health < 0) {
            health = 0;
        }
    }


    public String healthLevelPoints() {

        String healthLevelPoints = keyboard.nextLine();

        if (healthPoint > 0 && healthPoint <= 10) {
            return healthLevelPoints = "ohh hurry you are very low on health points.";
        } else if (healthPoint > 10 && healthPoint <= 15) {
            return healthLevelPoints = "Your are in real bad shape, try to get some health points";
        } else {
            return "Your health level points are:" + healthPoint;
        }


    }

    public AttackEnum attack(Enemy enemy) {
        Attack attack = new Attack(this);
        return attack.attack(enemy);
    }

    public String move(String direction) {

        Room nextRoom = null;
        switch (direction) {
            case "n", "north", "go north":
                nextRoom = currentRoom.getNorth();
                break;
            case "s", "south", "go south":
                nextRoom = currentRoom.getSouth();
                break;
            case "e", "east", "go east":
                nextRoom = currentRoom.getEast();
                break;
            case "w", "west", "go west":
                nextRoom = currentRoom.getWest();
                break;
        }
        //opdater current room
        if (nextRoom != null) {
            currentRoom = nextRoom;
            return currentRoom.getRoomDescription();
        } else {
            return "You have chosen a path that leads nowhere. Try a different path.";
        }
    }
}




