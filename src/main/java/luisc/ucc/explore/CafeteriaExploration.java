package luisc.ucc.explore;

import luisc.ucc.App;

public class CafeteriaExploration extends Exploration {

  public CafeteriaExploration(App app) {
    super(app);
  }

  @Override
  protected void _update() {
    if (isClicked("Enter medical")) {
      setExploration(new Medical(a));
    } else if (isClicked("")) {
      setExploration(new ElectricalHallway(a));
    } else if (isClicked("Start court case")) {
      a.mainScene.inCourt = true;
    }
  }

  @Override
  protected void _setup() {
    bg = loadGif("options/cafeteria.gif");

    clickables =
      new ExplorationBtn[] {
        new ExplorationBtn(a, "Start court case", 300, 317),
        new ExplorationBtn(a, "Enter medical", 300, 236),
      };
  }
}
