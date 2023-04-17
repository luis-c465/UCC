package luisc.ucc.explore;

import luisc.lib.Clickable;
import luisc.lib.PC;
import luisc.ucc.App;

public class Interactable extends Clickable {

  public Interactable(App app) {
    super(app);
  }

  public Interactable(App app, String name, int x, int y, int w, int h) {
    super(app, x, y, w, h);
    this.identifier = name;

    setup();
  }

  @Override
  protected void _update() {
    p.fill(255);
    p.rectMode(PC.CORNERS);
    p.rect(left, top, right, bottom);
  }

  @Override
  protected void onClick() {
    App.println("pain");
  }
}
