package com.cjd.textbaseddarksouls.spell;

import static com.cjd.textbaseddarksouls.DarkSoulsMaster.*; //Give access to master context

import java.util.List;
import com.cjd.textbaseddarksouls.Spell;
import com.cjd.textbaseddarksouls.Enemy;

public interface AttackSpell extends Spell{
  void cast(List<Enemy> enemyList);
}
