package luisc.ucc.explore;

import luisc.ucc.App;

public class Medical extends Exploration {

  public Medical(App app) {
    super(app);
  }

  @Override
  protected void _update() {
    if (isBtnClicked("Get scanny")) {
      r.sfx.scan.play(0);
    } else if (isBtnClicked("Go to sleep")) {
      App.println("zzzzzz");
    } else if (isBtnClicked("Go back into hallway")) {
      setExploration(new MedicalHallway(a));
    }
  }

  @Override
  protected void _setup() {
    bg = p.loadImage("options/medical.png");

    btns =
      new ExplorationBtn[] {
        new ExplorationBtn(a, "Get scanny", 800, 675),
        new ExplorationBtn(a, "Go to sleep", 200, 862),
        new ExplorationBtn(a, "Go back into hallway", 500, 900),
      };
  }
}
