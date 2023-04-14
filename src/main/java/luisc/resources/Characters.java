package luisc.resources;

import luisc.lib.BaseApp;
import luisc.lib.ResourceHolder;
import processing.core.PImage;

public class Characters extends ResourceHolder<PImage> {

  public PImage mc;
  public PImage medic;

  @Override
  protected void load() {
    mc = p.loadImage("gamer.png");
    medic = p.loadImage("gamer.png");
  }

  public Characters(BaseApp p) {
    super(p);
  }
}
