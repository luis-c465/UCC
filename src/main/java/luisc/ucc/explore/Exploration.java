package luisc.ucc.explore;

import gifAnimation.Gif;
import luisc.lib.ClickableHolder;
import luisc.ucc.App;
import luisc.ucc.scene.MainScene;
import processing.core.PApplet;
import processing.core.PImage;

public class Exploration extends ClickableHolder {

  public PImage bg;

  @Override
  protected void postUpdate() {
    p.image(bg, 0, 0, App.w, App.h);

    if (a.mainScene.ticksSwitched > 0) {
      a.mainScene.ticksSwitched--;
    }

    super.postUpdate();
  }

  /**
   * You can check for each btn if it was clicked
   */
  @Override
  protected void _update() {}

  protected PImage loadImage(String path) {
    return p.loadImage("options/" + path);
  }

  /**
   * Sets the exploration
   *
   * Will not be set if the exploration was changed in the last couple frames
   * I.E. there is a cool down between changing scenes
   */
  public void setExploration(Exploration exploration) {
    if (a.mainScene.ticksSwitched != 0) {
      return;
    }

    a.mainScene.exploration = exploration;
    exploration.setup();

    a.mainScene.ticksSwitched = MainScene.TICKS_TO_SWITCH;
  }

  /**
   * Loads a gif and plays it
   */
  public PImage loadGif(String path) {
    Gif temp = new Gif(a, path);
    temp.play();
    return temp;
  }

  /**
   * Loads a gif and plays it
   */
  public static PImage loadGif(PApplet a, String path) {
    Gif temp = new Gif(a, path);
    temp.play();
    return temp;
  }

  public Exploration(App app) {
    super(app);
  }
}
