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
        particleMotion();
    }

    public void renderParticles(Graphics graphics){
        
        Graphics2D graphics2D = (Graphics2D) graphics;
        
        particles.parallelStream().forEach((p)->{
            Ellipse2D e = new Ellipse2D.Double(p.getX(), p.getY(), p.getWidth(), p.getHeight());
            graphics2D.fill(e);
            graphics2D.draw(e);
        });
        
        Toolkit.getDefaultToolkit().sync();
    }
    
    public void particleMotion(){
        particles.parallelStream().forEach((p)->{
            double posX = p.getX();
            double posY = p.getY();
            double speedX = p.getSpeedX();
            double speedY = p.getSpeedY();
            
            if(posX > this.getWidth()){
                p.setSpeedX(-speedX);
            }else if(posY > this.getHeight()){
                p.setSpeedY(-speedY);
            }else if(posX < 0){
                p.setSpeedX(Math.abs(speedX));
            }else if(posY < 0){
                p.setSpeedY(Math.abs(speedY));
            }
            p.applyVelocity();
        });
    }
    
    private void createParticle(double posX, double posY){
        Particle particle = new Particle(posX, posY);
        particles.add(particle);
        System.out.println(particles.size() + " Particles on screen");
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
