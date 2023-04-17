package luisc.ucc.dialogue;

import luisc.ucc.App;
import luisc.ucc.court.GunnerQuestions;

public class Blood extends Dialogue {

  public Blood(App app) {
    super(app);
  }

  @Override
  protected void _setup() {
    add(
      "MC: I noticed there was a lot of blood on the floor",
      "gunner/blood-1"
    );
    if (a.hasEvidence("blood-examiner")) {
      add(
        "MC/pointing: Odd that it belonged to the victim.",
        "gunner/examiner/victim"
      );
      add(
        "Gunner: I have no clue about that, youngster.",
        "adrian/ihavenoclueaboutthatsonny"
      );
      add("Gunner/worried: I didn't even know they went through there!");
      add(
        "Gunner/thinking: Towards the latter end of my shift, I left to go swipe my card in admin because I forgot!"
      );
      add("MC: Hmmm, Does anyone confirm this?", "gunner/examiner/confirm");
      add("Navigator: Uh, I-I can!", "adrian/navigatorGunnerDialogue");
      add("Navigator: I saw him try and scan for 5 minutes!");
      add(
        "Gunner/pointing: I hate this newfangled technology, ok?",
        "adrian/ihatethisnewfangledtechnology"
      );
      add(
        "MC/thumbs-up: Alright well we have an alibi and a person to scratch off the suspect list at least.",
        "gunner/examiner/alibi"
      );
    } else if (a.hasEvidence("blood")) {
      add("MC/thinking: Any idea where it came from?", "gunner/blood-1");
      add(
        "Gunner/thumbs-up: I don’t really know. Must have been from the battles i’ve fought.",
        "adrian/wife-and-kids"
      );
      add("Gunner/crying: You know, I lost my wife and kids that day.");

      // Dies of cringe
      add("Gunner/crying: It still haunts me Joe. It still haunts me.");
      add(
        "Gunner/ligma: Their screams. Their agony. All because I couldn’t land the shot."
      );
      add(
        "Gunner/ligma: That shot could have saved them Joe. I could have saved them."
      );
      add("Gunner/ligma: I can’t sleep.");
      add("Gunner/ligma: But anyways, I don’t know about that one sonny.");

      add("MC/worried: You good man?");
      add("Gunner/thumbs-up: Yes");
      a.mainScene.court.fuckUps++;
    } else {
      add("Gunner/pointing: Ok where did you see it?");
      add("[Uhh why did I say that]");
      add("MC/worried: Honestly I forgor");
      add("Gunner/worried: Bruh");

      a.mainScene.court.fuckUps++;
    }
  }

  @Override
  public void onDone() {
    setOptions(new GunnerQuestions(a));
  }
}
