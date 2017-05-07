package com.cjd.textbaseddarksouls.potion;

import com.cjd.textbaseddarksouls.Potion;
import com.cjd.textbaseddarksouls.exception.PotionReusedException;

import static com.cjd.textbaseddarksouls.Master.*; //Give access to master context

public class HealingPotion implements Potion {
  protected static int BOOST_AMOUNT = 10;
  private boolean used = false;

  public void drink() {
    if (used) throw new PotionReusedException();
    player.heal(BOOST_AMOUNT);
    System.out.println("Drank the " + this + ". Your health is now " + player.getHealth());
    used = true;
  }

  public String toString(){return "Healing Potion";}
}
