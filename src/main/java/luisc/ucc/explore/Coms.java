package luisc.ucc.explore;

import luisc.ucc.App;

public class Coms extends Exploration {

  public Coms(App app) {
    super(app);
  }

  @Override
  protected void _update() {
    if (isClicked("Go back")) {
      setExploration(new ComsHallway(a));
    }
  }

  @Override
  protected void _setup() {
    bg = p.loadImage("options/coms.png");

    clickables =
      new ExplorationBtn[] { new ExplorationBtn(a, "Go back", 664, 623) };
  }
}
