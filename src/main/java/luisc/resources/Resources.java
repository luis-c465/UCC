package luisc.resources;

import luisc.lib.BaseApp;
import luisc.ucc.App;
import processing.core.PApplet;

/**
 * Class which loads images and audio to be used in the main class {@link App}
 *
 * Call the {@link #setup(PApplet) setup method} to load all the images and the sounds
 */
public class Resources {

  public Images i;
  public Shapes s;
  public Colors c;
  public Fonts f;
  public Characters ch;
  public Sounds sfx;
  public Achievements achievements;

  public Resources(BaseApp p) {
    i = new Images(p);
    s = new Shapes(p);
    c = new Colors(p);
    f = new Fonts(p);
    ch = new Characters(p);
    sfx = new Sounds(p);
    achievements = new Achievements(p);
  }
}
