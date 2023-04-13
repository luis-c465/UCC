package luisc.ucc.explore;

import luisc.ucc.App;

public class Coms extends Exploration {

  public Coms(App app) {
    super(app);
  }

  @Override
  protected void _update() {
    if (isBtnClicked("Go back")) {
      setExploration(new ComsHallway(a));
    }
  }

  @Override
  protected void _setup() {
    bg = p.loadImage("options/coms.png");

    btns = new ExplorationBtn[] { new ExplorationBtn(a, "Go back", 664, 623) };
  }
}
