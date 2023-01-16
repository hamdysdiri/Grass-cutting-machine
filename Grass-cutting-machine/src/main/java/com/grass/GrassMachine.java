package com.grass;

import java.util.regex.Pattern;

public class GrassMachine {
    public void command(String x) {
    }

    public boolean test(String command) {
        Pattern p = Pattern.compile("\\d\\s\\d\\s\\d\\s\\d.*");
        return Pattern.matches(String.valueOf(p), command) ;
    }
}
