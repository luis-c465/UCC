package luisc.resources;

import luisc.lib.BaseApp;
import luisc.lib.ResourceHolder;
import processing.core.PFont;

public class Fonts extends ResourceHolder<PFont> {

  public PFont nunito;
  // !Smaller versions of fonts are loaded because controlP5 does not give a method to set the font size of the input text
  public PFont nunito_small;
  public PFont nunito_smaller;

  public PFont segoe;

  @Override
  protected void load() {
    nunito = p.createFont("fonts/Nunito.ttf", 64);
    nunito_small = p.createFont("fonts/Nunito.ttf", 20);
    nunito_smaller = p.createFont("fonts/Nunito.ttf", 20);
    p.textFont(nunito);

    segoe = p.createFont("fonts/segoe.ttf", 20);
  }

  public Fonts(BaseApp p) {
    super(p);
  }
}
