package com.cjd.textbaseddarksouls;

import java.util.Scanner;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;

import static com.cjd.textbaseddarksouls.DarkSoulsMaster.*; //Give access to master context

public abstract class Player {
    public final String name;
    protected int health;
    protected Random random = new Random();
    protected List<Spell> spellInventory = new ArrayList<Spell>();
    protected List<Potion> potionInventory = new ArrayList<Potion>();

    protected final int MAX_HEALTH = 100;
    protected int HIT_CHANCE = 80;

    public Player(String name) {
        this.name = name;
        this.health = 100;
    }

    public static Player newPlayer() {
      Scanner scanner = new Scanner(System.in);
      System.out.println("Welcome! What is your name?");
      String name = scanner.nextLine();
      System.out.println("Hello, "+name+"! What class do you want to play?");
      PlayerClass playerClass = null;
      while (playerClass == null) {
      System.out.println("Valid options are Ranged, Warrior, and Wizard.");
        switch (scanner.nextLine().toLowerCase()) {
        case "ranged":
          playerClass = PlayerClass.RAN;
          break;
        case "warrior":
          playerClass = PlayerClass.WAR;
          break;
        case "wizard":
          playerClass = PlayerClass.WIZ;
          break;
        default:
          System.out.println("Please enter a valid class.");
        }
      }
      return newPlayer(playerClass,name);
    }

    public static Player newPlayer(PlayerClass playerClass,String name) {
      switch (playerClass) {
        case RAN:
          return new Ranged(name);
        case WAR:
          return new Warrior(name);
        case WIZ:
          return new Wizard(name);
        default:
          return null;
      }
    }

    public void dealDamage(int points) {
        if (devmode) return; //Prevent damage if in devmode
        if (points >= health) endGame(); //Enough damage to kill the player
        else health -= points;
    }

    public void heal(int points) {
        if (devmode) return; //Prevent healing if in devmode
        if (points > MAX_HEALTH-health) health = MAX_HEALTH; //Prevent player from healing past MAX_HEALTH
        else health += points;
    }

    /**
    * Calculates damage for a player attack
    * @return int Damage of the attack
    */
    public int attack() {
      //Calculate hit or miss;damage is random between 5 and 15
      return random.nextInt(100)>HIT_CHANCE ? 0 : random.nextInt(10)+6;
    }

    public int getHealth() {
      return health;
    }

    /**
    * Allows the player to cast a spell.
    * @param combatContext The combat context
    * @param enemies List of enemies
    * @return True if player successfully drank a potion; false otherwise
    */
    public boolean castSpell(CombatContext combatContext,List<Enemy> enemies) {
      System.out.println("Not yet implemented");
      return false;
    }

    /**
    * Allows the user to drink a potion.
    * @return True if player successfully drank a potion; false otherwise
    */
    public boolean drinkPotion() {
      System.out.println("Not yet implemented");
      return false;
    }

    public String toString() {
      return this.getClass().getSimpleName()+" with "+health+" health";
    }

    public enum PlayerClass {
      RAN("Ranged"),
      WAR("Warrior"),
      WIZ("Wizard");

      private String name;

      PlayerClass(String name) {
        this.name = name;
      }

      public String toString() {
        return name;
      }
    }
}
