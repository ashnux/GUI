/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mortalquest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Student
 */
public class Dungeon implements java.io.Serializable{
    private Location charLocation;
    private List<Location> places;
    
    public Dungeon(){
        places = new ArrayList<Location>();
        Location start = new Location(Consequence.NOTHING, "start");
        Location hallway1 = new Location(Consequence.NOTHING, "hallway1");
        Location hallway2 = new Location(Consequence.NOTHING, "hallway2");
        Location bunks = new Location(Consequence.NOTHING, "bunks");
        Location torture = new Location(Consequence.DAMAGE, "torture");
        Location kitchen = new Location(Consequence.HBOOST, "kitchen");
        Location treasure = new Location(Consequence.MONEY, "treasure");
        Location exit = new Location(Consequence.WIN, "exit");
        Location shop = new Location(Consequence.LOSEMONEY, "shop");
        Location boss = new Location(Consequence.BOSS, "boss");
        
        
        
        start.setLink(direction.EAST, hallway1);
        hallway1.setLink(direction.NORTH, bunks);
        hallway1.setLink(direction.SOUTH, torture);
        hallway1.setLink(direction.WEST, start);
        hallway1.setLink(direction.EAST, hallway2);
        bunks.setLink(direction.SOUTH, hallway1);
        torture.setLink(direction.NORTH, hallway1);
        hallway2.setLink(direction.WEST, hallway1);
        hallway2.setLink(direction.NORTH, kitchen);
        hallway2.setLink(direction.SOUTH, treasure);
        hallway2.setLink(direction.EAST, boss);
        kitchen.setLink(direction.SOUTH, hallway2);
        kitchen.setLink(direction.EAST, shop);
        shop.setLink(direction.WEST, kitchen);
        treasure.setLink(direction.NORTH, hallway2);
        boss.setLink(direction.EAST, exit);
        boss.setLink(direction.WEST, hallway2);
        
        places.add(start);
        places.add(hallway1);
        places.add(hallway2);
        places.add(bunks);
        places.add(torture);
        places.add(kitchen);
        places.add(treasure);
        places.add(exit);
        places.add(shop);
        places.add(boss);
        
        charLocation = places.get(0);
    }
    
    public void charMove(){
        System.out.println(charLocation.getLinks());
        Scanner scanner = new Scanner(System.in);
        String input;
        direction movement = direction.NONE;
        while(movement == direction.NONE){
            input = scanner.nextLine();
            switch (input.toLowerCase().substring(0)) {
                case "e":
                    movement = direction.EAST;
                    break;
                case "n":
                    movement = direction.NORTH;
                    break;
                case "w":
                    movement = direction.WEST;
                    break;
                case "s":
                    movement = direction.SOUTH;
                    break;
                default:
                    break;
            }
        }
        charLocation = charLocation.move(movement);
    }
    
    public Consequence getConsequence(){
        return charLocation.getConsequence();
    }

    void boss() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
