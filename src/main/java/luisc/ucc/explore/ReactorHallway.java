package luisc.ucc.explore;

import luisc.ucc.App;

public class ReactorHallway extends Exploration {

  public ReactorHallway(App app) {
    super(app);
  }

  @Override
  protected void _update() {
    if (isBtnClicked("Go into security")) {
      setExploration(new Security(a));
    } else if (isBtnClicked("Go into reactor")) {
      setExploration(new Reactor(a));
    } else if (isBtnClicked("Go into next hallway")) {
      setExploration(new ElectricalHallway(a));
    }
  }

  @Override
  protected void _setup() {
    bg = p.loadImage("options/reactor-hallway.png");

    btns =
      new ExplorationBtn[] {
        new ExplorationBtn(a, "Go into security", 150, 586),
        new ExplorationBtn(a, "Go into reactor", 840, 600),
        new ExplorationBtn(a, "Go into next hallway", 500, 400),
      };
  }
}
