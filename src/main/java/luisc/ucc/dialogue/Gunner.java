package luisc.ucc.dialogue;

import luisc.ucc.App;
import luisc.ucc.court.GunnerQuestions;

public class Gunner extends Dialogue {

  public Gunner(App app) {
    super(app);
  }

  @Override
  protected void _setup() {
    add(
      "Gunner: Was on watch for asteroids on the laser gun.",
      "adrian/wasonwatchforasteroids"
    );
    add("Gunner/thumbs-up: Sonny, you wouldn't believe the hellfire out");

    add("MC: Ok..., I have a couple question to ask you", "gunner/start");
  }

  @Override
  public void onDone() {
    setOptions(new GunnerQuestions(a));
  }
}
