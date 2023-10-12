public class RangedWeapon extends Weapon {

    public int ammunition;
    int canUse;

    public RangedWeapon(String Name, String itemDescription, int ammunition, int canUse) {
        super(Name, itemDescription);
        this.ammunition = ammunition;
        this.canUse = canUse;
    }


    public void setAmmunition(){
        this.ammunition = ammunition;
    }


    public int getAmmunition() {
        return ammunition;
    }

    public void setCanUse(int canUse) {
        this.canUse = canUse;
    }

    public int getCanUse() {
        return canUse;
    }

    @Override
    public String toString() {
        return "\n" + "Ranged Weapon:" + " " + getItemName() + "." + "\n" +
                "Ammunition" + " " + "=" + " " + " " + ammunition +
                ", Use left:" + " " + "=" + " " + canUse +
                '.';
    }
}
