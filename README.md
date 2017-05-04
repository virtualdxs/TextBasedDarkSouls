# TextBasedDarkSouls
Text-Based Dark Souls

## Features
 - Combat
 - Health
 - Damage
 - Healing
 - Permadeath
 - Useless checkpoints

## Structure
Java programs should always have globally-unique package names. Typically, the prefix is the domain name reversed, i.e. `com.google`. However, this is a school project. So I chose to call us CJD (Christian, Joey, Duncan) and pretend we have the domain cjd.com. This domain is currently squatted, so there is little to no chance of a conflict with another Java package. As for the actual structure:

    TextBasedDarkSouls
        |- README.md (this file)
        |- src/
            |- com/
                |- cjd/
                    |- TextBasedDarkSouls/ // All of our .java files will be in this folder or a subdirectory.
