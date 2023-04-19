package luisc.resources;

import java.util.HashMap;
import java.util.Map;
import luisc.lib.BaseApp;
import luisc.lib.ResourceHolder;
import processing.core.PImage;

public class Achievements extends ResourceHolder<PImage> {

  public Map<String, PImage> unlockedImages;
  public Map<String, PImage> lockedImages;

  @Override
  protected void load() {
    unlockedImages = new HashMap<>();
    lockedImages = new HashMap<>();

    unlockedImages.put("ass", load("u/ass.png"));
    unlockedImages.put("ltg", load("u/ltg.png"));
    unlockedImages.put("pipe", load("u/pipe.png"));
    unlockedImages.put("reactor", load("u/reactor.png"));
    unlockedImages.put("win", load("u/win.png"));

    lockedImages.put("ass", load("l/ass.png"));
    lockedImages.put("ltg", load("l/ltg.png"));
    lockedImages.put("pipe", load("l/pipe.png"));
    lockedImages.put("reactor", load("l/reactor.png"));
    lockedImages.put("win", load("l/win.png"));
  }

  public Achievements(BaseApp p) {
    super(p);
  }

  public PImage load(String filename) {
    return p.loadImage("achievements/" + filename);
  }
}
