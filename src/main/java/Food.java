public class Food extends Item {

    private int healthPoint;


    public Food(String name, String Description, int healthPoint){
        super(Description,name);
        this.healthPoint = healthPoint;
    }

    public int getHealthPoint() {
        return healthPoint;
    }

    public int setHealthPoint(){
        return healthPoint;
    }




    @Override
    public String toString() {
        return "items in the room;" + " " + getItemName()  + " " + getItemDescription() + " "+  " healthpoint: " + healthPoint;
    }
}

