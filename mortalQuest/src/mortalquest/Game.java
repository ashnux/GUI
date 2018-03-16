/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mortalquest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Student
 */
public class Game {

    public void start() {
        Character player = new Character();
        Character boss = new Character();
        player.setName("chris");
        player.addMoney(100);
        boss.setName("BOSS");
        Dungeon dungeon = new Dungeon();
        boolean playing = true;
        Consequence charCurrent;
        
        FileOutputStream fileOStream;
        
//
//try{
//            fileOStream = new FileOutputStream("savedMap.dungeon");
//            ObjectOutputStream objectOStream = new ObjectOutputStream(fileOStream);
//            objectOStream.writeObject(dungeon);
//            objectOStream.flush();
//            objectOStream.close();
//            
//        } catch (FileNotFoundException ex) {
//            System.out.println("File not Found " + ex.getMessage());
//        } catch (IOException ex) {
//            System.out.println("IO exception occured " + ex.getMessage());
//        }
//        
//        dungeon = null;
//        
//        try{
//            FileInputStream fileIStream = new FileInputStream("savedMap.dungeon");
//            ObjectInputStream objectIStream = new ObjectInputStream(fileIStream);
//            dungeon = (Dungeon) objectIStream.readObject();
//            objectIStream.close();
//        } catch (FileNotFoundException ex) {
//            System.out.println("File not Found: " + ex.getMessage());
//        } catch (IOException ex) {
//            System.out.println("IO exception occured: " + ex.getMessage());
//        } catch (ClassNotFoundException ex) {
//            System.out.println("class not found: " + ex.getMessage());
//        }
        
        while(playing){
            dungeon.charMove();
            switch (dungeon.getConsequence()) {//NOTHING, WIN, DAMAGE, HBOOST, MONEY, LOSEMONEY, BOSS
                case DAMAGE:
                    player.addHealth(-20);
                    break;
                case HBOOST:
                    player.addHealth(20);
                    break;
                case LOSEMONEY:
                    player.addMoney(-50);
                    break;
                case MONEY:
                    player.addMoney(20);
                    break;
                case BOSS:
                    dungeon.boss();
                    break;
                case WIN:
                    playing = false;
                    break;
                case NOTHING:
                    break;
                default:
                    throw new AssertionError();
            }
            if(player.getHealth() <= 0)
                playing = false;
        }
    }
}
