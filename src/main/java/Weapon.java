public abstract class Weapon extends Item {

    protected int damage;
    protected int canUse;

    public Weapon(String itemName, String itemDescription) {
        super(itemName, itemDescription);
    }
    public int getCanUse() {
       return canUse;
    }

    public int getDamage() {
        return damage;
    }

    public int getCanuse() {
        return canUse;
    }




}
