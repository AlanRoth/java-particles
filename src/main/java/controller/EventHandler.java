/*
 * Copyright Payara Services Ltd
 */
package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


/**
 *
 * @author asroth
 */
public class EventHandler implements MouseListener {
    ParticleController particleController;

    public EventHandler(){
        particleController = new ParticleController();
    }
    
    @Override
    public void mouseClicked(MouseEvent me) {
        particleController.createParticle(me.getX(), me.getY());
    }

    @Override
    public void mousePressed(MouseEvent me) {
        
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        
    }

    @Override
    public void mouseExited(MouseEvent me) {
        
    }
    
    public ParticleController getParticleController(){
        return particleController;
    }
    
}
