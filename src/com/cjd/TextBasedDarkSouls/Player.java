package com.cjd.TextBasedDarkSouls;

import static com.cjd.TextBasedDarkSouls.DarkSoulsMaster.*; //Give access to master context

public abstract class Player {
    public final String name;
    protected int health;

    protected final int MAX_HEALTH = 100;

    public Player(String name) {
        this.name = name;
        this.health = 100;
    }

    public void dealDamage(int points) {
        if (devmode) return; //Prevent damage if in devmode
        if (points >= health) endGame(); //Enough damage to kill the player
        else health -= points;
    }
    
    public void heal(int points) {
        if (devmode) return; //Prevent healing if in devmode
        if (points > MAX_HEALTH-health) health = MAX_HEALTH; //Prevent player from healing past MAX_HEALTH
        else health += points;
    }
}
