package luisc.ucc.explore;

import luisc.ucc.App;

public class Weapons extends Exploration {

  public Weapons(App app) {
    super(app);
  }

  @Override
  protected void _update() {
    if (isBtnClicked("Go to cafeteria")) {
      setExploration(new CafeteriaExploration(a));
    } else if (isBtnClicked("Go to back")) {
      setExploration(new O2Hallway(a));
    }
  }

  @Override
  protected void _setup() {
    bg = p.loadImage("options/weapons.png");

    btns =
      new ExplorationBtn[] {
        new ExplorationBtn(a, "Go to cafeteria", 100, 775),
        new ExplorationBtn(a, "Go to back", 500, 900),
      };
  }
}
