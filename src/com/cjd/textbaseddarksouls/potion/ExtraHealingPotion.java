package com.cjd.textbaseddarksouls.potion;

import static com.cjd.textbaseddarksouls.Master.*; //Give access to master context

public class ExtraHealingPotion extends HealingPotion {
  public ExtraHealingPotion() {
    super();
    BOOST_AMOUNT = 25;
  }
  public String toString(){return "Extra Healing Potion";}
}
