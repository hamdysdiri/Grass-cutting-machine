package com.grass;

import java.util.regex.Pattern;

public class GrassMachine {
    public void command(String x) {
    }

    public boolean verifyFirstLineYardCommand(String command) {
        Pattern p = Pattern.compile("\\d\\s\\d"); // e,g 5 5
        return Pattern.matches(String.valueOf(p), command) ;
    }

    public boolean verifyPosition(String command) {
        Pattern p = Pattern.compile("\\d\\s\\d\\s[N,E,S,W]"); // e,g 3 1 N
        return Pattern.matches(String.valueOf(p), command) ;
    }

    public boolean verifyInstructions(String command) {
        Pattern p = Pattern.compile("([G,D]{0,}[A]{0,})*"); // e,g GAGAGGGGAGAAAAA
        return Pattern.matches(String.valueOf(p), command) ;
    }
}
