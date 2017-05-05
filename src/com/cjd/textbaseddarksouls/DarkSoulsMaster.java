package com.cjd.textbaseddarksouls;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.cjd.textbaseddarksouls.enemies.*;

/**
 * DarkSoulsMaster
 * The entry point and main context for the game.
 * This class is the context for the entire game. Static instance
 * variables become global variables. Therefore, avoid putting
 * methods and variables in here unless they must be global, as
 * they will clutter the namespace.
 */
public abstract class DarkSoulsMaster {
    public static final boolean devmode = false; //Devmode - Impossible to lose (for debugging)
    public static final Player player = Player.newPlayer();

    public static void endGame() { //End the game
        System.out.println("YOU DIED");
        System.exit(0); //Shut down entire JVM
    }

    public static void main(String[] args) {
        System.out.println("Devmode: " + devmode);
        System.out.println("You are a " + player);
        List<Enemy> enemyList = new ArrayList<Enemy>(15);
        enemyList.add(new Bandit());
        enemyList.add(new Demon());
        enemyList.add(new Dragon());
        enemyList.add(new Dwarf());
        enemyList.add(new Gargoyle());
        enemyList.add(new Ghoul());
        enemyList.add(new Giant());
        enemyList.add(new Gorgon());
        enemyList.add(new Gremlin());
        enemyList.add(new Griffin());
        enemyList.add(new Knight());
        enemyList.add(new Kobold());
        enemyList.add(new Minion());
        enemyList.add(new Slime());
        enemyList.add(new Wyrm());
        CombatContext combat = new CombatContext(enemyList);
        combat.runCombat();
    }
}
