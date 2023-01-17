package com.grass;

public class ReadInput {
    private GrassMachine grassMachine;

    public ReadInput(GrassMachine grassMachine) {
        this.grassMachine = grassMachine;
    }

    public boolean verifyOrderOfInput(String firstCommand, String secondCommand, String thirdCommand,
                                      String fourthLine, String fifthLine) {
        if (new Yard(firstCommand).verifyFirstLineYardCommand(firstCommand)
                && this.grassMachine.verifyPosition(secondCommand)
                && this.grassMachine.verifyInstructions(thirdCommand)
                && this.grassMachine.verifyPosition(fourthLine)
                && this.grassMachine.verifyInstructions(fifthLine)) {
            return true;
        }
        return false;
    }
}
