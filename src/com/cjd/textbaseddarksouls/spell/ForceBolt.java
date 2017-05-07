package com.cjd.textbaseddarksouls.spell;

import static com.cjd.textbaseddarksouls.Master.*; //Give access to master context

import java.util.List;
import java.util.Scanner;
import java.util.Random;
import com.cjd.textbaseddarksouls.Enemy;
import com.cjd.textbaseddarksouls.AttackSpell;

public class ForceBolt implements AttackSpell {
  public static final int DAMAGE = 15;
  public static final int MIN_LEVEL= 3;
  public static final int REQ_POWER = 5;
  public static final int HIT_CHANCE = 75;

  public int getReqPower() { return REQ_POWER; }
  public int getMinLevel() { return MIN_LEVEL; }
  
  public String toString() { return "Force Bolt"; }

  public boolean cast(List<Enemy> enemies) {
    if(player.getLevel() < MIN_LEVEL) throw new com.cjd.textbaseddarksouls.exception.LevelTooLowException();
    if(player.getPower() < REQ_POWER) return false;
    Random random = new Random();
    Scanner s = new Scanner(System.in);
    System.out.println("Which enemy would you like to target? Options are:");
    for (int i=0;i<enemies.size();i++) {
      System.out.println(i+". " + enemies.get(i));
    }
    int selection = s.nextInt();
    s.nextLine(); //Eat newline given to us
    if (selection < 0 || selection >= enemies.size()) return false;
    if (random.nextInt(100) < HIT_CHANCE) {
      enemies.get(selection).dealDamage(DAMAGE);
      System.out.println("The spell hits the " + enemies.get(selection).getClass().getSimpleName() + ", dealing " + DAMAGE + " damage!");
    } else {
      System.out.println("The spell misses!");
    }
    return true;
  }
}
