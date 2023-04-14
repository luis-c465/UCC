package luisc.ucc.court;

import luisc.ucc.App;
import luisc.ucc.dialogue.Blood;
import luisc.ucc.dialogue.Options;

public class GunnerQuestions extends Options {

  public GunnerQuestions(App app) {
    super(
      app,
      new String[] {
        "I noticed there was a lot of blood on the floor",
        "The coms pannel in weapons was broken",
        "Odd that you say you shot a couple of asteroids, but the savlos are untouched",
      }
    );
  }

  @Override
  protected void _update() {
    if (isClicked("I noticed there was a lot of blood on the floor")) {
      a.mainScene.court.setDialogue(new Blood(a));
    }
  }
}
