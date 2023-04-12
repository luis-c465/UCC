package luisc.ucc.explore;

import luisc.ucc.App;

public class CafeteriaExploration extends Exploration {

  public CafeteriaExploration(App app) {
    super(app);
  }

  @Override
  protected void _update() {
    if (isBtnClicked("Go into right hallway")) {
      setExploration(new MedicalHallway(a));
    }
  }

  @Override
  protected void _setup() {
    bg = p.loadImage("options/cafeteria.png");

    btns =
      new ExplorationBtn[] {
        new ExplorationBtn(a, "Go into left hallway", 200, 550),
        new ExplorationBtn(a, "Go into right hallway", 800, 615),
      };
  }
}
