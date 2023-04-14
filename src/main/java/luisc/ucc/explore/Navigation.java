package luisc.ucc.explore;

import luisc.ucc.App;

public class Navigation extends Exploration {

  public Navigation(App app) {
    super(app);
  }

  @Override
  protected void _update() {
    if (isClicked("Go back")) {
      setExploration(new O2Hallway(a));
    }
  }

  @Override
  protected void _setup() {
    bg = p.loadImage("options/navigation.png");

    clickables =
      new ExplorationBtn[] { new ExplorationBtn(a, "Go back", 482, 950) };
  }
}
