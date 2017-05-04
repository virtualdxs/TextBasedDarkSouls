package com.cjd.TextBasedDarkSouls;

import java.util.Arrays;
import java.util.List;

/**
 * DarkSoulsMaster
 * The entry point and main context for the game.
 * This class is the context for the entire game. Static instance variables become global variables
 * Avoid putting methods and variables in here, as they will clutter the namespace.
 */
public abstract class DarkSoulsMaster {
    public static final boolean devmode = true;

    public static void endGame() {
        System.out.println("YOU DIED");
        System.exit(0);
    }

    public static void main(String[] args) {
        System.out.println(devmode);
    }
}
