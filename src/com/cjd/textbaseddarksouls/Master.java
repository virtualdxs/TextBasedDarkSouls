package com.cjd.textbaseddarksouls;


import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import com.cjd.textbaseddarksouls.enemy.*;

/**
* Master
* The entry point and main context for the game.
* This class is the context for the entire game. Static instance
* variables become global variables. Therefore, avoid putting
* methods and variables in here unless they must be global, as
* they will clutter the namespace.
*/
public abstract class Master {
  public static final boolean devmode = false; //Devmode - Impossible to lose health or power (for debugging)
  public static final Player player = Player.newPlayer();

  public static void endGame() { //End the game
    System.out.println("YOU DIED");
    System.out.println("When you died, you were at level " + player.getLevel() + ".");
    System.exit(0); //Shut down entire JVM
  }

  public static String getResponse() {
    Scanner s = new Scanner(System.in);
    String response = "";
    while (response.equals("")) response = s.nextLine().toLowerCase();
    return response;
  }

  public static int getIntResponse(int max) {
    Scanner s = new Scanner(System.in);
    int response = s.nextInt();
    while (response < 1 || response > max) {
      System.out.println("Please enter a number between 1 and " + max + ".");
      response = s.nextInt();
    }
    return response;
  }

  public static void printStats() {
    System.out.println("\n-----STATS-----");
    System.out.println("Current level: " + player.getLevel());
    System.out.println("Current health: " + player.getHealth());
    System.out.println("Current max health: " + player.getMaxHealth());
    System.out.println("Current armor: " + player.getArmorProtection());
    System.out.println("Current power: " + player.getPower());
    System.out.println("Current max power: " + player.getMaxPower());
    System.out.println();
  }

  public static void init() {} //Call this to initialize this class (i.e. create player)

  public static void main(String[] args) {
    //System.out.println("Devmode: " + devmode);
    System.out.println("You are " + player + ".");
    System.out.println("Giving player max health...");
    player.heal(100);
    System.out.println("Leveling player to max...");
    player.addEnemiesDefeated(1024);
    player.runTurn();
    System.out.println("Giving player max armor (you're going to need it)...");
    player.setArmorProtection(50);
    System.out.println("Giving player spells and potions...");
    player.giveGenericSpell(new com.cjd.textbaseddarksouls.spell.Heal());
    player.giveAttackSpell(new com.cjd.textbaseddarksouls.spell.ForceBolt());
    player.giveAttackSpell(new com.cjd.textbaseddarksouls.spell.Fireball());
    player.giveAttackSpell(new com.cjd.textbaseddarksouls.spell.Shockwave());
    player.givePotion(new com.cjd.textbaseddarksouls.potion.HealingPotion());
    player.givePotion(new com.cjd.textbaseddarksouls.potion.HealingPotion());
    player.givePotion(new com.cjd.textbaseddarksouls.potion.ExtraHealingPotion());
    printStats();
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
