package com.cjd.textbaseddarksouls.enemy;

import static com.cjd.textbaseddarksouls.DarkSoulsMaster.*; //Give access to master context

import com.cjd.textbaseddarksouls.Enemy;

public class Giant extends Enemy {
    public Giant() {
        MAX_HEALTH = 10;
        health = 10;
    }
    protected void die() {
        health = 0;
        System.out.println("Giant ded");
    }
}
