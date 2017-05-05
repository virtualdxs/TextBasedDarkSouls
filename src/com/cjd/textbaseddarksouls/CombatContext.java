package com.cjd.textbaseddarksouls;

import static com.cjd.textbaseddarksouls.DarkSoulsMaster.*; //Give access to master context

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class CombatContext {
  private List<Enemy> enemies;
  private Scanner s = new Scanner(System.in);

  private final int SLEEP_TIME = 750; //Time to sleep between attacks

  public CombatContext() {
    enemies = new ArrayList<Enemy>();
  }

  public CombatContext(List<Enemy> enemyList) {
    enemies = enemyList;
  }

  public void add(Enemy newEnemy) {
    enemies.add(newEnemy);
  }

  public int chooseTarget() {
    int selection = -1;
    while (selection < 0 || selection >= enemies.size()) {
    System.out.println("Which enemy would you like to attack? Options are:");
      for (int i=0;i<enemies.size();i++) {
        System.out.println(i+". " + enemies.get(i));
      }
      selection = s.nextInt();
      s.nextLine(); //Eat newline given to us
    }
    return selection;
  }

  private void playerCombat() {
    int damage;
    Enemy target;
    target = enemies.get(chooseTarget());
    damage = player.attack();
    if (damage > 0) {
      target.dealDamage(damage);
      System.out.println("You hit the " + target.getClass().getSimpleName() + ", doing "+ damage + " damage!");
    } else {
      System.out.println("You miss the " + target.getClass().getSimpleName() + "!");
    }
    try {Thread.sleep(SLEEP_TIME);} catch (java.lang.InterruptedException boi) {} //Pause for 1 second after attacking
  }

  private void npcCombat() {
    int damage;
    for (int i=0;i<enemies.size();i++) {
      Enemy enemy = enemies.get(i);
      if (enemy.getHealth() == 0) { //Garbage collect dead enemies
        enemies.remove(i);
        continue;
      }
      damage = enemy.attack();
      if (damage == 0) {
        System.out.println("The "+ enemy.getClass().getSimpleName() +" misses!");
      } else {
        System.out.println("The "+ enemy.getClass().getSimpleName() +" hits!");
        System.out.println("It deals " + damage + " damage!");
        player.dealDamage(damage);
        System.out.println("Your health is now " + player.getHealth() + ".");
      }
      try {Thread.sleep(SLEEP_TIME);} catch (java.lang.InterruptedException boi) {} //Pause for 1 second between attacts
    }
  }

  public void runCombat() {
    int damage;
    while (enemies.size() > 0) {
      boolean done = false;
      int selection;
      while (!done) {
        System.out.println("What would you like to do?\n1. Fight\n2. Cast a spell\n3. Drink a potion");
        selection = s.nextInt();
        s.nextLine(); //Eat newline given to us
        switch (selection) {
          case 1:
            playerCombat();
            done = true;
            break;
          case 2:
            done = player.castSpell(this,enemies);
            break;
          case 3:
            done = player.drinkPotion();
            break;
          default:
            System.out.println("Invalid selection.");
        }
      }
      npcCombat();
    }
    System.out.println("You have defeated all the enemies. Your health is " + player.getHealth() + ".");
  }
}
