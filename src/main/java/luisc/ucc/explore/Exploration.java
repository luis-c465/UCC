package luisc.ucc.explore;

import luisc.lib.Btn;
import luisc.lib.Obj;
import luisc.ucc.App;
import processing.core.PImage;

public class Exploration extends Obj {

  public PImage bg;
  public ExplorationBtn[] btns;

  @Override
  protected void preUpdate() {
    super.preUpdate();

    p.image(bg, 0, 0, App.w, App.h);

    for (Btn btn : btns) {
      btn.update();
    }
  }

  /**
   * You can check for each btn if it was clicked
   */
  @Override
  protected void _update() {}

  protected boolean isBtnClicked(String txt) {
    for (Btn btn : btns) {
      if (btn.txt.equals(txt)) {
        return btn.clicked;
      }
    }

    // Btn not found
    return false;
  }

  protected PImage loadImage(String path) {
    return p.loadImage("options/" + path);
  }

  protected void setExploration(Exploration exploration) {
    a.mainScene.exploration = exploration;
    exploration.setup();
  }

  public Exploration(App app) {
    super(app);
  }
}
