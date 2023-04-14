package luisc.ucc.explore;

import luisc.ucc.App;

public class ComsHallway extends Exploration {

  public ComsHallway(App app) {
    super(app);
  }

  @Override
  protected void _update() {
    if (isClicked("Go into coms")) {
      setExploration(new Coms(a));
    } else if (isClicked("Go into shields")) {
      setExploration(new Shields(a));
    }
  }

  @Override
  protected void _setup() {
    bg = p.loadImage("options/coms-hallway.png");

    clickables =
      new ExplorationBtn[] {
        new ExplorationBtn(a, "Go into coms", 650, 730),
        new ExplorationBtn(a, "Go into shields", 157, 622),
      };
  }
}
