package luisc.ucc.scene;

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

  @Override
  @SuppressWarnings("unchecked")
  protected void _update() {
    p.background(255);
    p.image(r.i.court, 0, 0, App.w, App.h);
    for (int i = 0; i < r.achievements.lockedImages.size(); i++) {
      Map.Entry<String, PImage> entry = (Map.Entry<String, PImage>) r.achievements.lockedImages
        .entrySet()
        .toArray()[i];

      String key = entry.getKey();

      boolean has = a.achievements.contains(key);
      PImage value = has
        ? r.achievements.unlockedImages.get(key)
        : r.achievements.lockedImages.get(key);

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

  public Achievements(App a) {
    super(a);
  }
}
