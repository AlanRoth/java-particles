/*
 * Copyright Payara Services Ltd
 */
package controller;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author asroth
 */
public class ParticleController {
    private List<ParticleCreationEvent> listeners = new ArrayList<>();
    
    public void addListener(ParticleCreationEvent toAdd){
        listeners.add(toAdd);
    }
    
    public ParticleController(){
        
    }
    
    public void createParticle(int posX, int posY){   
        for(ParticleCreationEvent listner : listeners){
            listner.particleCreated(posX, posY);
        }
    }
    
}
