package luisc.ucc.explore;

import luisc.ucc.App;

public class ElectricalHallway extends Exploration {

  public ElectricalHallway(App app) {
    super(app);
  }

  @Override
  protected void _update() {
    if (isClicked("Go into electrical")) {
      setExploration(new Electrical(a));
    } else if (isClicked("Go into storage")) {
      setExploration(new Storage(a));
    }
  }

  @Override
  protected void _setup() {
    bg = p.loadImage("options/electrical-hallway.png");

    clickables =
      new ExplorationBtn[] {
        new ExplorationBtn(a, "Go into electrical", 100, 430),
        new ExplorationBtn(a, "Go into storage", 840, 600),
      };
  }
}
