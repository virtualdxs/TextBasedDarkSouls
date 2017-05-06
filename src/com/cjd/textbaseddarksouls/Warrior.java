package com.cjd.textbaseddarksouls;

import static com.cjd.textbaseddarksouls.DarkSoulsMaster.*; //Give access to master context

public class Warrior extends Player {
    public Warrior(String name) {
        super(name);
        HIT_CHANCE = 85; //5% Warrior hit chance bonus
    }

    /**
    * Calculates damage for a player attack
    * @return int Damage of the attack
    */
    public int attack() {
      //Calculate hit or miss;damage is random between 8 and 18 (3 point Warrior damage bonus)
      return random.nextInt(100) > HIT_CHANCE ? 0 : random.nextInt(10)+8;
    }
}
