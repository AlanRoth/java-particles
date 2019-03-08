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
    private double accelerationX;
    private double accelerationY;
    
    public Particle(double posX, double posY){
        this.posX = posX;
        this.posY = posY;
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
    
    public void setAccelerationX(double value){
        accelerationX = value;
    }
    
    public void setAccelerationY(double value){
        accelerationY = value;
    }
    
    public void applyAcceleration(){
        posX = posX + accelerationX;
        posY = posY + accelerationY;
    }
    
}
