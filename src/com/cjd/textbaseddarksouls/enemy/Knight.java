package com.cjd.textbaseddarksouls.enemy;

import static com.cjd.textbaseddarksouls.Master.*; //Give access to master context

import com.cjd.textbaseddarksouls.Enemy;

public class Knight extends Enemy {
  public Knight() {
    MAX_HEALTH = 25;
    MAX_DAMAGE = 10;
    health = 25;
  }
}
