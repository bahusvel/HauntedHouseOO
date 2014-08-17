package com.company;


public class Main {


    public static void main(String[] args) {
        // Declaration

        // Logic
        int LocationID = 0;

        while (!Helper.isEndOfGame(LocationID, Helper.getScore())) {
            Display.GameName();
            Display.Position(LocationID);
            Display.ItemsAtPosition(LocationID);
            Display.VisibleExitsAtPosition(LocationID);
            //Display.position_setting(LocationID);
            LocationID = Controller.processStatement(Controller.getActionStatement());
        }
        // end of main
    }

}
