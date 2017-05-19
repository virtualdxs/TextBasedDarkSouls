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
    System.out.println("Upon stealing the old, defenseless man’s only means of survival, I mean, erm, “your weapons of immense prior sentimental value,” you set off on your grand adventure.");
    System.out.println("After hours of traveling, you encounter a wild tutorial. *Wild pokemon music plays*");
    CombatContext combat = new CombatContext();
    combat.add(new Rat());
    combat.runCombat;
    System.out.println("Whew, that was tough.");
    System.out.println("Okay not really, if you took any damage, you’re probably going to die.");
    System.out.println("You continue on your lonely road, the only road you ever known. After a few more hours, you stumble upon a city.");
    System.out.println("For unknown reasons that don’t exist, the city seems abandoned.");
    System.out.println("The streets are empty.");
    System.out.println("You are alone.");
    System.out.println("Forever.");
    System.out.println("Would you like to continue?")
    System.out.println("Or are you too weak?");
    System.out.println("1. Enter the city");
    System.out.println("2. Turn Back and leave");
    switch(getIntResponse(2)){
      case 1:
      System.out.println("You continue into the city");
      break;
      case 2:
      System.out.println("Game over. Good night. You little baby. Do you need a bottle, you pathetic excuse of a troglodyte? You want me to tuck you in? Well tough luck. You are supposed  to go into the city and find the guys who killed the man's family. So go into the city and never think of turning back again.");
      System.out.println("You continue into the city with the crushing depression inflicted upon you weighing you down.");
      break;
      default:
      throw new java.lang.IllegalArgumentException("Huh?");
    }
    System.out.println("After hours of meandering about, you see an abandoned house that looks slightly more homely than the others. As you head inside, you hear a spooky sound rivet through the house.");
    System.out.println("As you head inside, you hear a spooky sound rivet through the house. On the floor, you see two ghouls feasting on the corpse of an unknown creature.");
    System.out.println("One of them snaps its head towards you, murder in its eyes. In a stupidly high pitched voice it exclaims “OMG, mooorrrreeeee foooood.” It then attacks you, as that is what ghouls do. The other one shouts “PELICAN, EEEEEEEEHHHHHHHHHH.”");
    CombatContext combat2 = new CombatContext();
    combat2.add(new Ghoul());
    combat2.add(new Ghoul());
    combat2.runCombat;
    System.out.println("Wow! You killed them!");
    System.out.println("The most fragile enemy you will encounter!");
    System.out.println("You are a true hero.");
    System.out.println("After that intense battle, you get to take a glance at your surroundings.");
    System.out.println("1. Look around the house");
    System.out.println("2. Search the ghouls");
    System.out.println("3. Go upstairs");
    System.out.println("4. Leave");

    boolean done = false;
    while(!done){
      switch(getIntResponse(4)){
        case 1:
        System.out.println("There’s nothing. What’d you expect, a gargantuan treasure trove? You’re literally in some random peasant’s house.");
        break;
        case 2:
        System.out.println("Really? The Ghouls? Alrighty then. You find… ABSOLUTELY NOTHING! Congratulations, you’ve disturbed the dead");
        break;
        case 3:
        System.out.println("Well, nothing upstairs except for crushing darkness and the never ending expanse of your self-deprecating thoughts. Oh, and some gold or whatever.");
        break;
        case 4:
        System.out.println("You exit the house and take another good look at your surroundings.");
        done = true;
        break;
        default:
        throw new java.lang.IllegalArgumentException("Huh?");
        break;
      }
    }
    System.out.println("As you observe the cool expanse of cobbled roads and darkened houses, you notice a rather large building in the center of town. You feel the compelling power of plot drawing you towards it. ");
    System.out.println("As the almighty force of the plot being inflicted on you pushes you to the towering behemoth of a building, you see a clearly marked, neatly kept area labeled “CHECKPOINT”");
    System.out.println("You continue on with your journey, towards the building you realize is a Cathedral, due to the amazing powers of sudden context. Inside the building is a immense throne, with a large shadowy figure settled upon it.");
    System.out.println("Suddenly, for the purpose of advancing this story along at a rather quick pace, a bellowing voice booms from all around you:")
    System.out.println("WHO DARES ENTER MY HOLY CATHEDRAL");
    System.out.println("MY MOST HOLY OF PLACES, THE MOST SACRED PLACE TO EVER GRACE THIS MISERABLE REALM?");
    System.out.println("WHO DARES COME TO THE HOME OF DRITTSEKK THE MIGHTY, DRITTSEKK THE POWERFUL");
    System.out.println("DRITTSEKK THE CRUSHER OF CITIES");
    System.out.println("THE DRINKER OF DRAGON BLOOD");
    System.out.println("THE DESTROYER OF MAN");
    System.out.println("THE ONLY GIANT TO EVER SUCCESSFULLY SPEEDRUN SUPER MARIO 64");
    System.out.println("THE TENDER OF THE FIELD OF BATTLE");
    System.out.println("THE MIGHTY RIDER OF VAN DU RA SEEL CAMME FORRU TASTS VELLU VAN GA RU THE GREAT WYRM");
    System.out.println("THE ONLY FALCO MAIN OF MY CLAN");
    System.out.println("EATER OF SOULS");
    System.out.println("Man that guy can talk. Well, since he’ll be listing titles for about an hour, wanna donate to my college fund?");
    System.out.println("1. Sure.");
    System.out.println("2. Neck Yourself");
    switch(getIntResponse(2)){
      case 1:
      System.out.println("Thanks, my paypal is www.paypal.com/IActuallyDontHaveAPaypal");
      break;
      case 2:
      System.out.println("Alright, that's fine. I mean it’s not like I’ve been leading you through this adventure. ");
      break;
      default:
      throw new java.lang.IllegalArgumentException("Huh?");
      break;
    }
    System.out.println("Good luck on this next fight, by the way. Can I give you a bit of a tip? This guy is a boss, and not a hard one.");
    System.out.println(" Even so, he could crush you beneath his foot like you were a spider. So, try not to die, okay?");

    //BossFight drittsekk = new bossfight.Drittsekk();

    System.out.println("Wait, you actually survived? I'm surprised. Looks like I'm losing 20 dollars.");
    System.out.println("Anyways a big door in the back of the cathedral opens dramatically.");
    System.out.println("You see a really, really big guy holding a staff sitting in a chair. In the sky, there is a big, red moon. I wonder how it became red.");
    System.out.println("You approach the big, big man sitting in the chair. What do you do?");
    System.out.println("1. Ask the guy for directions.");
    System.out.println("2. Kill the guy");
    int thing = 0;
    boolean dead = false;
    while(!dead){
      switch(getIntResponse(2)){
        case 1:
        if(thing = 0){
          System.out.println("The large, large guy just points at a river that is just ahead of the balcony. Maybe he wants you to jump into the river?");
          thing++;
        }
        else if(thing = 1){
          System.out.println("The giant, giant guy points at the river again, but a little more frustrated.");
          thing++;
        }
        else{
          System.out.println("He just sighs...");
        }
        break;
        case 2:
        if(thing = 0){
          System.out.println("Well ok then....");
          System.out.println("You brutally slaughter this large, large man whithout asking him where to go");
          System.out.println("Just so you know, you were supposed to jump into the river");
          dead = true;
        }
        else{
          System.out.println("After getting your info, you kill the big, big man. Its not like he didn't deserve it, but that was kind of mean. He couldn't even move.");\
          dead = true;
        }
        default:
        throw new java.lang.IllegalArgumentException("Huh?");
        break;
      }
    }
    System.out.println("You now jump into the river.");
    System.out.println("Oddly enough, you don't drown.");
    System.out.println("Instead, you find yourself in a foggy, humid realm. The humidity makes you gag a bit.");
    System.out.println("Where are you, you ask? Well I'm not sure, but theres a group of enemies approaching. Engage them in combat.");
    CombatContext combat3 = new CombatContext();
    combat3.add(new Knight());
    combat3.add(new Knight());
    combat3.add(new Kobold());
    combat3.runCombat;
    System.out.println("Looks like you've got the hang of this combat stuff. Hope you can keep it up.");
    System.out.println("2 paths manifest in front of you. One on the left, aother on the right. Which one will you take?");
    System.out.println("1. Left.");
    System.out.println("2. Right");
    switch(getIntResponse(2)){
      case 1:
      System.out.println("You go down the leftmost path");
      break;
      case 2:
      System.out.println("You go down the right path.");
      System.out.println("As you walk down the path, you smell something sour. I think it smells like a spike in difficulty...");
      System.out.println("You might want to be careful.");
      System.out.println("No scenery manifests, all that you see is a path of clearness in fog. The ground is also fog. Crazy, huh?");
      System.out.println("Uh oh. A group of enemies approach. A quite large group...");
      System.out.println("I hope you're ready!");
      CombatContext combat4 = new CombatContext();
      combat4.add(new Knight());
      combat4.add(new Knight());
      combat4.add(new Knight());
      combat4.add(new Knight());
      combat4.add(new Demon());
      combat4.add(new Wyrm());
      combat4.add(new Dwarf());
      combat4.runCombat;
      System.out.println("Wow. you're geting really good at this combat stuff.");
      System.out.println("There are a lot of bodies in front of you.");
      System.out.println("Wait... Do you hear that? It sounds like an engine...");
      System.out.println("The sound gets closer.");
      System.out.println("Louder.");
      System.out.println("The loudness peaks and in front of you, a large vehicle appears.");
      System.out.println("The engine shuts off and a man dressed in a blue jumpsuit jumps out.");
      System.out.println("He wears a red helmet with a falcon on it.");
      System.out.println("Its Captain Falcon!");
      System.out.println("\"SHOW ME YA MOVES!\", he yells. You have found the first ");

      System.out.println("Woah! you have defeated the Captain Falcon!");
      System.out.println("There isn't anything ahead. You turn back and walk until you get to the split in the paths.");
      System.out.println("You now walk on the path on the left");
      break;
      default:
      throw new java.lang.IllegalArgumentException("Huh?");
      break;
    }
    System.out.println("To be continued....");
    System.out.println("We ran out of time for the project.")
  }
}
