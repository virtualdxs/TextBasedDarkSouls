package com.cjd.textbaseddarksouls.player;

import static com.cjd.textbaseddarksouls.Master.*;

import com.cjd.textbaseddarksouls.Player;
import com.cjd.textbaseddarksouls.Player.PlayerClass;

public class Wizard extends Player {
    public Wizard(String name) {
        super(name,PlayerClass.WIZ);
        POWER_MULTIPLIER = 5; //66% Wizard magic power bonus
        MAX_POWER = POWER_MULTIPLIER;
        power = MAX_POWER;
    }
}
