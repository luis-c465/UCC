package luisc.ucc.explore;

import luisc.ucc.App;

public class LeftEngine extends Exploration {

  public LeftEngine(App app) {
    super(app);
  }

  @Override
  protected void _update() {
    if (isBtnClicked("Go into next hallway")) {
      setExploration(new ReactorHallway(a));
    } else if (isBtnClicked("Go back into hallway")) {
      setExploration(new MedicalHallway(a));
    }
  }

  @Override
  protected void _setup() {
    bg = p.loadImage("options/l-engine.jpg");

    btns =
      new ExplorationBtn[] {
        new ExplorationBtn(a, "Go into next hallway", 630, 200),
        new ExplorationBtn(a, "Go back into hallway", 70, 900),
      };
  }
}
