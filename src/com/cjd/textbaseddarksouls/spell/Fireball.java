package com.cjd.textbaseddarksouls.spell;

import static com.cjd.textbaseddarksouls.Master.*; //Give access to master context

import java.util.List;
import java.util.Scanner;
import java.util.Random;
import com.cjd.textbaseddarksouls.Enemy;

public class Fireball implements AttackSpell {
  public static final int MIN_DAMAGE = 30;
  public static final int MIN_LEVEL= 4;
  public static final int REQ_POWER = 15;
  public static final int HIT_CHANCE = 75;

  public int getReqPower() { return REQ_POWER; }
  public int getMinLevel() { return MIN_LEVEL; }

  public String toString() { return "Fireball"; }

  public boolean cast(List<Enemy> enemies) {
    if(player.getLevel() < MIN_LEVEL) throw new com.cjd.textbaseddarksouls.exception.LevelTooLowException();
    if(player.getPower() < REQ_POWER) return false;
    Random random = new Random();
    Scanner s = new Scanner(System.in);
    if(enemies.size() == 0) return false;
    int selection;
    if(enemies.size() == 1) selection = 0;
    else {
      System.out.println("Which enemy would you like to target? Options are:");
      for (int i=0;i<enemies.size();i++) {
        System.out.println(i+". " + enemies.get(i));
      }
      selection = s.nextInt();
      s.nextLine(); //Eat newline given to us
    }
    if (selection < 0 || selection >= enemies.size()) return false;
    if (random.nextInt(100) < HIT_CHANCE) {
      int damage = random.nextInt(player.getLevel())+MIN_DAMAGE;
      enemies.get(selection).dealDamage(damage);
      System.out.println("The fireball hits the " + enemies.get(selection).getClass().getSimpleName() + ", dealing " + damage + " damage!");
    } else {
      System.out.println("The fireball misses!");
    }
    return true;
  }
}
