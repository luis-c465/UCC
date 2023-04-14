package luisc.ucc.dialogue;

import luisc.ucc.App;
import luisc.ucc.court.GunnerQuestions;

public class AmmoSalvo extends Dialogue {

  public AmmoSalvo(App app) {
    super(app);
  }

  @Override
  protected void _setup() {
    add("MC/", r.ch.mc);
    add("Gunner/", r.ch.gunner);

    if (a.hasEvidence("ammo salvo")) {
      add(
        "MC: Were you really using the lazer gun? Or off looking for someone..."
      );
      add("Gunner: Uh, well I uhm. I uh-");
      add("MC: Well!. What's your answer?!");
      add("Gunner: I didn't actually shoot any asteroids........");
      add("[complete science]");
      add("MC: What. Why did you say so then?");
      add("Gunner: To sound cool, lol");
      add("MC: *sighs*");

      a.mainScene.court.fuckUps++;
    } else {
      add(
        "MC: Were you really using the lazer gun? Or off looking for someone..."
      );
      add("Gunner: Wait what, how did you know");
      add("Gunner: I never saw you go there");

      add("MC: Uh, well I uhm. I uh-");
      add("Gunner: Well!. What's your answer?!");
      add("MC: Good question, why did I even say that");

      a.mainScene.court.fuckUps += 2;
    }
  }

  @Override
  public void onDone() {
    setOptions(new GunnerQuestions(a));
  }
}
