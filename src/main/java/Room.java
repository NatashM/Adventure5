import java.util.ArrayList;

public class Room {
    private final String name;
    private final String description;
    private Room north;
    private Room south;
    private Room east;
    private Room west;

    private ArrayList<Item> items = new ArrayList<>();
    private final ArrayList<Enemy> enemies = new ArrayList<>();



    public Room(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getRoomDescription() {
        final String WHITE_BOLD = "\033[1;97m";
        final String RESET_BOLD = "\033[0m";
        String formattedName = WHITE_BOLD + name + RESET_BOLD;
        return formattedName + "\n" + description + "\n" + items + enemies;
    }


    public Room getNorth() {
        return north;
    }

    public Room getSouth() {
        return south;
    }

    public Room getEast() {
        return east;
    }

    public Room getWest() {
        return west;
    }

    public void setNorth(Room room) {
        this.north = room;
    }

    public void setSouth(Room room) {
        this.south = room;
    }

    public void setEast(Room room) {
        this.east = room;
    }

    public void setWest(Room room) {
        this.west = room;
    }

    public void addItem(Item item){
        items.add(item);
    }

    public void addFood(Item food){
        items.add(food);
    }

    public void addWepons(Item wepons){
        items.add(wepons);
    }

    public void addEnemy(Enemy addEnemy){
        enemies.add(addEnemy);
    }

    public void removeEnemy(Enemy enemy){
        enemies.remove(enemy);
    }

    public void removeItem (String itemName){
        items.remove(items);

        for (int i = 0; i < items.size() ; i++) {
            if(items.get(i).getItemName().equals(itemName)){
                items.remove(items.get(i));
            }
        }


    }

    public ArrayList<Item> getItems() {
        return items;
    }
    public ArrayList<Enemy> getEnemies(){
        return enemies;
    }

    public ArrayList<Enemy> enemies(){
        return enemies;
    }



    @Override
    public String toString() {
        return
                "You have now step into" + " " + name + " "
                        + description + " " + "\n";
    }



}

    /*



    public void removeItem (Item items){
        itemList.remove(items);
    }


    public ArrayList<Item> getItemList() {
        return itemList;
    }


}
*/
