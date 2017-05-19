package com.cjd.textbaseddarksouls;

import static com.cjd.textbaseddarksouls.Master.*; //Give access to master context

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class CombatContext {
  private List<Enemy> enemies;
  private Scanner s = new Scanner(System.in);

  private final int SLEEP_TIME = 750; //Time to sleep between attacks, in milliseconds

  public CombatContext() {
    enemies = new ArrayList<Enemy>();
  }

  public CombatContext(List<Enemy> enemyList) {
    enemies = enemyList;
  }

  public void add(Enemy newEnemy) {
    enemies.add(newEnemy);
  }

  private int chooseTarget() {
    System.out.println("\nWhich enemy would you like to attack? Options are:");
    for (int i=0;i<enemies.size();i++) {
      System.out.println(i+". " + enemies.get(i));
    }
    int selection = s.nextInt();
    s.nextLine(); //Eat newline given to us
    if (selection < 0 || selection >= enemies.size()) {
      return -1;
    }
    return selection;
  }

  private boolean playerCombat() {
    int targetNum = chooseTarget();
    if (targetNum == -1) return false;
    Enemy target = enemies.get(targetNum);
    int damage = player.attack();
    if (damage > 0) {
      System.out.println("You hit the " + target.getClass().getSimpleName() + ", doing "+ damage + " damage!");
      target.dealDamage(damage);
    } else {
      System.out.println("You miss the " + target.getClass().getSimpleName() + "!");
    }
    try {Thread.sleep(SLEEP_TIME);} catch (java.lang.InterruptedException boi) {} //Pause for 1 second after attacking
    return true;
  }

  private void removeDeadEnemies() {
    for (int i = enemies.size()-1;i >= 0;i--) {
      if (enemies.get(i).getHealth() == 0) {
        enemies.remove(i);
        continue;
      }
    }
  }

  private void npcCombat() {
    removeDeadEnemies();
    int damage;
    for (int i=0;i<enemies.size();i++) {
      Enemy enemy = enemies.get(i);
      damage = enemy.attack();
      if (damage == 0) {
        System.out.println("The "+ enemy.getClass().getSimpleName() +" misses!");
      } else {
        System.out.print("The "+ enemy.getClass().getSimpleName() +" hits! ");
        System.out.println("It does " + (int)((damage * (100-player.getArmorProtection())/100.0)+0.5) + " damage!");
        player.dealDamage(damage);
        System.out.println("Your health is now " + player.getHealth() + ".");
      }
      try {Thread.sleep(SLEEP_TIME);} catch (java.lang.InterruptedException e) {} //Pause for 1 second between attacts
    }
  }

  public void runCombat() {
    int enemiesToDefeat = enemies.size();
    int damage;
    System.out.println("\n-----COMBAT-----");
    while (enemies.size() > 0) {
      boolean done = false;
      int selection;
      while (!done) {
        System.out.println("Current enemies:");
        for (int i=0;i<enemies.size();i++) {
          System.out.println(enemies.get(i));
        }
        System.out.println("\nWhat would you like to do?\n1. Fight\n2. Cast a spell\n3. Drink a potion");
        selection = s.nextInt();
        s.nextLine(); //Eat newline given to us
        switch (selection) {
          case 1:
            done = playerCombat();
            break;
          case 2:
            done = player.castSpell(enemies);
            if (done) System.out.println("Your health is now " + player.getHealth() + ".");
            else {
              System.out.println("Not enough power to cast that spell.");
              for (int i=0;i<enemies.size();i++) {
                Enemy enemy = enemies.get(i);
                if (enemy.getHealth() == 0) { //Garbage collect dead enemies
                  enemies.remove(i);
                }
              }
            }
            break;
          case 3:
            done = player.drinkPotion();
            break;
          default:
            System.out.println("Invalid selection.");
        }
      }
      npcCombat();
      removeDeadEnemies();
    }
    System.out.println("You have defeated all the enemies. Your health is " + player.getHealth() + ".");
    player.addEnemiesDefeated(enemiesToDefeat);
  }
}
