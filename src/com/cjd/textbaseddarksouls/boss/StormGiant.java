package com.cjd.textbaseddarksouls.spell;

import static com.cjd.textbaseddarksouls.Master.*; //Give access to master context

import com.cjd.textbaseddarksouls.Boss;

public class StormGiant implements Boss {
  private final String name = "Storm Giant";
  private int health = 100;

  public String getName() { return name; }
  public int getHealth() { return health; }
  public void dealDamage(int damage) {
    if (damage >= health) onDeath();
    else health -= damage;
  }
  public void onDeath() {
    System.out.println("The storm giant is dead. Long live the storm giant.");
  }
}
