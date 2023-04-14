package luisc.ucc.explore;

import luisc.ucc.App;

public class Security extends Exploration {

  public Security(App app) {
    super(app);
  }

  @Override
  protected void _update() {
    if (isClicked("Go into hallway")) {
      setExploration(new ReactorHallway(a));
    }
  }

  @Override
  protected void _setup() {
    bg = p.loadImage("options/security.png");

    clickables =
      new ExplorationBtn[] {
        new ExplorationBtn(a, "Go into hallway", 500, 900),
      };
  }
}
