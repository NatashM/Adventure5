import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    Scanner keyboard = new Scanner(System.in);
    private Room currentRoom;

    private RangedWeapon rangedWeapon;

    private Weapon currentWeapon;

    private int healthPoint;

    private int Ammunition;

    private int canUse;

    private int damage;

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
        return Ammunition;
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
            System.out.println("inventory:");
            for (Item item : inventory) {
                System.out.println("your items" + item);
            }
        }

    }

    public boolean takeItem(String itemName) {
        Item item = FindItemInRoom(itemName);
        if (item != null) {
            inventory.add(item);
            System.out.println("i takeItem: "+ item);
            currentRoom.removeItem(itemName);
            return true;
            }
        else
            System.out.println("You already have a weapon");
        return false;
    }

    public void viewEnemy(){
        Room currentRoom = this.currentRoom;
        ArrayList<Enemy> enemies = currentRoom.getEnemies();

        if(enemies.isEmpty()) {
            System.out.println("You are safe,there is no enemies.");
        }else {
            System.out.println("The enemies in this room are:");
            for(Enemy enemy : enemies){
                System.out.println(enemy);
            }
        }
    }


    public void dropItem(String itemName) {
        Item item = FindItem(itemName);
        for (Item items : inventory) {
            if (!inventory.isEmpty()) {
                inventory.remove(items);
                //item = items;
            }
        }
        if (item != null) {
            dropItem(itemName);
            currentRoom.addItem(item);
            System.out.println("you have drop" + itemName);
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


    public void attackEnemy(String attack) {
        Item item = FindItem(attack);
        if (item != null) {
            System.out.println("You have been attacked.");
        } else if (currentWeapon == null) {
            System.out.println("You dont have any weapon");
        } else if (currentWeapon instanceof RangedWeapon) {
            RangedWeapon rangedWeapon = (RangedWeapon) currentWeapon;
            if (rangedWeapon.getAmmunition() <= 0) {
                System.out.println("You have no more ammunition.");
        } else if (currentWeapon instanceof MeleeWeapon) {
            System.out.println("You are attacking with " + currentWeapon + ".");
        }
    }

    }

    public void setPlayerHealthPoint(int PlayerHealthPoint) {
        this.healthPoint = PlayerHealthPoint;

        if (healthPoint > 50) {
            this.healthPoint = 50;
        }
    }


    public String healthLevelPoints() {

        String healthLevelPoints = keyboard.nextLine();

        if (healthPoint > 0 && healthPoint <= 10) {
            return healthLevelPoints = "ohh hurry you are very very low on health points.";
        } else if (healthPoint > 10 && healthPoint <= 20) {
            return healthLevelPoints = "Your are in real bad shape, try get som health points";
        } else {
            return "Your health level points are now" + healthPoint;
        }


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
        if (nextRoom != null) {
            currentRoom = nextRoom;
            return currentRoom.getRoomDescription();
        } else {
            return "You have chosen a path that leads nowhere. Try a different path.";
        }
    }






/*
    public void showInventory(){
        ArrayList<Item> Inventory = new ArrayList<>();
    }
 Item item = FindItem(attack);
        if (item != null) {
            System.out.println("You have been attacked.");
        } else if (currentWeapon == null) {
            System.out.println("You dont have any weapon");
        } else if (currentWeapon instanceof RangedWeapon) {
            RangedWeapon rangedWeapon = (RangedWeapon) currentWeapon;
            if (rangedWeapon.getAmmunition() <= 0) {
                System.out.println("You have no more ammunition.");
        } else if (currentWeapon instanceof MeleeWeapon) {
            System.out.println("You are attacking with " + currentWeapon + ".");
        }
    }

    }

    public ArrayList<Item> getShowInventory(){
        return Inventory;
    }
    public void getInventory() {
        if (inventory != null) ;
        System.out.println(inventory);
    }

    public void drop(String itemName){
        Item item = null;
        for(Item items : inventory){
            if(items.getItemName().equalsIgnoreCase())
        }
    }

 public boolean takeItem(String itemName) {
       Item item = null;
       for (Item items : inventory){
           if(item.getItemName().equalsIgnoreCase(itemName)){
               item = items;
           }
       }
       if (item != null) {
           inventory.add(item);
           currentRoom.removeItem(itemName);
       }
       return true;
   }

    /*


     Item item = FindItem(attack);
        if (item != null) {
            System.out.println("You have been attacked");
        }
            if (rangedWeapon.getAmmunition() <= 0) {
                System.out.println("You have no more ammunition");
                }
            else {
                System.out.println("You have no weapon");
            }

    public void attackEnemy() {

        if(rangedWeapon != null) {
            if (rangedWeapon.getAmmunition() <= 0) {
                System.out.println("You have fired you weapon!");
            } else {
                System.out.println("You dont have Ammunition");
            }
        }else if (MeleeWeapon != null){
            System.out.println("You have attacked with" + getCurrentWeapon());
            } else {
            System.out.println("you dont have a weapon!");

        }


    }
        public Item getCurrentWeapon(){
            return currentWeapon;
        }

        public int enemyAttack(){
            return currentRoom.getEnemy().getEnemyHealth;
        }

        public Attack attackEnemy(){
            enemy attackEnemy = currentRoom.getEnemies().isEmty
        }

        public Attack attackNothing(String attack) {
            Item Attack = FindItem(attack);

            if (Attack == null) ;
            {
                return Attack
            }
        }

    */

}




