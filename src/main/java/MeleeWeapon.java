public class MeleeWeapon extends Weapon {

    public int damage;

    public MeleeWeapon(String itemName, String itemDescription, int damage) {
        super(itemName, itemDescription);
        this.damage = damage;

    }

    public int getDamage(){
        return damage;
 }


    @Override
    public String toString() {
        return
                "\n"+ " " +"MeleeWeapon:" + " " + getItemName() +"\n " + "Damage" + " " + "=" + " " + damage + "\n"+
                '.';
    }

}
