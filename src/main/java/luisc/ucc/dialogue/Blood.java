package luisc.ucc.dialogue;

import luisc.ucc.App;
import luisc.ucc.court.GunnerQuestions;

public class Blood extends Dialogue {

  public Blood(App app) {
    super(app);
  }

  @Override
  protected void _setup() {
    add("Gunner/", r.ch.gunner);
    add("MC/", r.ch.mc);
    add("Navigator/", r.ch.mc);

    if (a.hasEvidence("blood-examiner")) {
      add("MC: Odd that it belonged to the victim.");
      add("Gunner: I have no clue about that, youngster.");
      add("Gunner: I didn't even know they went through there!");
      add(
        "Gunner: Towards the latter end of my shift, I left to go swipe my card in admin because I forgot!"
      );
      add("MC: Hmmm, Does anyone confirm this?");
      add("Navigator: Uh, I-I can!");
      add("Navigator: I saw him try and scan for 5 minutes!");
      add("Gunner: I hate this newfangled technology, ok?");
      add(
        "MC: Alright well we have an alibi and a person to scratch off the suspect list at least."
      );

      a.mainScene.court.fuckUps++;
    } else if (a.hasEvidence("blood")) {
      add("MC: Any idea where it came from?");
      add(
        "Gunner: I don’t really know. Must have been from the battles i’ve fought."
      );
      add("Gunner: You know, I lost my wife and kids that day.");

      // Dies of cringe
      add("Gunner: It still haunts me Joe. It still haunts me.");
      add(
        "Gunner: Their screams. Their agony. All because I couldn’t land the shot."
      );
      add(
        "Gunner: That shot could have saved them Joe. I could have saved them."
      );
      add("Gunner: I can’t sleep.");
      add("Gunner: But anyways, I don’t know about that one sonny.");

      add("MC: You good man?");
      add("Gunner: Níl");
      a.mainScene.court.fuckUps++;
    } else {
      add("Gunner: Ok where did you see it?");
      add("[Uhh why did I say that]");
      add("MC: Honestly I forgor");
      add("Gunner: Bruh");

      a.mainScene.court.fuckUps++;
    }
  }

  @Override
  public void onDone() {
    setOptions(new GunnerQuestions(a));
  }
}
