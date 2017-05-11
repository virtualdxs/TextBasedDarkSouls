package com.cjd.textbaseddarksouls.enemy;

import static com.cjd.textbaseddarksouls.Master.*; //Give access to master context

import com.cjd.textbaseddarksouls.Enemy;

public class Bandit extends Enemy {
  public Bandit() {
    MAX_HEALTH = 15;
    MAX_DAMAGE = 5;
    health = 15;
  }
}
