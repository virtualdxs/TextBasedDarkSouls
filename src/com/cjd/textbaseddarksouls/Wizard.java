package com.cjd.textbaseddarksouls;

import static com.cjd.textbaseddarksouls.DarkSoulsMaster.*;

public class Wizard extends Player {
    protected int POWER_MULTIPLIER = 5; //MAX_POWER = POWER_MULTIPLIER * level
    public Wizard(String name) {
        super(name);
    }
}
