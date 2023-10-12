import java.util.Scanner;

public class UserInterface {

    private Adventure adventure;

    public UserInterface() {
        adventure = new Adventure();
        adventure.buildMap();
    }

    public void startGame() {
        Adventure adventure = new Adventure();
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Welcome to the ADVENTURE GAME\nI hope you are ready for an adventure, brace yourself and lets get going!\n" +
                "If you need help simply type 'help'.\n" +
                "Press 'Enter' to start playing.");


        keyboard.nextLine();
        adventure.buildMap();
        System.out.println(adventure.getCurrentRoomDescription());
        System.out.println(adventure.viewEnemy());

        while (true) {
            System.out.println("\n" + "Where do you want to go next?");
            String input = keyboard.nextLine();

            switch (input.toLowerCase()) {

                case "exit":
                    if (input.equalsIgnoreCase("exit")) {
                        System.out.println("Thanks for playing! Goodbye.");
                        return;
                    }

                case "help":
                    System.out.println("You can move in between rooms by writing 'go north', 'go south', 'go east' and 'go west'\n" +
                            "Not all rooms are connected! Maybe try a different direction." +
                            "Write 'exit' if you want to stop playing, \n" +
                            "Type 'look' if you want a description of your surroundings and 'take' to pick up an item on your journey. husk navn!!" + "\n" +
                            "Type 'inventory' to view inventory" + "\n" +
                            "Type 'take' to take a item in a room" + "\n" +
                            "Type 'drop' to drop a item in any room" + "\n" +
                            "Type 'eat' to eat food in any room" + "\n" +
                            "Type 'health' to see health point" + "\n" +
                            "Type 'equip' to equip a weapon in any room" + "\n" +
                            "Type 'attack' to ATTACK A ENEMY!");
                    break;

                case "look", "l":
                    System.out.println(adventure.toString().toLowerCase());
                    System.out.println(" You are in the following room:" + " " + adventure.getCurrentRoomDescription());
                    break;
                case "inventory", "inv":
                    adventure.player.viewInventory();
                    break;
                case "drop":
                    System.out.println("what do you want to drop?");
                    input = keyboard.nextLine();
                    adventure.setDropItem(input);
                    String dropItems = adventure.getDropItems();

                    if (dropItems != null) {
                        System.out.println("you have dropped" + dropItems);
                    }
                    break;

                case "take", "t":
                    System.out.println("What item do you want to take with you?");
                    input = keyboard.nextLine();
                    boolean takeItem = adventure.takeItem(input);
                    if (takeItem) {
                        System.out.println("you took " + takeItem);
                    } else {
                        System.out.println("sorry you can not take" + takeItem);
                    }
                    break;

                case "eat", "ea":
                    System.out.println("What do you want to eat?");
                    input = keyboard.nextLine();
                    EatEnum edible = adventure.eatFood(input);

                    if (edible == EatEnum.FOOD_FOUND) {
                        System.out.println("you have now consumed " + input);
                        System.out.println("Your health is now: " + adventure.getHealthPoints());
                        System.out.println(adventure.healthLevelPoint());

                    } else if (edible == EatEnum.FOOD_NOT_EDIBLE) {
                        System.out.println("You cannot consume " + input);
                    } else {
                        System.out.println("This food is not found, sorry..");
                    }
                    break;
                case "health point", "health", "h":
                    System.out.println("Your health point is now:" + " " + adventure.getHealthPoints());
                    System.out.println(adventure.healthLevelPoint());
                    break;

                case "attack":
                    input = keyboard.nextLine();
                    Enemy enemy = adventure.getPlayer().FindEnemyInRoom(input);
                    if (enemy != null) {
                        AttackEnum attackPossible = adventure.playerAttack(enemy);
                        if (attackPossible == AttackEnum.EQUIP_WEAPON_MELEE) {
                            System.out.println("You attack: " + input);
                            System.out.println("You dealt damage to " + input + ".");
                            System.out.println("Your health: " + adventure.getPlayer().getHealthPoint());
                            if (enemy.getEnemyhealth() > 0) {
                                System.out.println(input + " health: " + enemy.getEnemyhealth());
                            } else {
                                System.out.println("You defeated " + input + "!");
                            }
                        } else if (attackPossible == AttackEnum.EQUIP_WEAPON_RANGED) {
                            System.out.println("You shoot: " + input);
                            System.out.println("You shoot at " + input + ".");
                            System.out.println("Your health: " + adventure.getPlayer().getHealthPoint());
                            if (enemy.getEnemyhealth() > 0) {
                                System.out.println(input + " health: " + enemy.getEnemyhealth());
                            } else {
                                System.out.println("You defeated " + input + "!");
                            }
                        } else if (attackPossible == AttackEnum.ATTACK_NO_AMO) {
                            System.out.println("You have no ammo left.");
                        }
                    } else {
                        System.out.println("No enemy found with the name: " + input);
                    }
                    break;
                case "equip", "eq":
                    System.out.println("what weapons do you want to equip");
                    input = keyboard.nextLine();
                    AttackEnum equipAnswer = adventure.equip(input);
                    if (equipAnswer == AttackEnum.WEAPON_EQUIP) {
                        System.out.println("You equipped " + input);
                    } else if (equipAnswer == AttackEnum.WEAPON_NOT_FOUND) {
                        System.out.println("sorry your weapon is not in your inventory");
                    } else if (equipAnswer == AttackEnum.WEAPON_NOT_EQUIP) {
                        System.out.println("your weapon is not equipped");
                    }
                    break;

                default:
                    if (input.startsWith("go")) {
                        String direction = input.substring(3);
                        String result = adventure.move(direction);
                        if (result != null) {
                            System.out.println(result);
                        }
                    } else {
                        System.out.println("Unknown command. Type 'help' for commands.");
                        keyboard.nextLine();
                    }
                    break;
            }
        }
    }
}
