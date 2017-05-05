package com.cjd.TextBasedDarkSouls.enemies;

import static com.cjd.TextBasedDarkSouls.DarkSoulsMaster.*; //Give access to master context

import com.cjd.TextBasedDarkSouls.Enemy;

public class Slime extends Enemy {
    public Slime() {
        MAX_HEALTH = 10;
        health = 10;
    }
    protected void die() {
        health = 0;
        System.out.print("Slime ded");
    }
}
