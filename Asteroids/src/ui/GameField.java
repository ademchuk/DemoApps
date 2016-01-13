package ui;

import shipController.Controller;
import shipController.RealGravity;
import engine.Engine;
import eventListeners.WASDController;
import gameObjects.Asteroid;
import gameObjects.Ship;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by User1 on 11/2/2015.
 */
public class GameField extends JPanel {
    public int scale;
    public int HEIGHT;
    public int WIDTH;
    public Ship ship;
    public Engine engine;
    public Point mousePointer;
    public Controller controller;

    public CopyOnWriteArrayList<Asteroid> asteroids = new CopyOnWriteArrayList<Asteroid>();

    public GameField(int height, int width) {
        scale = 1000;
        this.HEIGHT = height;
        this.WIDTH = width;
        controller = new RealGravity(20);
        ship = new Ship(this,controller);
        engine = new Engine(this);
        this.addKeyListener(new WASDController(this));
        this.repaint();
    }

    public void paintComponent (Graphics g) {
//        super.paintComponent(g);
        fillBackground(g);
        g.setColor(Color.WHITE);
        ship.draw(g);
        for (Asteroid asteroid : asteroids) {
            if (asteroid.destroyed) {
                asteroid.liveAfterDeath--;
            }
            if (asteroid.liveAfterDeath <= 0 ) {
                asteroids.remove(asteroid);
            } else {
                asteroid.draw(g);
            }
        }
    }

    public void fillBackground (Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0,0,WIDTH,HEIGHT);
    }

}
