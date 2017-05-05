package com.cjd.textbaseddarksouls;

import static com.cjd.textbaseddarksouls.DarkSoulsMaster.*; //Give access to master context

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class CombatContext {
  private List<Enemy> enemies;
  private Scanner s = new Scanner(System.in);

  public CombatContext() {
    enemies = new ArrayList<Enemy>();
  }

  public CombatContext(List<Enemy> enemyList) {
    enemies = enemyList;
  }

  public void add(Enemy newEnemy) {
    enemies.add(newEnemy);
  }

  public boolean combatOver() {
    return enemies.size() == 0;
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

  public void runCombat() {
    int damage;
    Enemy target;
    while (enemies.size() > 0) {
      target = enemies.get(chooseTarget());
      damage = player.attack();
      if (damage > 0) {
        target.dealDamage(damage);
        System.out.println("You hit the " + target.getClass().getSimpleName() + ", doing "+ damage + " damage!");
      } else {
        System.out.println("You miss the " + target.getClass().getSimpleName() + "!");
      }
      //Player combat goes here
      for (int i=0;i<enemies.size();i++) { //NPC Combat
        Enemy enemy = enemies.get(i);
        if (enemy.getHealth() == 0) {
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
      }
    }
    System.out.println("You have defeated all the enemies. Your health is " + player.getHealth() + ".");
  }
}
