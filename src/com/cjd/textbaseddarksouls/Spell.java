package com.cjd.textbaseddarksouls;

import static com.cjd.textbaseddarksouls.Master.*; //Give access to master context

public interface Spell {
  int getMinLevel(); //Minimum level to cast the spell
  int getReqPower(); //Magical power required to cast the spell
}
