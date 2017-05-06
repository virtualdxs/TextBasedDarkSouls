package com.cjd.textbaseddarksouls.spell;

import static com.cjd.textbaseddarksouls.DarkSoulsMaster.*; //Give access to master context

import com.cjd.textbaseddarksouls.GenericSpell;

public class Heal implements GenericSpell {
  private static final int MIN_LEVEL = 4;
  private static final int REQ_POWER = 10;
  private static final int BOOST_AMOUNT = 5;
  
  public int getMinLevel() {return MIN_LEVEL;}
  public int getReqPower() {return REQ_POWER;}

  public boolean cast() {
    if(player.getLevel() < MIN_LEVEL) throw new com.cjd.textbaseddarksouls.exception.LevelTooLowException();
    if(player.getPower() < REQ_POWER) return false;
    player.usePower(REQ_POWER);
    player.heal(BOOST_AMOUNT);
    System.out.println("Healed 5 health.");
    return true;
  }
}
