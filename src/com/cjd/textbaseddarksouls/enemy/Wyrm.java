package com.cjd.textbaseddarksouls.enemy;

import static com.cjd.textbaseddarksouls.Master.*; //Give access to master context

import com.cjd.textbaseddarksouls.Enemy;

public class Wyrm extends Enemy {
  public Wyrm() {
    MAX_HEALTH = 70;
    MAX_DAMAGE = 30;
    health = 70;
  }
}
