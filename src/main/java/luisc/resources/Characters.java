package luisc.resources;

import luisc.lib.BaseApp;
import luisc.lib.ResourceHolder;
import processing.core.PImage;

public class Characters extends ResourceHolder<PImage> {

  public PImage mc;
  public PImage medic;
  public PImage gunner;
  public PImage navigator;
  public PImage communicator;
  public PImage engineer;

  @Override
  protected void load() {
    mc = p.loadImage("gamer.png");
    medic = p.loadImage("gamer.png");
    gunner = p.loadImage("gamer.png");
    navigator = p.loadImage("gamer.png");
    communicator = p.loadImage("gamer.png");
    engineer = p.loadImage("gamer.png");
  }

  public Characters(BaseApp p) {
    super(p);
  }
}
