package com.cjd.textbaseddarksouls.enemy;

import static com.cjd.textbaseddarksouls.Master.*; //Give access to master context

import com.cjd.textbaseddarksouls.Enemy;

public class Minion extends Enemy {
  public Minion() {
    MAX_HEALTH = 5;
    MAX_DAMAGE = 3;
    health = 5;
  }
}
