package luisc.ucc.explore;

import luisc.ucc.App;

public class O2Hallway extends Exploration {

  public O2Hallway(App app) {
    super(app);
  }

  @Override
  protected void _update() {
    if (isClicked("Go into navigation")) {
      setExploration(new Navigation(a));
    } else if (isClicked("Go into o2")) {
      setExploration(new O2(a));
    } else if (isClicked("Go into weapons")) {
      setExploration(new Weapons(a));
    } else if (isClicked("Go back into shields")) {
      setExploration(new Shields(a));
    }
  }

  @Override
  protected void _setup() {
    bg = p.loadImage("options/o2-hallway.png");

    clickables =
      new ExplorationBtn[] {
        new ExplorationBtn(a, "Go into navigation", 776, 661),
        new ExplorationBtn(a, "Go into o2", 184, 457),
        new ExplorationBtn(a, "Go into weapons", 310, 329),
        new ExplorationBtn(a, "Go back into shields", 285, 953),
      };
  }
}
