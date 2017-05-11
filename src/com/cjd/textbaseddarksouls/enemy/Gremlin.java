package com.cjd.textbaseddarksouls.enemy;

import static com.cjd.textbaseddarksouls.Master.*; //Give access to master context

import com.cjd.textbaseddarksouls.Enemy;

public class Gremlin extends Enemy {
  public Gremlin() {
    MAX_HEALTH = 10;
    MAX_DAMAGE = 5;
    health = 10;
  }
}
