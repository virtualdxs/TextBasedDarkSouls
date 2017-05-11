package com.cjd.textbaseddarksouls.enemy;

import static com.cjd.textbaseddarksouls.Master.*; //Give access to master context

import com.cjd.textbaseddarksouls.Enemy;

public class Griffin extends Enemy {
  public Griffin() {
    MAX_HEALTH = 15;
    MAX_DAMAGE = 5;
    health = 15;
  }
}
