package com.company;

import java.util.Scanner;

/**
 * Created by denislavrov on 25.07.14.
 */


public class py2java {
    public static void print(String arg) {
        System.out.println(arg);
    }

    public static String join(String[] args, String sep) {
        String retbuf = "";
        for (String str : args) {
            retbuf += sep + str;
        }
        return retbuf;
    }

    public static String join(String[] args) {
        String retbuf = "";
        for (String str : args) {
            retbuf += str;
        }
        return retbuf;
    }

    public static String str(int sint) {
        return Integer.toString(sint);
    }

    public static String input(String prompt) {
        Scanner ins = new Scanner(System.in);
        System.out.println(prompt);
        return ins.nextLine();
    }


}
