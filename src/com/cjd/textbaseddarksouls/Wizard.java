package com.cjd.textbaseddarksouls;

import static com.cjd.textbaseddarksouls.DarkSoulsMaster.*;

public class Wizard extends Player {
    public Wizard(String name) {
        super(name);
        POWER_MULTIPLIER = 5; //MAX_POWER = POWER_MULTIPLIER * level
        MAX_POWER = POWER_MULTIPLIER;
        power = MAX_POWER;
        System.out.println(POWER_MULTIPLIER);
    }
}
