/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkingdimmers.Models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Filip
 */
public class Notifier {
    public double oldValue = 0.0;
    public int sequenceNumber = 0;
    private List<ResistanceListener> listeners = new ArrayList<ResistanceListener>();

    public void addListener(ResistanceListener toAdd) {
        listeners.add(toAdd);
    }

    public void sendResistornotificationWithValue(double resistance, double[] parallelConnection) {
//        Notification n = new AttributeChangeNotification(this, sequenceNumber++, System.currentTimeMillis(), "Resistance changed", "Resistance" , "double", oldValue, resistance);
//         sendNotification(n);
//         oldValue = resistance;

        // Notify everybody that may be interested.
        for (ResistanceListener hl : listeners)
            hl.resistanceChanged(resistance,parallelConnection);

    }
    public void graphicsCreated() {
         for (ResistanceListener hl : listeners)
            hl.graphicsLoaded();
    }

}
