package com.cjd.textbaseddarksouls.enemy;

import static com.cjd.textbaseddarksouls.Master.*; //Give access to master context

import com.cjd.textbaseddarksouls.Enemy;

public class Demon extends Enemy {
  public Demon() {
    MAX_HEALTH = 30;
    MAX_DAMAGE = 15;
    health = 30;
  }
}
