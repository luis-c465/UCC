package luisc.ucc.explore;

import luisc.ucc.App;

public class Weapons extends Exploration {

  public Weapons(App app) {
    super(app);
  }

  @Override
  protected void _update() {
    if (isClicked("Go to cafeteria")) {
      setExploration(new CafeteriaExploration(a));
    } else if (isClicked("Go to back")) {
      setExploration(new O2Hallway(a));
    }
  }

  @Override
  protected void _setup() {
    bg = p.loadImage("options/weapons.png");

    clickables =
      new ExplorationBtn[] {
        new ExplorationBtn(a, "Go to cafeteria", 100, 775),
        new ExplorationBtn(a, "Go to back", 500, 900),
      };
  }
}
