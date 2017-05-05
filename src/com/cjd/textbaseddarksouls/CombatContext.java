package com.cjd.textbaseddarksouls;

import java.util.List;
import java.util.ArrayList;

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
    //To be implemented later
  }
}
