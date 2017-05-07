package com.cjd.textbaseddarksouls.enemy;

import static com.cjd.textbaseddarksouls.Master.*; //Give access to master context

import com.cjd.textbaseddarksouls.Enemy;

public class Kobold extends Enemy {
    public Kobold() {
        MAX_HEALTH = 10;
        health = 10;
    }
    protected void die() {
        health = 0;
        System.out.println("Kobold ded");
    }
}
