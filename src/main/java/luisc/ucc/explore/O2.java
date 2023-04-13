package luisc.ucc.explore;

import luisc.ucc.App;

public class O2 extends Exploration {

  public O2(App app) {
    super(app);
  }

  @Override
  protected void _update() {
    if (isBtnClicked("Go back")) {
      setExploration(new O2Hallway(a));
    }
  }

  @Override
  protected void _setup() {
    bg = p.loadImage("options/02.png");

    btns = new ExplorationBtn[] { new ExplorationBtn(a, "Go back", 482, 950) };
  }
}
