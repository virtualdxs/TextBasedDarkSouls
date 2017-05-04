package com.cjd.TextBasedDarkSouls;

import static com.cjd.TextBasedDarkSouls.DarkSoulsMaster.*;

public class Player {
    public final String name;
    protected int health;

    protected final int MAX_HEALTH = 100;

    public Player(String name) {
        this.name = name;
        if (devmode) this.health = Integer.MAX_VALUE;
        else this.health = 100;
    }

    public void dealDamage(int points) {
        if (devmode) return;
        if (points >= health) endGame();
        else health -= points;
    }
    
    public void heal(int points) {
        if (devmode) return;
        if (points > MAX_HEALTH-health) health = MAX_HEALTH;
        else health += points;
    }
}
