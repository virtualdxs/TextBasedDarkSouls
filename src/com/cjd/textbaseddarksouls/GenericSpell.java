package com.cjd.textbaseddarksouls;

import static com.cjd.textbaseddarksouls.Master.*; //Give access to master context

import com.cjd.textbaseddarksouls.Spell;

public interface GenericSpell extends Spell {
  boolean cast();
}
