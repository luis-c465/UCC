package luisc.ucc.explore;

import luisc.lib.Clickable;
import luisc.ucc.App;
import luisc.ucc.scene.Scenes;

public class CafeteriaExploration extends Exploration {

  public CafeteriaExploration(App app) {
    super(app);
  }

  @Override
  protected void _update() {
    if (isClicked("Enter medical")) {
      setExploration(new Medical(a));
    } else if (isClicked("court case")) {
      r.sfx.emergency.play(0);
      a.mainScene.inCourt = true;
    } else if (isClicked("Back to menu")) {
      a.scene = Scenes.StartUp;
    }
  }

  @Override
  protected void _setup() {
    bg = loadGif("options/cafeteria.gif");

    clickables =
      new Clickable[] {
        new ExplorationBtn(a, "Enter medical", 450, 350),
        new Interactable(a, "court case", 440, 467, 40, 40),
        new ExplorationBtn(a, "Back to menu", 900, 950),
      };
  }
}
