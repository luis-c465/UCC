package luisc.ucc.court;

import luisc.ucc.App;
import luisc.ucc.dialogue.AmmoSalvo;
import luisc.ucc.dialogue.Blood;
import luisc.ucc.dialogue.Options;
import luisc.ucc.dialogue.Wifi;

public class GunnerQuestions extends Options {

  public GunnerQuestions(App app) {
    super(
      app,
      new String[] {
        "I noticed there was a lot of blood on the floor",
        "The coms pannel in weapons was broken",
        "Odd that you say you shot a couple of asteroids, but the savlos are untouched",
        "You know what nvm",
      }
    );
  }

  @Override
  protected void _update() {
    if (isClicked("I noticed there was a lot of blood on the floor")) {
      setDialogue(new Blood(a));
    } else if (isClicked("The coms pannel in weapons was broken")) {
      setDialogue(new Wifi(a));
    } else if (
      isClicked(
        "Odd that you say you shot a couple of asteroids, but the savlos are untouched"
      )
    ) {
      setDialogue(new AmmoSalvo(a));
    } else if (isClicked("You know what nvm")) {
      setOptions(new StartOptions(a));
    }
  }
}
