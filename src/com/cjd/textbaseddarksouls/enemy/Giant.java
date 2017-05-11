package com.cjd.textbaseddarksouls.enemy;

import static com.cjd.textbaseddarksouls.Master.*; //Give access to master context

import com.cjd.textbaseddarksouls.Enemy;

public class Giant extends Enemy {
  public Giant() {
    MAX_HEALTH = 50;
    MAX_DAMAGE = 30;
    health = 50;
  }
}
