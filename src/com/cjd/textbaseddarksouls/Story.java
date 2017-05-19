package com.cjd.textbaseddarksouls;

import static com.cjd.textbaseddarksouls.Master.*; //Give access to master context

import com.cjd.textbaseddarksouls.Player.PlayerClass;

public abstract class Story {
  public static void main(String[] args) {
    init();
    String response;
    System.out.println("Panic floods your mind as you awaken in an unknown location. You realize with a start, that you forgot to open your eyes. As open them, and as your eyes adjust, you realize the room is, in fact dark. This is most likely due to the fact that the torches on the wall are unlit.");
    System.out.println("Light the torches?");
    response = getResponse();
    if (response.contains("y")) System.out.println("You don't have anything to light them with you idiot");
    System.out.println("A hunched over man enters the room, a sword in one hand, a sandwich in the other. In between bites he says, \"Hey. You. Dead dude. What are you doing?\"");
    System.out.println("As you open your mouth to speak, you feel a strange lump moving in your mouth. The startling revelation that you don’t have a tongue slams into you, sending you reeling. He says, with a bemused expression on his face and a strange glint in his eyes, \"We cut that useless part out, considering how much you were talking. Oh, and by the way, I brought you back to life.\"");
    System.out.println("Would you like to:");
    System.out.println("1. Scream");
    System.out.println("2. Stand up");
    System.out.println("3. Do nothing and remain laying down");
    switch(getIntResponse(3)) {
      case 1:
        System.out.println("You scream incoherently for about 3 minutes. Finally, the man saunters over to you and slaps you. Hard.");
        break;
      case 2:
        System.out.println("You attempt to stand up, but your efforts fail and you collapse back onto the ground.");
        break;
      case 3:
        System.out.println("You remain on the ground.");
        break;
      default:
        throw new java.lang.IllegalArgumentException("how the hell did you get to this statement"); //getIntResponse should prevent this
    }
    System.out.println("The man continues with his words, saying \"Anyways, I need your help. Some \"Supreme Evil\" or whatever killed my family. Since I am really old, weak, hunched over and generally weak I couldn’t do it myself and I also just don’t really want to. I found your corpse and revived you. So now you’re going to go off and kill them. I will give you a  magiC potion. So you can go and find the people who killed them. Thx mane.”");
    System.out.println("You are sent on your way, on a quest to kill some guys that have nothing to do with you or your life.");
    System.out.println("Once you exit the man’s shack, you find stuff that you presume to be yours. You find:");
    switch (player.getPlayerClass()) {
      case WAR:
        break;
      case WIZ:
        break;
      default:
        throw new java.lang.IllegalArgumentException("playerClass is not WAR or WIZ");
    }
  }
}
