package com.cjd.textbaseddarksouls;

import static com.cjd.textbaseddarksouls.DarkSoulsMaster.*;

public class Wizard extends Player {
    public Wizard(String name) {
        super(name);
        POWER_MULTIPLIER = 5; //MAX_POWER = POWER_MULTIPLIER * level
    }
}
