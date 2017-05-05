package com.cjd.textbaseddarksouls;

import static com.cjd.textbaseddarksouls.DarkSoulsMaster.*; //Give access to master context

import java.util.Random;

public abstract class Enemy {
    protected int health;
    protected int MAX_HEALTH;
    protected Random random = new Random();

    public void dealDamage(int points) {
        if (points >= health) die(); //Enough damage to kill the enemy
        else health -= points;
    }

    public void heal(int points) {
        if (points > MAX_HEALTH-health) health = MAX_HEALTH; //Prevent enemy from healing past MAX_HEALTH
        else health += points;
    }

    public int getHealth() {
        return health;
    }

    public String toString() {
      return this.getClass().getSimpleName()+" with "+health+" health";
    }

    protected abstract void die(); // Sets health to zero and does anything else associated with the enemy's death
    public int attack() { // Returns the amount of damage to be dealt to the player
      //50% chance of hit; damage is random between 0 and 10
      return random.nextBoolean() ? 0 : random.nextInt(10)+1;
    }
}
