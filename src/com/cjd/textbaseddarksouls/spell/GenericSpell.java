package com.cjd.textbaseddarksouls.spell;

import static com.cjd.textbaseddarksouls.DarkSoulsMaster.*; //Give access to master context

import com.cjd.textbaseddarksouls.Spell;

public interface GenericSpell extends Spell {
  boolean cast();
}
