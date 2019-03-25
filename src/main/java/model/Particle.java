/*
 * Copyright Payara Services Ltd
 */
package model;

/**
 *
 * @author asroth
 */
public class Particle {
    private double posX;
    private double posY;
    private final int WIDTH = 2;
    private final int HEIGHT = 2;
    private double speedX;
    private double speedY;
    
    public Particle(double posX, double posY){
        this.posX = posX;
        this.posY = posY;
        speedX = (Math.random()*5-2.5);
        speedY = (Math.random()*5-2.5);
    }
    
    public void setX(double value){
        posX = value;
    }
    
    public void setY(double value){
        posY = value;
    }
    
    public double getX(){
        return posX;
    }
    
    public double getY(){
        return posY;
    }
    
    public int getHeight(){
        return HEIGHT;
    }
    
    public int getWidth(){
        return WIDTH;
    }
    
    public void setSpeedX(double value){
        speedX = value;
    }
    
    public void setSpeedY(double value){
        speedY = value;
    }
    
    public double getSpeedX(){
        return speedX;
    }
    
    public double getSpeedY(){
        return speedY;
    }
    
    public void applyVelocity(){
        posX = posX + speedX;
        posY = posY + speedY;
    }
    
}
