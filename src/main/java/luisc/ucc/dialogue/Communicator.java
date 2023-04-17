package luisc.ucc.dialogue;

import luisc.ucc.App;
import luisc.ucc.court.StartOptions;

public class Communicator extends Dialogue {

  public boolean soClose = false;
  public boolean looser = false;

  public Communicator(App app) {
    super(app);
  }

  @Override
  protected void _setup() {
    add(
      "Communicator: I was honestly just sleeping with the radio in my ears listening to my sus male grindset compilation videos in comms."
    );
    if (a.hasEvidence("cams")) {
      add(
        "MC: Really? I saw you go into shields on cams you beta cuck. A bit of susmaxxing if you ask me."
      );
      add(
        "Communicator: Dude im not a beta cuck bro. If you ask me, youre the one who's sus you chud impostorcel."
      );
      add(
        "Communicator: All I did was step out of comms to go on a brisk sigma male walk and check shields because no one does it but me."
      );

      if (!a.hasEvidence("shields-vent")) {
        soClose();
        return;
      }

      add(
        "MC: Oh yeah? Then how does the vent in shields have an earbud attached to it!",
        r.sfx.holdIt
      );
      add(
        "Communicator: Erhg! Uh. I was doing some maintenance on the vent and it slipped out because im just helpful like that?"
      );
      add(
        "Engineer: Woah buddy I had already done maintenance on all the vents prior to lift off!"
      );
      add(
        "Communicator: You know who else did maintenance on the vents prior to lift off..."
      );

      if (!hasEvidence("comms")) {
        add("MC: Fucking hell, not you thats for sure");
        soClose();
        return;
      }

      add(
        "MC: You’re also the comms guy bro. Nearly all the comms panels are malfunctioning lmfao its your job to fix them."
      );
      add("Communicator: I don’t get paid enough to do this shit bro.");

      add("MC: Wait...");
      add("MC: So you killed her because you hate the job?!");
      add("Communicator: What bro?! No bro I didn’t mean it like that.");
      add(
        "Communicator: She was a major bitch but like, I wouldnt kill her bro."
      );

      if (!hasEvidence("guns-blood")) {
        add("MC: Cant prove it, but I really think you did it");
        add("MC: Ill be back");
        soClose();
        return;
      }

      add("MC: HOLD IT!", r.sfx.holdIt);
      add("MC: The blood in guns belonged to the victim!");
      add("MC: Navigation and guns are also connected by vents!");

      add("Communicator: Ergh! Bro I-");
      add("Communicator: Why are you on my ass bro! You know what...");

      add("Communicator/ltg: YOUR LIFE IS NOTHING. YOU SERVE ZERO PURPOSE.");
      add("Communicator/ltg: YOU SHOULD KILL YOURSELF, NOW!");

      add("MC: Get him outta here guys!");
      add(
        "Communicator: This is SO not based, you guys are definitely not getting tagged in my instagram hyperborean sigma male vril edit"
      );
      add("MC: Lmfao rip bozo rest in piss will not be missed");
      // Wins the game
    } else {
      add("MC: Can anyone verify?");
      add("[Everyone says no]");

      if (!hasEvidence("shields-vent")) {
        add("[I need to go back and get some more evidence]");
        soClose = true;
        return;
      }

      add(
        "MC: Well, you were listening to the radio and there’s an earbud in the vent from shields to navigation?"
      );
      add("Communicator: Not mine bro.");

      if (!hasEvidence("coms")) {
        add("[I need to go back and get some more evidence]");
        soClose = true;
        return;
      }

      add(
        "MC: Well, comms are down in nearly every panel. I thought you were responsible for that."
      );
      add(
        "Navigator: I forgot to fix it lol. I would get on it but these chuds are obsessed with finding a killer that isnt me."
      );

      soClose();
    }
  }

  /**
   * Allows the player
   */
  protected void soClose() {
    add("[Fuck, I was so close]");
    add("[I need to go back and get some more evidence]");
    soClose = true;

    a.mainScene.court.fuckUps++;
  }

  @Override
  public void onDone() {
    if (soClose) {
      a.mainScene.inCourt = false;
    } else if (looser) {
      // Does nothing
    }

    setOptions(new StartOptions(a));
  }
}
