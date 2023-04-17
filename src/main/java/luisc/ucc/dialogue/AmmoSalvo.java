package luisc.ucc.dialogue;

import luisc.ucc.App;
import luisc.ucc.court.GunnerQuestions;

public class AmmoSalvo extends Dialogue {

  public AmmoSalvo(App app) {
    super(app);
  }

  @Override
  protected void _setup() {
    add(
      "MC/thinking: Odd that you say you shot a couple of asteroids, but the savlos are untouched",
      "gunner/salvo/odd"
    );
    add(
      "MC/pointing: Were you really using the lazer gun? Or off looking for someone...",
      "gunner/salvo/lazer-gun"
    );
    if (a.hasEvidence("ammo salvo")) {
      add("Gunner/worried: Uh, well I uhm. I uh-", "adrian/gunnerStammering");
      add("MC/pointing: Well!. What's your answer?!", "gunner/salvo/well");
      add(
        "Gunner/crying: I didn't actually shoot any asteroids........",
        "adrian/i_didnt_actually_shoot_any"
      );
      add("[complete science]");
      add("MC/worried: What. Why did you say so then?", "gunner/salvo/why");
      add("Gunner/chad: To sound cool, lol", "adrian/to_sound_cool_lol");
      add("MC: *sighs*", "gunner/salvo/sigh");

      a.mainScene.court.fuckUps++;
    } else {
      add(
        "Gunner/thinking: Wait what, how did you know",
        "adrian/wait_what_howd_you_know"
      );
      add("Gunner: I never saw you go there");

      add("MC/worried: Uh, well I uhm. I uh-", "gunner/salvo/well2");
      add(
        "Gunner/pointing: Well!. What's your answer?!",
        "adrian/well_whats_your_answer"
      );
      add("MC/worried: Good question", "gunner/salvo/question");
      add("[Why did I even say that?]");

      a.mainScene.court.fuckUps++;
    }
  }

  @Override
  public void onDone() {
    setOptions(new GunnerQuestions(a));
  }
}
