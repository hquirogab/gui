/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/**
 *
 * @author Estudiante
 */
public class Tablero extends Application{
    @Override
    public void start(Stage stage) throws Exception {
        //Layout - Forma como se distribuyen los objetos en la escena
        Pane pane = new Pane();
        //Canvas - Tablero de dibujo
        Canvas canvas = new Canvas(300, 300);
        pane.getChildren().add(canvas);
        Scene scene = new Scene(pane, canvas.getWidth(), canvas.getHeight(), Color.CRIMSON);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        LoopJuego loop = new LoopJuego(gc);
        loop.start();
        
        
        stage.setTitle("Prueba JavaFX");
        stage.setScene(scene);
        stage.show();
        
    }
    
    public static void main(String[] args) {
        Application.launch();
    }
}
