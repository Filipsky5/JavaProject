/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkingdimmers.Models;

import linkingdimmers.Views.Ball;

/**
 *
 * @author Filip
 */
public class PositionForBallCounter implements Runnable {
    Ball []balls;
    public volatile double [] resistance;
    
    private volatile Thread blinker;
    public volatile int tension;
    public volatile int intensity;
    
    public PositionForBallCounter(Ball[] _balls) {
        balls = _balls;
    }
     public void run() {
        
  
        Thread thisThread = Thread.currentThread();
        while (blinker == thisThread) {
            for (int i = 0; i < balls.length ; ++i) {
                Ball b = balls[i];
                double _resistance = 0.0;
                if (resistance != null) {
                    for (int j = 0; j <= i; ++j) {
                        _resistance =+ resistance[j];
                    }
                }
                //double intensity = tension * _resistance;
                double localTension = intensity * _resistance; 
                b.x =  (int) ((localTension / 1000) * b.time);
                b.time +=0.005;
                if (b.x > b.road) {
                    b.x = 0;
                    b.time = 0;
                    b.intensity = intensity;
                }
               // x +=initialX;
                b.repaint();
            }
            try {
                Thread.sleep(50);
            } catch (Exception ex) {}
        }
    }
    
    public void start() {
        blinker = new Thread(this);
        blinker.start();
    }
    
    public void stop() {
        blinker = null;
    }
}
