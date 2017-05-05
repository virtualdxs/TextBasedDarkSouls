package com.cjd.textbaseddarksouls;

import java.util.Arrays;
import java.util.List;

/**
 * DarkSoulsMaster
 * The entry point and main context for the game.
 * This class is the context for the entire game. Static instance
 * variables become global variables. Therefore, avoid putting
 * methods and variables in here unless they must be global, as
 * they will clutter the namespace.
 */
public abstract class DarkSoulsMaster {
    public static final boolean devmode = true; //Devmode - Impossible to lose (for debugging)
    public static final Player player = Player.newPlayer();

    public static void endGame() { //End the game
        System.out.println("YOU DIED");
        System.exit(0); //Shut down entire JVM
    }

    public static void main(String[] args) {
        System.out.println("Devmode: " + devmode);
        System.out.println("You are a " + player);
    }
}
