package com.cjd.TextBasedDarkSouls.enemies;

import static com.cjd.TextBasedDarkSouls.DarkSoulsMaster.*; //Give access to master context

import com.cjd.TextBasedDarkSouls.Enemy;

public class Gremlin extends Enemy {
    public Gremlin() {
        MAX_HEALTH = 10;
        health = 10;
    }
    protected void die() {
        health = 0;
        System.out.print("Gremlin ded");
    }
}
