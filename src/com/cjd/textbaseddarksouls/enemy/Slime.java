package com.cjd.textbaseddarksouls.enemy;

import static com.cjd.textbaseddarksouls.Master.*; //Give access to master context

import com.cjd.textbaseddarksouls.Enemy;

public class Slime extends Enemy {
  public Slime() {
    MAX_HEALTH = 5;
    MAX_DAMAGE = 2;
    health = 5;
  }
}
