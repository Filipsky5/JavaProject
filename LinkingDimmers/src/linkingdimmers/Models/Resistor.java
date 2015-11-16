/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkingdimmers.Models;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author student
 * 
 */
public class Resistor {
    List<StripeColor> Bands;
    StripeColor Multiplier;
    StripeColor[] stripes;
    
    public Resistor (StripeColor[] _stripes) {
       this.Bands = new ArrayList<StripeColor>();
       for (int i =0; i < _stripes.length - 1; ++i) {
           this.Bands.add(_stripes[i]);
       }
       Multiplier = _stripes[_stripes.length - 1];
       stripes = _stripes;
   }
    
    public double countResistence() {
        double valueOfresistance = 0.0;
        for (StripeColor c : Bands) {
            valueOfresistance += c.getValue();
        }
        valueOfresistance *= Multiplier.getMultiplier();
        return valueOfresistance;
    }
    
    public boolean addValueToBands(int value, int indexOfStripe) {
        if (indexOfStripe >= Bands.size()) {
            return false;
        }
        int valueOfStripe = Bands.get(indexOfStripe).getValue();
        valueOfStripe += value;
        if (valueOfStripe > 9 || valueOfStripe < 0) {
            return false;
        }
        Bands.set(indexOfStripe,StripeColor.getStripeColorForValue(valueOfStripe));
        return true;
    }
    public boolean addValueToMultiplier(double value, int indexOfStripe) {
        
        double valueOfMul = Multiplier.getMultiplier();
        valueOfMul *= value;
        if (valueOfMul <= 10000000 && valueOfMul >= 0.01) {
            Multiplier = StripeColor.getStripeColorForMultiplier(valueOfMul);
            return true;
        }
        return false;
    }
    
    public Color colorOfStripeAtIndex(int index ) {
        if (index == stripes.length-1) {
            double value = Multiplier.getMultiplier();
            return StripeColor.mapColorForMultiplier(value);
        }
        return StripeColor.mapValueToColor(Bands.get(index).getValue());
    }
}
