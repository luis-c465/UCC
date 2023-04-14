package luisc.ucc.explore;

import luisc.ucc.App;

public class Storage extends Exploration {

  public Storage(App app) {
    super(app);
  }

  @Override
  protected void _update() {
    if (isClicked("Go coms hallway")) {
      setExploration(new ComsHallway(a));
    }
  }

  @Override
  protected void _setup() {
    bg = p.loadImage("options/storage.png");

    clickables =
      new ExplorationBtn[] {
        new ExplorationBtn(a, "Go coms hallway", 413, 683),
      };
  }
}
