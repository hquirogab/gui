/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.SVGPath;
import javafx.scene.shape.Shape;

/**
 *
 * @author Estudiante
 */
public class LoopJuego extends AnimationTimer {
    private GraphicsContext gc; //Vista
    private Carro carro; //Modelo
    private Image fondo;
    private Image gato;
    private Image nino;
    private int gatoFrame;
    private int gatoPos;
    private int secuencia;

    public LoopJuego(GraphicsContext gc) {
        this.gc = gc;
        this.carro = new Carro(0, 200);
        this.fondo = new Image("imagenes/fondo.png");
        this.gato = new Image("imagenes/cats.gif");
        this.nino = new Image("imagenes/down1.png");
        this.gatoFrame = 0;
        this.secuencia = 0;
        this.gatoPos = 0;
    }
    
    @Override
    public void handle(long l){
        //Borrando el escenario
        gc.setFill(Color.BLACK);
        
        if(this.secuencia % 5 == 0){
            String impresion = "Tiempo " + this.secuencia/60;
            
            gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
            //Dibujar el fondo
            gc.drawImage(fondo, 0, 0);
            gc.strokeText(impresion, 900, 40);
            
            //Dibujar gato
            gc.drawImage(gato, 132*this.gatoFrame, 0, 132, 80, gatoPos, 329, 132, 80);
            gc.strokeRect(gatoPos+20, 350, 90, 53);
            Shape sGato = new Rectangle(gatoPos+20, 350, 90, 53);
            
            //Dibujar niño
            gc.drawImage(nino, 300, 370);
            gc.strokeRect(302, 374, 27, 33);
            Shape sNiño = new Rectangle(302, 374, 27, 33);
            
            //Interseccion - revisa si las hitbox se cruzan
            Shape interseccion = SVGPath.intersect(sGato, sNiño);
            if (interseccion.getBoundsInLocal().getWidth() != -1){//Si las hitbox se cruzan detiene el loop
                stop();
                gc.strokeText("COLLISION", 512-40, 254);
            }
            
            this.gatoFrame++;
            gatoPos+=5;
            
            if(this.gatoFrame > 5)this.gatoFrame = 0;
        }
        this.secuencia++;
    }
    
}
