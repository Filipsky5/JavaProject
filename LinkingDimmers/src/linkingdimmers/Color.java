/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkingdimmers;

/**
 *
 * @author Filip
 */
public enum Color {
    BLACK(1),BROWN(2),RED(3),ORANGE(4),YELLOW(5),GREEN(6),BLUE(7),PURPLE(8),GREY(9),WHITE(10),GOLD(11),SILVER(12);
    
    private final int value;
    private Color(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
    
    public static Color getColorForValue(int value) {
        Color returnColor;
        switch (value) {
            case (1):
                returnColor = BLACK;
                break;
            case (2):
                returnColor = BROWN;
                break;
            case(3):
                returnColor = RED;
                break;
            case (4):
                returnColor = ORANGE;
                break;
            case (5):
                returnColor = YELLOW;
                break;
            case (6):
                returnColor = GREEN;
                break;
            case (7):
                returnColor = BLUE;
                break;
            case (8):
                returnColor = PURPLE;
                break;
            case (9):
                returnColor = GREY;
                break;
            case (10):
                returnColor = WHITE;
                break;
            case (11):
                returnColor = GOLD;
                break;
            case (12):
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
            case(1):
                valueToReturn = 1;
                break;
            case(2):
                valueToReturn = 10;
                break;
            case(3):
                valueToReturn = 100;
                break;
            case(4):
                valueToReturn = 1000;
                break;
            case(5):
                valueToReturn = 10000;
                break;
            case(6):
                valueToReturn = 100000;
                break;
            case(7):
                valueToReturn = 1000000;
                break;
            case(8):
                valueToReturn = 10000000;
                break;
            case(9):
                valueToReturn = 1;
                break;
            case(10):
                valueToReturn = 1;
                break;
            case(11):
                valueToReturn = 0.1;
                break;
            case(12):
                valueToReturn = 0.01;
                break;
            default:
                valueToReturn = 1;
                break;
        }
        return valueToReturn;
    }
    
    static Color getColorForMultiplier(double multiplier) {
        Color colorToreturn;
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
        } else if (multiplier == 0.01) {
            colorToreturn = SILVER;
        } else {
            colorToreturn = BLACK;
        }
        return colorToreturn;
    }
}

