package com.cjd.textbaseddarksouls;

import static com.cjd.textbaseddarksouls.Master.*; //Give access to master context

public abstract class Boss {
  public abstract String getName();
  public abstract int getHealth();
  public abstract void dealDamage(int damage);
  public String toString() { return getName(); }
  public void onDeath() { System.out.println(this + " is dead. Long live " + this + "."); }
}
