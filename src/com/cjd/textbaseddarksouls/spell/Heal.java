package com.cjd.textbaseddarksouls.spell;

import static com.cjd.textbaseddarksouls.DarkSoulsMaster.*; //Give access to master context

import java.util.List;
import com.cjd.textbaseddarksouls.Spell;

public class Heal implements Spell {
  private static final int MIN_LEVEL = 4;
  private static final int REQ_POWER = 10;
  private static final int BOOST_AMOUNT = 5;
  
  public int getMinLevel() {return MIN_LEVEL;}
  public int getReqPower() {return REQ_POWER;}

  public boolean cast() {
    if(player.getLevel() < MIN_LEVEL) return false;
    if(player.getPower() < REQ_POWER) return false;
    player.usePower(REQ_POWER);
    player.heal(BOOST_AMOUNT);
    return true;
  }
}
