package com.cjd.textbaseddarksouls;

import static com.cjd.textbaseddarksouls.Master.*; //Give access to master context

import java.util.List;
import com.cjd.textbaseddarksouls.Spell;
import com.cjd.textbaseddarksouls.Enemy;

public interface AttackSpell extends Spell{
  boolean cast(List<Enemy> enemyList);
}
