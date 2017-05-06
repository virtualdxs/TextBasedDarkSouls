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
        System.out.println("When you died, you were at level " + player.getLevel() + ".");
        System.exit(0); //Shut down entire JVM
    }

    public static void printStats() {
        System.out.println("Current level: " + player.getLevel());
        System.out.println("Current health: " + player.getHealth());
        System.out.println("Current power: " + player.getPower());
        System.out.println("Current max power: " + player.getMaxPower());
    }

    public static void main(String[] args) {
        System.out.println("Devmode: " + devmode);
        System.out.println("You are a " + player + ".");
        printStats();
        System.out.println("Setting kill count to 16...");
        player.addEnemiesDefeated(16);
        System.out.println("Running a turn...");
        player.runTurn();
        printStats();
        player.giveGenericSpell(new com.cjd.textbaseddarksouls.spell.Heal());
        System.out.println("Running a combat stage...");
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
