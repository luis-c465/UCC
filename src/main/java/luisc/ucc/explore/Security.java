package luisc.ucc.explore;

import luisc.ucc.App;

public class Security extends Exploration {

  public Security(App app) {
    super(app);
  }

  @Override
  protected void _update() {
    if (isClicked("Go into electrical")) {
      setExploration(new Electrical(a));
    }
  }

  @Override
  protected void _setup() {
    bg = loadGif("options/security.gif");

    clickables =
      new ExplorationBtn[] {
        new ExplorationBtn(a, "Go into electrical", 500, 900),
      };

    a.evidence.add("cams");
  }
}
