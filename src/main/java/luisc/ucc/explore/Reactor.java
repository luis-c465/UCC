package luisc.ucc.explore;

import luisc.ucc.App;

public class Reactor extends Exploration {

  public Reactor(App app) {
    super(app);
  }

  @Override
  protected void _update() {
    if (isClicked("Go into hallway")) {
      setExploration(new ReactorHallway(a));
    }
  }

  @Override
  protected void _setup() {
    bg = p.loadImage("options/reactor.png");

    clickables =
      new ExplorationBtn[] {
        new ExplorationBtn(a, "Go into hallway", 500, 900),
      };
  }
}
