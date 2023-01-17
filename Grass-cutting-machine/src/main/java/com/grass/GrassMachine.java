package com.grass;

import javafx.geometry.Orientation;

import java.util.Objects;
import java.util.regex.Pattern;


public class GrassMachine {

    private static char G = 'G';
    private static char D = 'D';
    private static char A = 'A';

    private Yard yard;

    private int x, y;

    private Oritentation oritentation;

    public GrassMachine(Yard yard) {
        this.yard = yard;

    }

    public boolean verifyPosition(String command) {

        Pattern p = Pattern.compile("\\d\\s\\d\\s[N,E,S,W]"); // e,g 3 1 N

        return Pattern.matches(String.valueOf(p), command);
    }

    public boolean verifyInstructions(String command) {
        Pattern p = Pattern.compile("([G,D]{0,}[A]{0,})*"); // e,g GAGAGGGGAGAAAAA
        return Pattern.matches(String.valueOf(p), command);
    }

    public void putOnPosition(String positionLine) throws Exception {
        int i = Integer.parseInt(String.valueOf(positionLine.charAt(2)));
        int j = Integer.parseInt(String.valueOf(positionLine.charAt(0)));
        if (isPositionIsGood(i, j)) {
            this.x = j;
            this.y = i;
            this.yard.getYard()[x][y] = 1;
            this.oritentation = Oritentation.valueOf(String.valueOf(positionLine.charAt(4)));

        } else throw new Exception("error, machine grass will be off the yard");
    }

    private boolean isPositionIsGood(int i, int j) {
        return j <= this.yard.getYard().length - 1 &&
                i <= this.yard.getYard()[0].length - 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GrassMachine that = (GrassMachine) o;
        return x == that.x && y == that.y && oritentation == that.oritentation;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, oritentation);
    }

    public void move(String instructionsCommand) {
        instructionsCommand.chars().forEach(character -> {
            if (character == G){
                if (Oritentation.N.equals(this.oritentation)){
                    this.oritentation = Oritentation.W;
                    return;
                }
                if (Oritentation.W.equals(this.oritentation)){
                    this.oritentation = Oritentation.S;
                    return;
                }
                if (Oritentation.S.equals(this.oritentation)){
                    this.oritentation = Oritentation.E;
                    return;
                }
                if (Oritentation.E.equals(this.oritentation)){
                    this.oritentation = Oritentation.N;
                    return;
                }
            }
            if (character == D){
                if (Oritentation.N.equals(this.oritentation)){
                    this.oritentation = Oritentation.E;
                    return;
                }
                if (Oritentation.W.equals(this.oritentation)){
                    this.oritentation = Oritentation.N;
                    return;
                }
                if (Oritentation.S.equals(this.oritentation)){
                    this.oritentation = Oritentation.W;
                    return;
                }
                if (Oritentation.E.equals(this.oritentation)){
                    this.oritentation = Oritentation.S;
                    return;
                }

            }
            if (character == A){
                if (Oritentation.N.equals(this.oritentation)){
                    int potentialMove = this.y + 1;
                    if (isPositionIsGood(x,potentialMove)){
                        this.y = potentialMove;
                        this.yard.getYard()[this.x][this.y] = 1;
                        return;
                    }
                }
                if (Oritentation.W.equals(this.oritentation)){
                    int potentialMove = this.x -1;
                    if (isPositionIsGood(x,potentialMove)) {
                        this.x = potentialMove;
                        this.yard.getYard()[this.x][this.y] = 1;
                        return;
                    }

                }
                if (Oritentation.S.equals(this.oritentation)){
                    int potentialMove= this.y -1;
                    if (isPositionIsGood(x,potentialMove)) {
                        this.y = potentialMove;
                        this.yard.getYard()[this.x][this.y] = 1;
                        return;
                    }
                }
                if (Oritentation.E.equals(this.oritentation)){
                    int potentialMove = this.x +1;
                    if (isPositionIsGood(x,potentialMove)) {
                        this.x = potentialMove;
                        this.yard.getYard()[this.x][this.y] = 1;
                        return;

                    }
                }
            }
        });
    }

    public String getPosition() {
        return "x=" + x +
                ", y=" + y +
                ", O=" + oritentation;
    }
}


