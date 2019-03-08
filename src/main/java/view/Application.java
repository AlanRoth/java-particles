/*
 * Copyright Payara Services Ltd
 */
package view;

import controller.EventHandler;
import controller.ParticleController;
import java.awt.EventQueue;
import javax.swing.JFrame;

/**
 *
 * @author asroth
 */
public class Application extends JFrame{
    private final Window window;
    private final ParticleController particleController;
    
    public Application(){
        window = new Window();
        particleController = window.getEventHandler().getParticleController();
        particleController.addListener(window);
        initUI();    
    }
    
    private void initUI(){
        add(window);
        setSize(450,450);
        
        setTitle("Java particles");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 

    }
    
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Application ex = new Application();
            ex.setVisible(true);
        });
    }
    
}
