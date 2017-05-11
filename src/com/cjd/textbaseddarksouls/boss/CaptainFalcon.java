package com.cjd.textbaseddarksouls.boss;

import static com.cjd.textbaseddarksouls.Master.*; //Give access to master context

import com.cjd.textbaseddarksouls.Boss;

public class CaptainFalcon extends Boss {
  private final String name = "Captain Falcon";
  private int health = 300;

  public String getName() { return name; }
  public int getHealth() { return health; }
  public void dealDamage(int damage) {
    if (damage >= health) onDeath();
    else health -= damage;
  }
}
