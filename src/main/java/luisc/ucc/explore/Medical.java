package luisc.ucc.explore;

import luisc.ucc.App;

public class Medical extends Exploration {

  public Medical(App app) {
    super(app);
  }

  @Override
  protected void _update() {
    if (isClicked("Get scanny")) {
      r.sfx.scan.play(0);
    } else if (isClicked("Go into security")) {
      setExploration(new Security(a));
    }
  }

  @Override
  protected void _setup() {
    bg = p.loadImage("options/medical.png");

    clickables =
      new ExplorationBtn[] {
        new ExplorationBtn(a, "Get scanny", 800, 675),
        new ExplorationBtn(a, "Go into security", 500, 900),
      };
  }
}
