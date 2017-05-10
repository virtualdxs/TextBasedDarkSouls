package com.cjd.textbaseddarksouls.spell;

import static com.cjd.textbaseddarksouls.Master.*; //Give access to master context

import com.cjd.textbaseddarksouls.Boss;

public class VaculosSpider extends Boss {
  private final String name = "Rom the Vaculos Spider";
  private int health = 100;

  public String getName() { return name; }
  public int getHealth() { return health; }
  public void dealDamage(int damage) {
    if (damage >= health) onDeath();
    else health -= damage;
  }

}
