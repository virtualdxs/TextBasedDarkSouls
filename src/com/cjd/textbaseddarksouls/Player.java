package com.cjd.textbaseddarksouls;

import java.util.Scanner;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;

import com.cjd.textbaseddarksouls.spell.AttackSpell;
import com.cjd.textbaseddarksouls.spell.GenericSpell;
import com.cjd.textbaseddarksouls.player.*;

import static com.cjd.textbaseddarksouls.Master.*; //Give access to master context

public abstract class Player {
    public final String name;
    protected int health;
    protected int power; //Magical power
    protected int level;
    protected int enemiesDefeated;
    protected Random random = new Random(); //RNG
    protected List<AttackSpell> attackSpellInventory = new ArrayList<AttackSpell>();
    protected List<GenericSpell> genericSpellInventory = new ArrayList<GenericSpell>();
    protected List<Potion> potionInventory = new ArrayList<Potion>();
    protected List<Item> itemInventory = new ArrayList<Item>();

    protected final int MAX_HEALTH = 100;
    protected final int MAX_LEVEL = 100;
    protected int MAX_POWER; //Max magical power
    protected int POWER_MULTIPLIER = 3; //MAX_POWER = POWER_MULTIPLIER * level
    protected int HIT_CHANCE = 80;

    public Player(String name) {
        this.name = name;
        this.health = 100;
        this.level = 1;
        this.MAX_POWER = 3*level; //Max magical power
        this.power = this.MAX_POWER; //Fill power
    }

    /**
     * Interactively create a new player
     * @return The new player
     */
    public static Player newPlayer() {
      Scanner scanner = new Scanner(System.in);
      System.out.println("Welcome! What is your name?");
      String name = "";
      while(name.equals("")) name = scanner.nextLine();
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

    /**
     * Create a new player from a PlayerClass and name.
     * @param playerClass The class of the new player
     * @param name The name of the new player
     * @return The new player
     */
    public static Player newPlayer(PlayerClass playerClass,String name) {
      switch (playerClass) {
        case RAN:
          return new Ranged(name);
        case WAR:
          return new Warrior(name);
        case WIZ:
          return new Wizard(name);
        default:
          return null; //To get Java to compile it
      }
    }

    /**
     * Deals damage to the player
     * @param points The number of health to subtract
     */
    public void dealDamage(int points) {
        if (devmode) return; //Prevent damage if in devmode
        if (points >= health) endGame(); //Enough damage to kill the player
        else health -= points;
    }

    /**
     * Heals the player
     * @param points The number of points to add
     */
    public void heal(int points) {
        if (devmode) return; //Prevent healing if in devmode
        if (points > MAX_HEALTH-health) health = MAX_HEALTH; //Prevent player from healing past MAX_HEALTH
        else health += points;
    }

    /**
     * Use up some of the player's magic energy.
     * @param energy The amount of energy to subtract
     */
    public void usePower(int usedPower) {
      if (devmode) return; //Prevent damage if in devmode
      if (usedPower < 1) throw new IllegalArgumentException();
      power -= usedPower;
    }
    /**
     * Adds to the enemies defeated counter.
     * @param enemies The number of enemies to add to the counter
     */
    public void addEnemiesDefeated(int enemies) {
      enemiesDefeated += enemies;
    }

    /**
    * Calculates damage for a player attack
    * @return int Damage of the attack
    */
    public int attack() {
      //Calculate hit or miss;damage is random between 5 and 15
      return random.nextInt(100) > HIT_CHANCE ? 0 : random.nextInt(10)+6;
    }

    /**
    * Allows the player to cast a spell.
    * @param enemies List of enemies, in case player uses an attack spell
    * @return True if player successfully drank a potion; false otherwise
    */
    public boolean castSpell(List<Enemy> enemies) {
      Scanner s = new Scanner(System.in);
      System.out.println("\n1. Attack spell\nor\n2. Generic spell?");
      int selection = s.nextInt();
      if (selection != 1 && selection != 2) return false;
      switch (selection) {
        case 1:
          return castAttackSpell(enemies);
        case 2:
          return castGenericSpell();
        default:
          return false;
      }
    }

    /**
     * Gives the player the provided attack spell.
     * @param spell The attack spell to give the player
     * @return True if the player successfully learned the spell; false otherwise
     */
    public boolean giveAttackSpell(AttackSpell spell) {
      if (spell.getMinLevel() > level) return false;
      attackSpellInventory.add(spell);
      return true;
    }

    /**
     * Allows the player to cast an attack spell.
     * @param enemies List of enemies
     * @return True if player successfully drank a potion; false otherwise
     */
    public boolean castAttackSpell(List<Enemy> enemies) {
      if (attackSpellInventory.size() == 0) {
        System.out.println("You have no attack spells!");
        return false;
      }
      Scanner s = new Scanner(System.in);
      System.out.println("\nWhich spell?");
      for (int i = 0;i < attackSpellInventory.size();i++) {
        System.out.println(i + ". " + attackSpellInventory.get(i));
      }
      int selection = s.nextInt();
      if (selection < 0 || selection > attackSpellInventory.size() - 1) return false;
      return attackSpellInventory.get(selection).cast(enemies);
    }

    /**
     * Gives the player the provided generic spell.
     * @param spell The generic spell to give the player
     * @return True if the player successfully learned the spell; false otherwise
     */
    public boolean giveGenericSpell(GenericSpell spell) {
      if (spell.getMinLevel() > level) return false;
      genericSpellInventory.add(spell);
      return true;
    }

    /**
     * Allows the player to cast a generic spell.
     * @return True if player successfully drank a potion; false otherwise
     */
    public boolean castGenericSpell() {
      if (genericSpellInventory.size() == 0) {
        System.out.println("You have no generic spells!");
        return false;
      }
      Scanner s = new Scanner(System.in);
      System.out.println("\nWhich spell?");
      for (int i = 0;i < genericSpellInventory.size();i++) {
        System.out.println(i + ". " + genericSpellInventory.get(i));
      }
      int selection = s.nextInt();
      if (selection < 0 || selection > genericSpellInventory.size() - 1) return false;
      return genericSpellInventory.get(selection).cast();
    }

   /**
    * Gives the player a potion.
    * @param potion The potion to give
    */
    public void givePotion(Potion potion) {
      potionInventory.add(potion);
    }

   /**
    * Allows the user to drink a potion.
    * @return True if player successfully drank a potion; false otherwise
    */
    public boolean drinkPotion() {
      if (potionInventory.size() == 0) {
        System.out.println("You don't have any potions!");
        return false;
      }
      System.out.println("Which potion would you like to drink?");
      for (int i=0;i<potionInventory.size();i++) {
        System.out.println(i + ". " + potionInventory.get(i));
      }
      int selection = new Scanner(System.in).nextInt();
      if (selection < 0 || selection > potionInventory.size() - 1) return false;
      potionInventory.remove(selection).drink();
      return true;
    }

    /**
     * Takes care of what needs to be done after a turn.
     *  - Regens power and health
     *  - Levels up player if needed
     * NOTE: Does NOT get run during combat.
     * Player levels up when they have defeated 2^n enemies where n is the level they are moving to.
     * For example, a Level 3 player must have defeated a total of 2^4 (16) enemies in order to level up.
     */
    public void runTurn() {
      if (power < MAX_POWER) power++;
      if (health < MAX_HEALTH) health++;
      while (enemiesDefeated >= Math.pow(2,level+1)) levelUp();
    }

    /**
     * Levels up the player.
     */
    private void levelUp() {
      System.out.println("Congratulations! You are now level " + ++level + "!");
      this.MAX_POWER = POWER_MULTIPLIER*level; //Updates max power
      power = MAX_POWER; //Instantly fills up power
    }

    public String toString() { return "level " + level + " " + this.getClass().getSimpleName()+" with " + health + " health"; }

    public int getLevel(){ return level; }
    public int getPower(){ return power; }
    public int getMaxPower(){ return MAX_POWER; }
    public int getHealth() { return health; }

    private enum PlayerClass {
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
