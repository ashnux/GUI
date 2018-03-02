/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mortalquest;

class Player {

    private String name;
    private int health = 100;
    private int strength;
    private int agility;
    private int defence;
    private int money = 100;
    private final int MAXINVENTORY = 20;
    private final Item[] inventory = new Item[MAXINVENTORY];//create inventory class examples for use include npc, max weight, size etc

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        if (this.name == null) {
            this.name = name;
        } else {
            System.out.println("Player already has name: " + this.name);
        }
    }

    
    public int getHealth() {
        return health;
    }

    
    public void addHealth(int health) { //takes both plus and minus
        this.health += health;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) { //strength set at start
        if (this.strength == 0) {
            this.strength = strength;
        } else {
            System.out.println("Already set strength");
        }
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) { //set agility at start
        if (this.agility == 0) {
            this.agility = agility;
        } else {
            System.out.println("Already set agility");
        }
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) { //set defence at start
        if (this.defence == 0) {
            this.defence = defence;
        } else {
            System.out.println("Already set defence");
        }
    }

    public int addItem(Item item, int location) {
        int i = location;
        if (inventory[i] == null) {
            inventory[i] = item;
        }
        i++;
        for (; i != location; i++) {    //start from chosen slot and iterate round back to it to check until a slot is avaliable
            if (inventory[i] == null) {
                inventory[i] = item;
                return i;
            }
            if (i == MAXINVENTORY - 1) {
                i = -1; //if no slot is avaliable
            }
        }
        return -1; //no inventory slot avaliable
    }

    public boolean removeItem(Item item, int location) {
        if (inventory[location] != null) {
            inventory[location] = null;
            return true;
        }
        return false;
    }

    public int getMoney() {
        return money;
    }

    public void addMoney(int money) {
        this.money += money;
    }
}

class Item {
    private String name;
    private String description;
    
}
