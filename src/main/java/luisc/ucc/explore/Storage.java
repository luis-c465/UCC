package luisc.ucc.explore;

import luisc.lib.Clickable;
import luisc.ucc.App;

public class Storage extends Exploration {

  public Storage(App app) {
    super(app);
  }

  @Override
  protected void _update() {
    // nothing happens here
  }

  @Override
  protected void _setup() {
    bg = p.loadImage("storage.png");
    clickables = new Clickable[] {};
  }
}
