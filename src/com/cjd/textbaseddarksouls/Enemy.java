package com.cjd.textbaseddarksouls;

import static com.cjd.textbaseddarksouls.Master.*; //Give access to master context

import java.util.Random;

public abstract class Enemy {
  protected int health;
  protected int MAX_HEALTH;
  protected int MAX_DAMAGE;
  protected int HIT_CHANCE = 75;
  protected Random random = new Random();

  public void dealDamage(int points) {
    if (points >= health) die(); //Enough damage to kill the enemy
    else health -= points;
  }

  public void heal(int points) {
    if (points > MAX_HEALTH-health) health = MAX_HEALTH; //Prevent enemy from healing past MAX_HEALTH
    else health += points;
  }

  public int getHealth() { return health; }

  public String toString() { return this.getClass().getSimpleName()+" with "+health+" health"; }

  protected void die() { // Sets health to zero and does anything else associated with the enemy's death
    health = 0;
    System.out.println("You killed the " + this.getClass().getSimpleName() + "!");
  }
  public int attack() { // Returns the amount of damage to be dealt to the player
    //Calculate hit or miss;damage is random between 0 and MAX_DAMAGE
    return random.nextInt(100)>HIT_CHANCE ? 0 : random.nextInt(MAX_DAMAGE)+1;
  }
}
