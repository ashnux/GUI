/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mortalquest;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
 
public class QuestGUI extends Application {
    

//    public static void main(String[] args) {
//        launch(args);
//    }
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Basic GUI");
        Group root = new Group();
        Scene scene = new Scene(root, 300, 300);
        scene.setFill(Color.DARKSLATEGRAY);
        Rectangle[] map = new Rectangle[5];
        for(int i = 0; i<5; i++){
            switch(i){
                case 0:
                    map[i] = new Rectangle(100, 100, 100, 100);
                    break;
                case 1:
                    map[i] = new Rectangle(0, 100, 100, 100);
                    break;
                case 2:
                    map[i] = new Rectangle(100, 0, 100, 100);
                    break;
                case 3:
                    map[i] = new Rectangle(100, 200, 100, 100);
                    break;
                case 4:
                    map[i] = new Rectangle(200, 100, 100, 100);
                    break;
                
            }
            map[i].setFill(Color.WHITE);
            map[i].setStroke(Color.BLACK);
        }
        for(int i = 0; i < 5; i++){
            root.getChildren().add(map[i]);
        }
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Rectangle");
        stage.show();
    }
}
