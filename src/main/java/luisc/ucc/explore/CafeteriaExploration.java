package luisc.ucc.explore;

import luisc.lib.Clickable;
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
    } else if (isClicked("court case")) {
      a.mainScene.inCourt = true;
    }
  }

  @Override
  protected void _setup() {
    bg = loadGif("options/cafeteria.gif");

    clickables =
      new Clickable[] {
        new ExplorationBtn(a, "Enter medical", 450, 350),
        new Interactable(a, "court case", 440, 467, 40, 40),
      };
  }
}
