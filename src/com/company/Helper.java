package com.company;

import java.util.Arrays;

/**
 * Created by denislavrov on 25.07.14.
 */
public class Helper {

    public static boolean isMultiwordStatement(String value) {
        return value.contains(" ");
    }


    public static boolean isItemAvailableAtLocation(int ItemID, int LocationID) {
        return Data.PositionOfItems[ItemID] == LocationID;
    }


    public static boolean isItemInInventory(String name) {
        return isItemAvailableAtLocation(getItemID(name), -1);
    }


    public static void changePositionOfItem(int ItemID, int newLocationID) {
        Data.PositionOfItems[ItemID] = newLocationID;
    }

    public static int getItemID(String item) {
        return Arrays.asList(Data.ItemList).indexOf(item);
    }

    public static String listItemsAtPosition(int LocationID) {
        String strItems = "";
        for (int i = 0; i < Data.PositionOfItems.length; i++) {
            if (Data.PositionOfItems[i] == LocationID) {
                strItems += " " + Data.ItemList[i];
            }
        }
        return strItems;
    }


    public static boolean itemsAvailableAtPosition(int LocationID) {
        for (int i = 0; i < Data.PositionOfItems.length; i++) {
            if (Data.PositionOfItems[i] == LocationID) {
                return true;
            }
        }
        return false;
    }


    public static boolean isEndOfGame(int locationID, int score) {
        return (score == 17) && (locationID == 57);
    }

    public static int getScore() {
        int score = 0;
        for (int i = 0; i < Data.PositionOfItems.length; i++) {
            if (Helper.isItemAvailableAtLocation(i, -1)) {
                score++;
            }
        }
        return score;
    }
}
