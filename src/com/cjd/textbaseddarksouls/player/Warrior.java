package com.cjd.textbaseddarksouls.player;

import static com.cjd.textbaseddarksouls.Master.*; //Give access to master context

import com.cjd.textbaseddarksouls.Player;

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
      //Calculate hit or miss; damage is 10 <= rand < level+14 (5 point Warrior bonus)
      return random.nextInt(100) > HIT_CHANCE ? 0 : random.nextInt(level+4)+10;
    }
}
