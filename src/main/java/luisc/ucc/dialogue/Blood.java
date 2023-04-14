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
      add("Gunner: I have no clue about that!!");
      add("Gunner: I didn't even know they went through there!");
      add(
        "Gunner: Towards the latter end of my shift, I left to go swipe my card in admin because I forgot!"
      );
      add("MC: Hmmm, Does anyone confirm this?");
      add("Navigator: Uh, I-I can!");
      add("Navigator: I saw him try and scan for 5 minutes!");
      add("Gunner: Shut up! It's hard to scan it!");
      add(
        "MC: Alright well we have an alibi and a person to scratch off the suspect list at least."
      );

      a.mainScene.court.fuckUps++;
    } else if (a.hasEvidence("blood")) {
      add("MC: Any idea where it came from?");
      add("Gunner: I don't really know.");
      add("Gunner: Must have been from my sick battle scars!");

      // Dies of cringe
      add("Gunner: (I gave myself a paper cut...)");

      add("MC: What a fucking looser holy shit");
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
    a.mainScene.court.setOptions(new GunnerQuestions(a));
  }
}
