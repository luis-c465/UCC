package luisc.resources;

import luisc.lib.BaseApp;
import luisc.lib.ResourceHolder;
import processing.core.PImage;

public class Images extends ResourceHolder<PImage> {

  public PImage intro;
  public PImage tutorial;
  public PImage bg;
  public PImage miss;
  public PImage amog;
  public PImage shotAmog;
  public PImage water;
  public PImage enter;
  public PImage winner;
  public PImage textBox;
  public PImage transparent;
  public PImage gamer;

  public PImage map;

  @Override
  protected void load() {
    intro = p.loadImage("intro2.png");
    tutorial = p.loadImage("instructions.png");
    bg = p.loadImage("bg.jpg");

    miss = p.loadImage("miss.png");
    amog = p.loadImage("amog.png");
    shotAmog = p.loadImage("shot-amog.png");
    water = p.loadImage("water.png");

    enter = p.loadImage("enter.png");
    winner = p.loadImage("winner.jpeg");

    textBox = p.loadImage("textBox.png");

    transparent = p.loadImage("transparent.png");

    gamer = p.loadImage("gamer-small.png");

    map = p.loadImage("map.png");
  }

  public Images(BaseApp p) {
    super(p);
  }
}
