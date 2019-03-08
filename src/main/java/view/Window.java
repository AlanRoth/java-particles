/*
 * Copyright Payara Services Ltd
 */
package view;

import controller.EventHandler;
import controller.ParticleCreationEvent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Dimension2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer;
import model.Gravity;
import model.Particle;

/**
 *
 * @author asroth
 */
public class Window extends JPanel implements ParticleCreationEvent, ActionListener{
    private EventHandler eventHandler;
    private ArrayList<Particle> particles;
    private Timer timer;
    private Random random;
    
    public Window(){
        eventHandler = new EventHandler();
        this.addMouseListener(eventHandler);
        
        particles = new ArrayList<Particle>();
        
        timer = new Timer(10, this);
        timer.start();             
        
        random = new Random();
    }
    
    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        
        renderParticles(graphics);
        particleMotion(graphics);
    }

    public void renderParticles(Graphics graphics){
        
        Graphics2D graphics2D = (Graphics2D) graphics;
        
        particles.stream().forEach((p)->{
            Ellipse2D e = new Ellipse2D.Double(p.getX(), p.getY(), p.getWidth(), p.getHeight());
            graphics2D.fill(e);
            graphics2D.draw(e);
        });
        
        Toolkit.getDefaultToolkit().sync();
    }
    
    public void particleMotion(Graphics graphics){
        Graphics2D graphics2D = (Graphics2D) graphics;
        particles.stream().forEach((p)->{
            double posX = p.getX();
            double posY = p.getY();
            if(posX > this.getWidth()){
                p.setAccelerationX((Math.random()*5)-2.5);
            }else if(posY > this.getHeight()){
                p.setAccelerationY((Math.random()*5)-2.5);
            }else if(posX < 0){
                p.setX(0);
                p.setAccelerationX((Math.random()*5)-2.5);
            }else if(posY < 0){
                p.setY(0);
                p.setAccelerationY((Math.random()*5)-2.5);
            }
            p.applyAcceleration();
        });
    }
    
    private void createParticle(double posX, double posY){
        Particle particle = new Particle(posX, posY);
        particle.setAccelerationX((Math.random()*5)-2.5);
        particle.setAccelerationY((Math.random()*5)-2.5);
        particles.add(particle);
    }
    
    @Override
    public void particleCreated(int posX, int posY) {
        createParticle(posX, posY);
    }
    
    public EventHandler getEventHandler(){
        return eventHandler;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        repaint();
    }
    
}
