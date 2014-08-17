package com.company;



public class Display extends py2java {

    public static void show_dungeon_master() {
        print("\nHello my son, I'm the housekeeper!\n" +
                "Your task here is to find all of these items:\n" + join(Data.ItemList) +
                "And find the path through an iron gate.");
    }

    public static void GameName() {
        print("========Haunted House=========");
    }

    public static void Position(int LocationID) {
        print("YOU ARE LOCATED IN A " + Data.LocationsArray[LocationID]);
    }

    public static void ItemsAtPosition(int LocationID) {
        if (Helper.itemsAvailableAtPosition(LocationID)) {
            print("YOU CAN SEE THE FOLLOWING ITEMS AT THIS LOCATION: " + Helper.listItemsAtPosition(LocationID));
        }
    }

    public static void VisibleExitsAtPosition(int LocationID) {
        String exits = Data.DirectionsArray[LocationID];
        String exits_buffer = "";
        if (exits.contains("S")) {
            exits_buffer += " " + "South";
        }
        if (exits.contains("N")) {
            exits_buffer += " " + "North";
        }
        if (exits.contains("E")) {
            exits_buffer += " " + "East";
        }
        if (exits.contains("W")) {
            exits_buffer += " " + "West";
        }

        print("Visible exits are" + exits_buffer);
    }

    public static void ListOfVerbs() {
        print(join(Data.VerbList, " "));
    }

    public static void HelpMessage() {
        print("I UNDERSTAND THE FOLLOWING WORDS{");
        ListOfVerbs();
    }


    public static void GetItemMessage(boolean successful, String noun) {
        if (successful) {
            print("YOU ARE NOW CARRYING A " + noun);
        } else {
            print("SORRY YOU CANNOT TAKE A " + noun);
        }
    }

    public static void Inventory(String strInventory) {
        if (strInventory.length() == 0) {
            strInventory = "NOTHING";
        }
        print("YOU ARE CARRYING:" + strInventory);
    }


    public static void Score(int score) {
        print("YOUR CURRENT SCORE IS:" + score);
    }


    public static void TheDoorIsLockedMessage() {
        print("THE DOOR IS LOCKED");
    }


    public static void OpenDoorMessage() {
        print("THE DOOR IS NOW OPEN! REVEALING A NEW EXIT!");
    }


    public static void DropMessage(boolean dropped, String item) {
        if (dropped) {
            print("YOU HAVE DROPPED THE " + item);
        } else {
            print("YOU CANNOT DROP THAT WHICH YOU DO NOT POSSESS");
        }
    }


    public static void DigAttempt(int DigMessageType) {
        if (DigMessageType == 1) {
            print("YOU DIG AROUND THE ROOM. THE BARS BECOME LOOSE. A NEW EXIT!");
        } else if (DigMessageType == 2) {
            print("YOU DIG A LITTLE HOLE.");
        } else {
            print("WHAT WITH?");
        }
    }


    public static void AttemptOpenDoor(boolean opened, int LocationID) {
        if (opened) {
            OpenDoorMessage();
        } else {
            TheDoorIsLockedMessage();
        }
    }

    public static int examineCoat(int LocationID) {
        if (LocationID == 32 && Helper.isItemAvailableAtLocation(Helper.getItemID("Key"), 100)) {
            Data.PositionOfItems[Helper.getItemID("KEY")] = 32;
            return 1;
        } else if (LocationID == 32 && !Helper.isItemAvailableAtLocation(Helper.getItemID("Key"), 100)) {
            return 2;
        }
        return 99;
    }

    public static int examineDrawer(int LocationID) {
        if (LocationID == 43 && Helper.isItemInInventory("KEY")) {
            return 3;
        } else if (LocationID == 43 && !Helper.isItemInInventory("KEY")) {
            return 4;
        }
        return 99;
    }


    public static int examineRubbish(int LocationID) {
        if (LocationID == 3) {
            return 5;
        }
        return 99;
    }

    public static int examineWall(int LocationID) {
        if (LocationID == 43) {
            Data.LocationsArray[LocationID] = "STUDY WITH DESK";
            Data.DirectionsArray[LocationID] = "NW";
            return 6;
        }
        return 7;
    }


    public static int examineDoor(int LocationID) {
        if (LocationID == 28 && Helper.isItemInInventory("KEY")) {
            Data.DirectionsArray[LocationID] = "SEW";
            return 8;
        } else if (LocationID == 28 && !Helper.isItemInInventory("KEY")) {
            return 9;
        }
        return 99;
    }


    public static int doExamine(int LocationID, String noun) {
        if (noun.equals("COAT")) {
            return examineCoat(LocationID);
        }
        if (noun.equals("DRAWER")) {
            return examineDrawer(LocationID);
        }
        if (noun.equals("RUBBISH")) {
            return examineRubbish(LocationID);
        }
        if (noun.equals("WALL")) {
            return examineWall(LocationID);
        }
        if (noun.equals("DOOR")) {
            return examineDoor(LocationID);
        }

        return 99;
    }


    public static void ExamineMessage(int MessageID, String noun) {
        if (MessageID == 1) {
            print("YOU EXAMINE THE COAT AND FIND A KEY IN THE POCKET");
        } else if (MessageID == 2) {
            print("IT\'S A DIRTY OLD COAT");
        } else if (MessageID == 3) {
            print("YOU UNLOCK THE DRAWER AND FIND IT IS EMPTY");
        } else if (MessageID == 4) {
            print("UNFORTUNATELY THE DRAWER IS LOCKED");
        } else if (MessageID == 5) {
            print("THE RUBBISH IS FILTHY");
        } else if (MessageID == 6) {
            print("YOU LOOK AT THE WALL AND DISCOVER IT IS FALSE!\nYOU DISCOVER A NEW EXIT");
        } else if (MessageID == 7) {
            print("NO INTERESTING WALLS HERE");
        } else if (MessageID == 8) {
            print("YOU UNLOCK THE DOOR AND DISCOVER A NEW LOCATION!");
        } else if (MessageID == 9) {
            print("UNFORTUNATELY THE DOOR IS LOCKED");
        } else if (MessageID == 88) {
            print("NO INTERESTING " + noun + "HERE...");
        } else if (MessageID == 99) {
            print("WHAT " + noun + "?");
        }
    }


    public static String printableInts(int value) {
        if (value < 10) {
            return " " + str(value);
        }
        return str(value);
    }


    public static void Map() {
        String Line1 = "";
        String Line2 = "";
        String Line3 = "";

        for (int Index = 0; Index < 64; Index++) {
            String currentValues = Data.DirectionsArray[Index];


            if (currentValues.contains("N")) {
                Line1 += "+  +";
            } else {
                Line1 += "+--+";
            }

            if (currentValues.contains("W")) {
                Line2 += (" ") + printableInts(Index);
            } else {
                Line2 += ("|") + printableInts(Index);
            }

            if (currentValues.contains("E")) {
                Line2 += (" ");
            } else {
                Line2 += ("|");
            }

            if (currentValues.contains("S")) {
                Line3 += "+  +";
            } else {
                Line3 += "+--+";
            }

            if ((Index + 1) % 8 == 0) {
                print(Line1);
                print(Line2);
                print(Line3);
                Line1 = "";
                Line2 = "";
                Line3 = "";
            }


        }
    }
}
