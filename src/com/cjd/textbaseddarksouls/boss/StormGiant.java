package com.cjd.textbaseddarksouls.boss;

import static com.cjd.textbaseddarksouls.Master.*; //Give access to master context

import com.cjd.textbaseddarksouls.Boss;

public class StormGiant extends Boss {
  private final String name = "Storm Giant";
  private int health = 100;

  public String getName() { return name; }
  public int getHealth() { return health; }
  public void dealDamage(int damage) {
    if (damage >= health) onDeath();
    else health -= damage;
  }
  public void onDeath() {
    System.out.println("I got five bucks on the Giant… Oh, you’re alive. I was totally counting on you winning. 100 Percent. All the way. Umm.");
  }
}
