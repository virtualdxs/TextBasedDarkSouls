package com.cjd.textbaseddarksouls.spell;

import static com.cjd.textbaseddarksouls.DarkSoulsMaster.*; //Give access to master context

import java.util.List;
import java.util.Scanner;
import com.cjd.textbaseddarksouls.Enemy;
import com.cjd.textbaseddarksouls.AttackSpell;

public class ForceBolt implements AttackSpell {
  public static final int DAMAGE = 15;
  public static final int MIN_LEVEL= 3;
  public static final int REQ_POWER = 5;

  public int getReqPower() { return REQ_POWER; }
  public int getMinLevel() { return MIN_LEVEL; }

  public boolean cast(List<Enemy> enemies) {
    Scanner s = new Scanner(System.in);
    System.out.println("Which enemy would you like to target? Options are:");
    for (int i=0;i<enemies.size();i++) {
      System.out.println(i+". " + enemies.get(i));
    }
    int selection = s.nextInt();
    s.nextLine(); //Eat newline given to us
    if (selection < 0 || selection >= enemies.size()) return false;
    enemies.get(selection).dealDamage(DAMAGE);
    System.out.println("Dealt 15 damage to the " + enemies.get(selection).getClass().getSimpleName() + ".");
    return true;
  }
}
