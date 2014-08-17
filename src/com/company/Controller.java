package com.company;

/**
 * Created by denislavrov on 25.07.14.
 */
public class Controller extends py2java {

    public static String getActionStatement() {
        return input("WHAT DO YOU WANT TO DO NEXT?").toUpperCase();
    }

    public static int processStatement(String statement) {

        String verb = getVerbFromSentence(statement);
        String noun = getNounFromSentence(statement);

        if (verb.equals("HELP")) {
            Display.HelpMessage();
        } else if ((verb.equals("SCORE") || (verb.equals("SHOW") || verb.equals("LIST")) && noun.equals("SCORE"))) {
            Display.Score(Helper.getScore());
        } else if (verb.equals("CARRYING") || verb.equals("CARRYING?") || verb.equals("INVENTORY") || verb.equals("INV")) {
            Display.Inventory(carrying());
        } else if (verb.equals("GET") || verb.equals("TAKE") || verb.equals("PICKUP")) {
            Display.GetItemMessage(getItem(Helper.getItemID(noun), Data.LocationID), noun);
        } else if (((verb.equals("OPEN") || verb.equals("UNLOCK")) && noun.equals("DOOR")) || (verb.equals("USE") && noun.equals("KEY"))) {
            Display.AttemptOpenDoor(openDoor(Data.LocationID), Data.LocationID);
        } else if (verb.equals("DIG") || (verb.equals("USE") && noun.equals("SHOVEL"))) {
            Display.DigAttempt(dig(Data.LocationID));
        } else if (verb.equals("DROP") || verb.equals("PUT")) {
            Display.DropMessage(dropItem(Helper.getItemID(noun), Data.LocationID), noun);
        } else if (verb.equals("EXAMINE")) {
            Display.ExamineMessage(Display.doExamine(Data.LocationID, noun), noun);
        } else if (verb.equals("SHOW") || verb.equals("LIST") && noun.equals("MAP")) {
            Display.Map();
        } else if (verb.equals("EXIT") || verb.equals("QUIT")) {
            System.exit(0);
        } else if (isMovementVerb(verb, noun)) {
            //System.out.println(Data.DirectionsArray[0].contains(String.valueOf('N')));
            Data.LocationID = go(statement, Data.LocationID);

            print("Data.LocationID=" + Data.LocationID);
        }

        return Data.LocationID;
    }

    public static String carrying() {
        String strItems = "";
        for (int i = 0; i < Data.PositionOfItems.length; i++) {
            if (Data.PositionOfItems[i] == -1) {
                strItems += " " + Data.ItemList[i];
            }
        }
        return strItems;
    }


    public static int dig(int LocationID) {
        if (LocationID == 30 && Helper.isItemInInventory("SHOVEL")) {
            Data.DirectionsArray[LocationID] = "SEW";
            Data.LocationsArray[30] = "HOLE IN WALL";
            return 1;
        } else if (Helper.isItemInInventory("SHOVEL")) {
            return 2;
        }
        return 3;
    }


    public static int go(String statement, int LocationID) {
        char directioncharacter = getMovementDirection(statement);
        if (!isMovementAvailable(directioncharacter, LocationID)) {
            directioncharacter = changeDirectionCharacter(directioncharacter, LocationID);
        }
        if (directioncharacter == 'N') {
            LocationID -= 8;
        } else if (directioncharacter == 'S') {
            LocationID += 8;
        } else if (directioncharacter == 'W') {
            LocationID -= 1;
        } else if (directioncharacter == 'E') {
            LocationID += 1;
        }

        return LocationID;
    }


    public static boolean getItem(int ItemID, int LocationID) {
        if (Helper.isItemAvailableAtLocation(ItemID, LocationID)) {
            Helper.changePositionOfItem(ItemID, -1);
            return true;
        }
        return false;
    }


    public static boolean dropItem(int ItemID, int LocationID) {
        if (Helper.isItemAvailableAtLocation(ItemID, -1)) {
            Helper.changePositionOfItem(ItemID, LocationID);
            return true;
        }
        return false;
    }


    public static boolean openDoor(int LocationID) {
        if (LocationID == 28 && Helper.isItemInInventory("KEY")) {
            Data.DirectionsArray[LocationID] = "SEW";
            return true;
        }
        return false;
    }


    public static void display_position_setting(int locationID) {
        if (locationID == 0) {
            Display.show_dungeon_master();
        }
    }


    public static String getVerbFromSentence(String sentence) {
        if (!Helper.isMultiwordStatement(sentence)) {
            return sentence;
        }
        int locationOfSpace = sentence.indexOf(' ');
        return sentence.substring(0, locationOfSpace);
    }


    public static String getNounFromSentence(String sentence) {
        if (!Helper.isMultiwordStatement(sentence)) {
            return "";
        }
        int locationOfSpace = sentence.indexOf(' ') + 1;
        return sentence.substring(locationOfSpace);
    }


    public static char changeDirectionCharacter(char directioncharacter, int locationID) {
        if (locationID == 20 && directioncharacter == 'U') {
            directioncharacter = 'N';
        } else if (locationID == 20 && directioncharacter == 'D') {
            directioncharacter = 'W';
        } else if (locationID == 22 && directioncharacter == 'U') {
            directioncharacter = 'W';
        } else if (locationID == 22 && directioncharacter == 'D') {
            directioncharacter = 'S';
        } else if (locationID == 36 && directioncharacter == 'U') {
            directioncharacter = 'S';
        } else if (locationID == 36 && directioncharacter == 'D') {
            directioncharacter = 'N';
        } else {
            directioncharacter = ' ';
        }
        return directioncharacter;
    }


    public static boolean isMovementAvailable(char directioncharacter, int LocationID) {
        return Data.DirectionsArray[LocationID].contains(String.valueOf(directioncharacter));
    }


    public static boolean isMovementVerb(String verb, String noun) {
        return verb.equals("N") || verb.equals("S") || verb.equals("E") || verb.equals("W") || verb.equals("U") || verb.equals("D") || verb.equals("GO");
    }


    public static char getMovementDirection(String statement) {
        String verb = getVerbFromSentence(statement);
        String noun = getNounFromSentence(statement);
        if (verb.length() == 1) {
            return verb.charAt(0);
        }
        if (verb.equals("GO")) {
            return noun.charAt(0);
        }
        return ' ';
    }


}
