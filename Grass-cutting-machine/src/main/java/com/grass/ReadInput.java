package com.grass;

public class ReadInput {
    private GrassMachine grassMachine;

    public ReadInput(GrassMachine grassMachine) {
        this.grassMachine = grassMachine;
    }

    public boolean verifyOrderOfInput(String firstCommand, String secondCommand, String thirdCommand) {
       if( new Yard(firstCommand).verifyFirstLineYardCommand(firstCommand)
        && this.grassMachine.verifyPosition(secondCommand)
         && this.grassMachine.verifyInstructions(thirdCommand)){
           return true;
       }
       return false;
    }
}
