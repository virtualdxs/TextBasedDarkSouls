package com.cjd.textbaseddarksouls;

import static com.cjd.textbaseddarksouls.DarkSoulsMaster.*; //Give access to master context

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class CombatContext {
  private List<Enemy> enemies;

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

  public void runCombat() {
    Scanner s = new Scanner(System.in);
    int damage;
    while (enemies.size() > 0) {
      //Player combat goes here
      for (Enemy enemy : enemies) { //NPC Combat
        damage = enemy.attack();
        if (damage == 0) {
          System.out.println("The "+ enemy.getClass().getSimpleName() +" misses!");
        } else {
          System.out.println("The "+ enemy.getClass().getSimpleName() +" hits!");
          System.out.println("It deals " + damage + " damage!");
          player.dealDamage(damage);
          System.out.println("Your health is now " + player.getHealth() + ".");
        }
        s.nextLine();
      }
    }
  }
}
