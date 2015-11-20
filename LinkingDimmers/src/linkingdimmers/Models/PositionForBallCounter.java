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
    
    private volatile Thread blinker;
    
    public PositionForBallCounter(Ball[] _balls) {
        balls = _balls;
    }
     public void run() {
        
  
        Thread thisThread = Thread.currentThread();
        while (blinker == thisThread) {
            for (Ball b : balls) {
                double tension = b.intensity * b.getResistance();
                b.x =  (int)(tension * b.time);
                b.time +=0.5;
                if (b.x > b.road) {
                    b.x = 0;
                    b.time = 0;
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
