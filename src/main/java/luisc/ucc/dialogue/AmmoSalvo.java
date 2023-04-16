package luisc.ucc.dialogue;

import luisc.ucc.App;
import luisc.ucc.court.GunnerQuestions;

public class AmmoSalvo extends Dialogue {

  public AmmoSalvo(App app) {
    super(app);
  }

  @Override
  protected void _setup() {
    if (a.hasEvidence("ammo salvo")) {
      add(
        "MC/pointing: Were you really using the lazer gun? Or off looking for someone..."
      );
      add("Gunner/worried: Uh, well I uhm. I uh-");
      add("MC/pointing: Well!. What's your answer?!");
      add("Gunner/crying: I didn't actually shoot any asteroids........");
      add("[complete science]");
      add("MC/worried: What. Why did you say so then?");
      add("Gunner/ligma: To sound cool, lol");
      add("MC: *sighs*");

      a.mainScene.court.fuckUps++;
    } else {
      add(
        "MC/pointing: Were you really using the lazer gun? Or off looking for someone..."
      );
      add("Gunner/thinking: Wait what, how did you know");
      add("Gunner: I never saw you go there");

      add("MC/worried: Uh, well I uhm. I uh-");
      add("Gunner/pointing: Well!. What's your answer?!");
      add("MC: Good question");
      add("[Why did I even say that?]");

      a.mainScene.court.fuckUps += 2;
    }
  }

  @Override
  public void onDone() {
    setOptions(new GunnerQuestions(a));
  }
}
