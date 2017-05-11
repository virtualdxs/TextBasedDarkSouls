package com.cjd.textbaseddarksouls.spell;

import static com.cjd.textbaseddarksouls.Master.*; //Give access to master context

public class Heal implements GenericSpell {
  private static final int MIN_LEVEL = 4;
  private static final int REQ_POWER = 10;
  private static final int BOOST_MINIMUM = 5;

  public int getMinLevel() {return MIN_LEVEL;}
  public int getReqPower() {return REQ_POWER;}

  public String toString() { return "Heal"; }

  public boolean cast() {
    if(player.getLevel() < MIN_LEVEL) throw new com.cjd.textbaseddarksouls.exception.LevelTooLowException();
    if(player.getPower() < REQ_POWER) return false;
    player.usePower(REQ_POWER);
    int boost = player.getLevel() + BOOST_MINIMUM;
    player.heal(boost);
    System.out.println("Healed " + boost + " health.");
    return true;
  }
}
