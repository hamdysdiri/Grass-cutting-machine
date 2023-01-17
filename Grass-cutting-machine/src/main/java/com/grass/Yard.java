package com.grass;

import java.util.regex.Pattern;

public class Yard {
    private int[][] yard;

    public Yard(String yardCommandSize) {
        if (verifyFirstLineYardCommand(yardCommandSize))
            this.yard= new int[Integer.parseInt(String.valueOf(yardCommandSize.charAt(0))) + 1][Integer.parseInt(String.valueOf(yardCommandSize.charAt(2))) + 1 ];
    }

    public int[][] getYard() {
        return yard;
    }
    
    public boolean verifyFirstLineYardCommand(String command) {
        Pattern p = Pattern.compile("\\d\\s\\d"); // e,g 5 5
        return Pattern.matches(String.valueOf(p), command) ;
    }


}
