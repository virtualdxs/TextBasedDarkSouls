package com.cjd.textbaseddarksouls.spell;

import static com.cjd.textbaseddarksouls.Master.*; //Give access to master context

import com.cjd.textbaseddarksouls.Boss;
import com.cjd.textbaseddarksouls.item.HerringA;

public class MrHerring implements Boss {
  private final String name = "Mr. Herring";
  private int health = 1000;

  public String getName() { return name; }
  public int getHealth() { return health; }
  public void dealDamage(int damage) {
    if (damage >= health) onDeath();
    else health -= damage;
  }
  public void onDeath() {
    System.out.println("You have proven your worthiness. I give you an A.");
    HerringA a = new HerringA();
    player.giveItem(a);
    System.out.println("You now have " + a + ".");
  }
}
