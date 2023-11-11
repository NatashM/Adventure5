import java.util.ArrayList;

public class Map {
    public Room currentRoom;

    public void buildMap() {
        Room room1 = new Room("The Campsite : The games starts in the woods.", "Where you need to survive to win.");
        Food food1 = new Food("water","drink",20);
        RangedWeapon weapon1 = new RangedWeapon("a gun","old",40,10);
        Enemy enemy1 = new Enemy("Maleficent",50,new MeleeWeapon("magic","makes you sleep",1),room1);
        room1.addFood(food1);
        room1.addWepons(weapon1);
        room1.addEnemy(enemy1);


        Room room2 = new Room("The meadow.","The meadow is dark and there is old fruit and a dark thick fog.");
        Enemy enemy2 = new Enemy("Cruella de Vil",50,new MeleeWeapon("Telekinesis","Animal Contro",20),room1);
        Food food2 = new Food("fruit","old",- 20);
        MeleeWeapon weapon2 = new MeleeWeapon("knife","to cut a tree",10);
        room2.addFood(food2);
        room2.addWepons(weapon2);
        room2.addEnemy(enemy2);



        Room room3 = new Room("a lake,", "where it is dark and the water is still.");
        Food food3 = new Food("Fish","eat",20);
        Enemy enemy3 = new Enemy("Ursula",50,new MeleeWeapon("magic","takes voice",1),room1);
        MeleeWeapon weapon3 = new MeleeWeapon("harpoon","to fish",20);
        room3.addWepons(weapon3);
        room3.addWepons(food3);
        room3.addEnemy(enemy3);


        Room room4 = new Room("the north forrest,", "where all the trees have died as well as dark shadows and limbs acroos the path.");
        RangedWeapon weapon4 = new RangedWeapon ("a sling","old",15,15);
        Food food4 = new Food ("water","grimy",-10);
        room4.addWepons(weapon4);
        room3.addFood(food4);


        Room room5 = new Room("Ilse of Sorrow", "5 and now you're in a hive");
        Food food5 = new Food("honey","brown",10);
        MeleeWeapon weapon5 = new MeleeWeapon("axe","to cut a tree",1);
        room5.addFood(food5);
        room5.addWepons(weapon5);

        Room room6 = new Room("The Abandoned Barn", "where there is humans remains every where and blod.");
        Item item6 = new Item("Hay","to sleep on");
        MeleeWeapon weapon6 = new MeleeWeapon("club","to hit",1);
        room6.addItem(item6);
        room6.addWepons(weapon6);

        Room room7 = new Room("south forrest", "where you can see the exit but there are monsters guarding the exit");
        RangedWeapon weapon7 = new RangedWeapon("crossbow","to shoot",5,5);
        Enemy enemy7 = new Enemy("Arrow",50,new RangedWeapon("arrow","to shoot",10,1),room1);
        room7.addWepons(weapon7);
        room7.addEnemy(enemy7);


        Room room8 = new Room("a place right by the exit","where the monsters village is and there can you see humans trap in a prison");
        Item item8 = new Item("binoculars","to see");
        MeleeWeapon weapon8 = new MeleeWeapon("sword","to fight",1);
        room8.addItem(item8);
        room8.addWepons(weapon8);

        Room room9 = new Room("the adventure towns main street", "the main street are filled with shops.");
        Food food9 = new Food("meat","to eat",50);
        Enemy enemy9 = new Enemy("Robber",50,new RangedWeapon("mask","hidden identity",1,1),room1);
        room9.addItem(food9);
        room9.addEnemy(enemy9);


        //spil start
        currentRoom = room1;

        // forbindelser mellem room
        room1.setEast(room2);
        room1.setSouth(room4);


        room2.setEast(room3);
        room2.setWest(room1);


        room3.setWest(room2);
        room3.setSouth(room6);

        room4.setNorth(room1);
        room4.setSouth(room7);

        room5.setSouth(room8);

        room6.setNorth(room3);
        room6.setSouth(room9);

        room7.setNorth(room4);
        room7.setEast(room8);

        room8.setWest(room7);
        room8.setNorth(room5);
        room8.setEast(room9);
    }

    public Room getCurrentRoom(){
        return currentRoom;
    }

    public Room getStartingRoom(){
        return currentRoom;
    }





}
