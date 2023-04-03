package luisc.ucc;

import luisc.lib.Intro;
import processing.core.PImage;

public class AppIntro extends Intro {

  protected void _setup() {
    slides = new PImage[] { r.i.intro, r.i.tutorial };
  }

  public AppIntro(App app) {
    super(app);
  }
}
