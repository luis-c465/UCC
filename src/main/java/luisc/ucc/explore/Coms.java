package luisc.ucc.explore;

import luisc.lib.Clickable;
import luisc.ucc.App;

public class Coms extends Exploration {

  public Coms(App app) {
    super(app);
  }

  @Override
  protected void _update() {
    if (isClicked("coms")) {
      a.achievements.add("ass");
    }
  }

  @Override
  protected void _setup() {
    bg = a.loadImage("options/comns.png");

    clickables =
      new Clickable[] {
        new Evidence(
          a,
          "coms",
          50,
          341,
          120,
          347,
          "MC: That's one phat amogus"
        ),
      };
  }
}
