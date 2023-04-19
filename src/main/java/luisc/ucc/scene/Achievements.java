package luisc.ucc.scene;

import java.util.HashMap;
import java.util.Map;
import luisc.lib.Obj;
import luisc.lib.PC;
import luisc.ucc.App;
import processing.core.PImage;

/**
 * Main scene class which well, plays the game
 */
public class Achievements extends Obj {

  public static final int padding = 50;
  public static final int w = 250;
  public static final int h = 125;

  Map<String, PImage> unlockedImages = new HashMap<>();
  Map<String, PImage> lockedImages = new HashMap<>();

  @Override
  protected void _setup() {
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

  @Override
  @SuppressWarnings("unchecked")
  protected void _update() {
    p.background(255);
    p.image(r.i.court, 0, 0, App.w, App.h);
    for (int i = 0; i < lockedImages.size(); i++) {
      Map.Entry<String, PImage> entry = (Map.Entry<String, PImage>) lockedImages
        .entrySet()
        .toArray()[i];

      String key = entry.getKey();

      boolean has = a.achievements.contains(key);
      PImage value = has ? entry.getValue() : lockedImages.get(key);

      int row = i / 3;
      p.imageMode(PC.CORNER);
      p.image(
        value,
        (i % 3) * (w + padding) + padding,
        (row + 1) * (h + padding) + padding,
        w,
        h
      );
    }

    p.textMode(PC.CORNER);
    p.textSize(50);
    p.fill(255);
    p.text("Press space to go back", App.cw, App.h - 50);
    p.text("Achievements", App.cw, 50);

    if (p.keyPressed && p.key == ' ') {
      a.scene = Scenes.StartUp;
    }
  }

  public PImage load(String filename) {
    return p.loadImage("achievements/" + filename);
  }

  public Achievements(App a) {
    super(a);
  }
}
