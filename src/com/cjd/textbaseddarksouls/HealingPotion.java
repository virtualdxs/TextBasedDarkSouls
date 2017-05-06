package com.cjd.textbaseddarksouls;

import com.cjd.textbaseddarksouls.exception.PotionReusedException;

import static com.cjd.textbaseddarksouls.DarkSoulsMaster.*; //Give access to master context

public class HealingPotion implements Potion {
  protected static int BOOST_AMOUNT = 10;
  private boolean used = false;

  public void drink() {
    if (used) throw new PotionReusedException();
    player.heal(BOOST_AMOUNT);
    used = true;
  }

  public String toString(){return "Healing Potion";}
}
