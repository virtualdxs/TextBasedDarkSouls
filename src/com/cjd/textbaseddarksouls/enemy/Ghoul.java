package com.cjd.textbaseddarksouls.enemy;

import static com.cjd.textbaseddarksouls.Master.*; //Give access to master context

import com.cjd.textbaseddarksouls.Enemy;

public class Ghoul extends Enemy {
  public Ghoul() {
    MAX_HEALTH = 20;
    MAX_DAMAGE = 10;
    health = 20;
  }
}
