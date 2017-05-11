package com.cjd.textbaseddarksouls.enemy;

import static com.cjd.textbaseddarksouls.Master.*; //Give access to master context

import com.cjd.textbaseddarksouls.Enemy;

public class Dragon extends Enemy {
  public Dragon() {
    MAX_HEALTH = 75;
    MAX_DAMAGE = 20;
    health = 75;
  }
}
