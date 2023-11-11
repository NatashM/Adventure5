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
                "\n"+ "Melee weapon:" + " " + getItemName() +
                        "\n" + "Damage" + " " + "=" + " " + damage;

    }

}
