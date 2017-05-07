package com.cjd.textbaseddarksouls.spell;

import static com.cjd.textbaseddarksouls.Master.*; //Give access to master context

import java.util.List;
import java.util.Scanner;
import com.cjd.textbaseddarksouls.Enemy;

public class Shockwave implements AttackSpell {
  public static final int DAMAGE = 3;
  public static final int MIN_LEVEL= 3;
  public static final int REQ_POWER = 5;

  public int getReqPower() { return REQ_POWER; }
  public int getMinLevel() { return MIN_LEVEL; }
  
  public String toString() { return "Shockwave"; }

  public boolean cast(List<Enemy> enemies) {
    if(player.getLevel() < MIN_LEVEL) throw new com.cjd.textbaseddarksouls.exception.LevelTooLowException();
    if(player.getPower() < REQ_POWER) return false;
    for (int i=0;i<enemies.size();i++) {
      enemies.get(i).dealDamage(DAMAGE);
    }
    System.out.println("Shockwave! All enemies lost " + DAMAGE + " health.");
    return true;
  }
}
