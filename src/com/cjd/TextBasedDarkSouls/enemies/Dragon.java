package com.cjd.TextBasedDarkSouls.enemies;

import static com.cjd.TextBasedDarkSouls.DarkSoulsMaster.*; //Give access to master context

import com.cjd.TextBasedDarkSouls.Enemy;

public class Dragon extends Enemy {
    public Dragon() {
        MAX_HEALTH = 10;
        health = 10;
    }
    protected void die() {
        health = 0;
        System.out.print("Dragon ded");
    }
}
