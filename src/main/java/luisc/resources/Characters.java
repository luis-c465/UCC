package luisc.resources;

import luisc.lib.BaseApp;
import luisc.lib.ResourceHolder;
import processing.core.PImage;

public class Characters extends ResourceHolder<PImage> {

  public PImage mc;
  public PImage mcCrying;
  public PImage mcLigma;
  public PImage mcPointing;
  public PImage mcThinking;
  public PImage mcThumbsUp;
  public PImage mcWorried;

  public PImage medic;
  public PImage gunner;
  public PImage navigator;
  public PImage communicator;
  public PImage engineer;

  @Override
  protected void load() {
    mc = p.loadImage("mc/default.png");
    mcCrying = p.loadImage("mc/crying.png");
    mcLigma = p.loadImage("mc/ligma.png");
    mcPointing = p.loadImage("mc/pointing.png");
    mcThinking = p.loadImage("mc/thinking.png");
    mcThumbsUp = p.loadImage("mc/thumbs-up.png");
    mcWorried = p.loadImage("mc/worried.png");

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
