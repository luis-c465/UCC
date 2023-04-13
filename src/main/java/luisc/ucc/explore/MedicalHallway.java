package luisc.ucc.explore;

import luisc.ucc.App;

public class MedicalHallway extends Exploration {

  public MedicalHallway(App app) {
    super(app);
  }

  @Override
  protected void _update() {
    if (isBtnClicked("Go into medical")) {
      App.println("Goes into medical");
      setExploration(new Medical(a));
    } else if (isBtnClicked("Go into reactor hallway")) {
      setExploration(new ReactorHallway(a));
    } else if (isBtnClicked("Go back into cafeteria")) {
      setExploration(new CafeteriaExploration(a));
    }
  }

  @Override
  protected void _setup() {
    bg = p.loadImage("options/medical-hallway.png");

    btns =
      new ExplorationBtn[] {
        new ExplorationBtn(a, "Go into medical", 175, 623),
        new ExplorationBtn(a, "Go into reactor hallway", 900, 575),
        new ExplorationBtn(a, "Go back into cafeteria", 500, 900),
      };
  }
}
