/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;

/**
 *
 * @author Estudiante
 */
public class LoopJuego extends AnimationTimer {
    private GraphicsContext gc; //Vista
    private Carro carro; //Modelo

    public LoopJuego(GraphicsContext gc) {
        this.gc = gc;
        this.carro = new Carro(0, 200);
    }
    
    @Override
    public void handle(long l){
        //Borrando el escenario
        gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
        //Redibujando
        gc.fillRect(this.carro.getX(), this.carro.getY(), 20, 20);
        this.carro.mover();
        if(this.carro.getX() > 300){
            this.carro.setX(0);
            this.carro.setY(this.carro.getY() - 10);
        }
    }
    
}
