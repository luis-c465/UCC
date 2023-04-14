package luisc.ucc.explore;

import luisc.ucc.App;

public class Electrical extends Exploration {

  public Electrical(App app) {
    super(app);
  }

  @Override
  protected void _update() {
    if (isClicked("Go back outside")) {
      setExploration(new ElectricalHallway(a));
    }
  }

  @Override
  protected void _setup() {
    bg = p.loadImage("options/electrical-1.png");

    clickables =
      new ExplorationBtn[] {
        new ExplorationBtn(a, "Go back outside", 800, 800),
      };
  }
}
