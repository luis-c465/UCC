package luisc.ucc.explore;

import luisc.lib.Clickable;
import luisc.lib.Obj;
import luisc.ucc.App;
import luisc.ucc.scene.MainScene;
import processing.core.PImage;

public class Exploration extends Obj {

  public PImage bg;
  public Clickable[] clickables;

  @Override
  protected void preUpdate() {
    super.preUpdate();

    p.image(bg, 0, 0, App.w, App.h);

    for (Clickable btn : clickables) {
      btn.update();
    }

    if (a.mainScene.ticksSwitched > 0) {
      a.mainScene.ticksSwitched--;
    }
  }

  /**
   * You can check for each btn if it was clicked
   */
  @Override
  protected void _update() {}

  protected boolean isClicked(String identifier) {
    for (Clickable btn : clickables) {
      if (btn.identifier.equals(identifier)) {
        return btn.clicked;
      }
    }

    // Btn not found
    return false;
  }

  protected PImage loadImage(String path) {
    return p.loadImage("options/" + path);
  }

  /**
   * Sets the exploration
   *
   * Will not be set if the exploration was changed in the last couple frames
   * I.E. there is a cool down between changing scenes
   */
  protected void setExploration(Exploration exploration) {
    if (a.mainScene.ticksSwitched != 0) {
      return;
    }

    a.mainScene.exploration = exploration;
    exploration.setup();

    a.mainScene.ticksSwitched = MainScene.TICKS_TO_SWITCH;
  }

  public Exploration(App app) {
    super(app);
  }
}
