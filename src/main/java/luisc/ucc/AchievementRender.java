package luisc.ucc;

import java.util.HashSet;
import java.util.Set;
import luisc.lib.Obj;
import luisc.lib.PC;
import luisc.ucc.scene.Achievements;
import processing.core.PImage;

public class AchievementRender extends Obj {

  public String lastAdded = null;
  public Set<String> achievements = new HashSet<>();
  public int showTime = 0;
  public static final int showTimeMax = 100;

  public AchievementRender(App app) {
    super(app);
  }

  @Override
  protected void _update() {
    if (showTime > showTimeMax || lastAdded == null) {
      return;
    }

    PImage img = r.achievements.unlockedImages.get(lastAdded);
    p.imageMode(PC.CENTER);
    p.image(
      img,
      App.cw,
      App.map(
        App.min(showTime, 10),
        0,
        10,
        -Achievements.h / 2,
        Achievements.h / 2
      ),
      Achievements.w,
      Achievements.h
    );

    showTime++;
  }

  public void add(String achievement) {
    if (achievements.add(achievement)) {
      lastAdded = achievement;
      showTime = 0;
    }
  }
}
