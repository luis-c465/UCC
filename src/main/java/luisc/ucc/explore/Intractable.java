package luisc.ucc.explore;

import luisc.lib.Clickable;
import luisc.ucc.App;

public class Intractable extends Clickable {

  public Intractable(App app) {
    super(app);
  }

  public Intractable(App app, String name, int x, int y, int w, int h) {
    super(app, x, y, w, h);
    this.identifier = name;

    setup();
  }

  @Override
  protected void _update() {}
}
