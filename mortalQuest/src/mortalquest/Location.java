/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mortalquest;
import java.io.Serializable;
import java.util.Map;
import java.util.HashMap;


/**
 *
 * @author Student
 */
enum Consequence {NOTHING, WIN, DAMAGE, HBOOST, MONEY, LOSEMONEY, BOSS}
enum direction {NONE, NORTH, EAST, SOUTH, WEST} //DEFAULT none for a replacement of null


public class Location implements Serializable{
    
    private Map<direction, Location> dungeon = new HashMap<direction, Location>();
    private Consequence result;
    private String name;
    
    public Location(Consequence result, String name){
        this.result = result;
        this.name = name;
    }
    
    public void setLink(direction compass, Location place){
        dungeon.put(compass, place);
    }
    
    public String getLinks(){
        String directions = "";
        if(dungeon.get(direction.EAST)!=null)
            directions += "e)EAST ";
        if(dungeon.get(direction.NORTH)!=null)
            directions += "n)NORTH ";
        if(dungeon.get(direction.WEST)!=null)
            directions += "w)WEST ";
        if(dungeon.get(direction.SOUTH)!=null)
            directions += "s)SOUTH ";
        return directions;
    }
    public Location move(direction move){
        if(dungeon.get(move)== null)
            return null;
        return dungeon.get(move);
    }
    
    public Consequence getConsequence(){
        return result;
    }
}
