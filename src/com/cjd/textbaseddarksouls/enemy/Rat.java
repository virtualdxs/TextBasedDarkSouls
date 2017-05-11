package com.cjd.textbaseddarksouls.enemy;

import static com.cjd.textbaseddarksouls.Master.*; //Give access to master context

import com.cjd.textbaseddarksouls.Enemy;

public class Rat extends Enemy {
  public Rat() {
    MAX_HEALTH = 3;
    MAX_DAMAGE = 1;
    health = 3;
  }
}
