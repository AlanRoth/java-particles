/*
 * Copyright Payara Services Ltd
 */
package model;

/**
 *
 * @author asroth
 */
public class Gravity {
    private final double GCONSTANT = -5;
    
    public double applyGravity(double value){
        return value-GCONSTANT;
    }
    
}
