package com.cjd.TextBasedDarkSouls.enemies;

import static com.cjd.TextBasedDarkSouls.DarkSoulsMaster.*; //Give access to master context

import com.cjd.TextBasedDarkSouls.Enemy;

public class Griffin extends Enemy {
    public Griffin() {
        MAX_HEALTH = 10;
        health = 10;
    }
    protected void die() {
        health = 0;
        System.out.print("Griffin ded");
    }
}
