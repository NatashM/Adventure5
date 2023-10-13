public class Food extends Item {

    private int healthPoint;


    public Food(String name, String Description, int healthPoint){
        super(name,Description);
        this.healthPoint = healthPoint;
        setHealthPoint();
    }

    public int getHealthPoint() {
        return healthPoint;
    }

    public int setHealthPoint(){
        return healthPoint;
    }


    @Override
    public String toString() {
        return "The food in this room:" + " " + getItemName()+
                "\n"  + " "+  " healthpoint: " + healthPoint;
    }
}

