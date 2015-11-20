/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkingdimmers.Models;

import java.awt.Color;

/**
 *
 * @author Filip
 */
public enum StripeColor {
    BLACK(0),BROWN(1),RED(2),ORANGE(3),YELLOW(4),GREEN(5),BLUE(6),PURPLE(7),GREY(8),WHITE(9),GOLD(10),SILVER(11);
    
    private final int value;
    private StripeColor(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
    
    public static Color mapValueToColor(int value) {
        Color returnColor;
        switch (value) {
            case (0):
                returnColor = Color.BLACK;
                break;
            case (1):
                float r = (float) (139.0/255.0);
                float g = (float) (69.0/255.0);
                float b = (float) (19.0/255.0);
                returnColor = new Color(r,g,b);
                break;
            case(2):
                returnColor = Color.RED;
                break;
            case (3):
                returnColor = Color.ORANGE;
                break;
            case (4):
                returnColor = Color.YELLOW;
                break;
            case (5):
                returnColor = Color.GREEN;
                break;
            case (6):
                returnColor = Color.BLUE;
                break;
            case (7):
                r = (float) (147.0/255.0);
                g = (float) (112.0/255);
                b = (float) (219.0/255.0);
                returnColor = new Color(r,g,b);
                break;
            case (8):
                r = (float) (84.0/255.0);
                g = (float) (84.0/255);
                b = (float) (84.0/255.0);
                returnColor = new Color(r,g,b);
                break;
            case (9):
                returnColor = Color.WHITE;
                break;
            case (10):
                r = (float) (184.0/255.0);
                g = (float) (134.0/255);
                b = (float) (11.0/255.0);
                returnColor = new Color(r,g,b);
                break;
            case (11):
                r = (float) (192.0/255.0);
                g = (float) (192.0/255);
                b = (float) (192.0/255.0);
                returnColor = new Color(r,g,b);
                break;
            default:
                returnColor = Color.BLACK;
                break;
        }
        return returnColor;
        
    }
    
    static Color mapColorForMultiplier(double multiplier) {
        Color colorToreturn;
        if (multiplier == 1){
            colorToreturn = Color.BLACK;
        } else if (multiplier == 10) {
            float r = (float) (139.0/255.0);
            float g = (float) (69.0/255.0);
            float b = (float) (19.0/255.0);
            colorToreturn = new Color(r,g,b);
        } else if (multiplier == 100){
            colorToreturn = Color.RED;
        } else if(multiplier == 1000) {
            colorToreturn = Color.ORANGE;
        } else if (multiplier == 10000) {
            colorToreturn = Color.YELLOW;
        }else if(multiplier == 100000) {
            colorToreturn = Color.GREEN;
        }else if(multiplier == 1000000) {
            colorToreturn = Color.BLUE;
        }else if (multiplier == 10000000) {
            float r = (float) (147.0/255.0);
            float g = (float) (112.0/255);
            float b = (float) (219.0/255.0);
            colorToreturn = new Color(r,g,b);
        }else if (multiplier == 0.1) {
            float r = (float) (184.0/255.0);
            float g = (float) (134.0/255);
            float b = (float) (11.0/255.0);
            colorToreturn = new Color(r,g,b);
        } else if (multiplier <= 0.01 && multiplier > 0.001) {
            float r = (float) (192.0/255.0);
            float g = (float) (192.0/255);
            float b = (float) (192.0/255.0);
            colorToreturn = new Color(r,g,b);
        } else {
            colorToreturn = Color.BLACK;
        }
        return colorToreturn;
    }
    
    public static StripeColor getStripeColorForValue(int value) {
        StripeColor returnColor;
        switch (value) {
            case (0):
                returnColor = BLACK;
                break;
            case (1):
                returnColor = BROWN;
                break;
            case(2):
                returnColor = RED;
                break;
            case (3):
                returnColor = ORANGE;
                break;
            case (4):
                returnColor = YELLOW;
                break;
            case (5):
                returnColor = GREEN;
                break;
            case (6):
                returnColor = BLUE;
                break;
            case (7):
                returnColor = PURPLE;
                break;
            case (8):
                returnColor = GREY;
                break;
            case (9):
                returnColor = WHITE;
                break;
            case (10):
                returnColor = GOLD;
                break;
            case (11):
                returnColor = SILVER;
                break;
            default:
                returnColor = BLACK;
                break;
        }
        return returnColor;
        
    }
    
    public double getMultiplier() {
        double valueToReturn;
        switch (value) {
            case(0):
                valueToReturn = 1;
                break;
            case(1):
                valueToReturn = 10;
                break;
            case(2):
                valueToReturn = 100;
                break;
            case(3):
                valueToReturn = 1000;
                break;
            case(4):
                valueToReturn = 10000;
                break;
            case(5):
                valueToReturn = 100000;
                break;
            case(6):
                valueToReturn = 1000000;
                break;
            case(7):
                valueToReturn = 10000000;
                break;
            case(10):
                valueToReturn = 0.1;
                break;
            case(11):
                valueToReturn = 0.01;
                break;
            default:
                valueToReturn = 1;
                break;
        }
        return valueToReturn;
    }
    
    static StripeColor getStripeColorForMultiplier(double multiplier) {
        StripeColor colorToreturn;
        if (multiplier == 1){
            colorToreturn = BLACK;
        } else if (multiplier == 10) {
            colorToreturn = BROWN;
        } else if (multiplier == 100){
            colorToreturn = RED;
        } else if(multiplier == 1000) {
            colorToreturn = ORANGE;
        } else if (multiplier == 10000) {
            colorToreturn = YELLOW;
        }else if(multiplier == 100000) {
            colorToreturn = GREEN;
        }else if(multiplier == 1000000) {
            colorToreturn = BLUE;
        }else if (multiplier == 10000000) {
            colorToreturn = PURPLE;
        }else if (multiplier == 0.1) {
            colorToreturn = GOLD;
        } else if (multiplier < 0.1 && multiplier > 0.001) { // problem z dokladnoscią double
            colorToreturn = SILVER;
        } else {
            colorToreturn = BLACK;
        }
        return colorToreturn;
    }
}

