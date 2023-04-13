package luisc.ucc.explore;

import luisc.ucc.App;

public class Shields extends Exploration {

  public Shields(App app) {
    super(app);
  }

  @Override
  protected void _update() {
    if (isBtnClicked("Go back into hallway")) {
      setExploration(new ComsHallway(a));
    } else if (isBtnClicked("Go into next hallway")) {
      setExploration(new O2Hallway(a));
    }
  }

  @Override
  protected void _setup() {
    bg = p.loadImage("options/sheidls.png");

    btns =
      new ExplorationBtn[] {
        new ExplorationBtn(a, "Go back into hallway", 100, 758),
        new ExplorationBtn(a, "Go into next hallway", 570, 341),
      };
  }
}
