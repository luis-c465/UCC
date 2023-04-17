package luisc.ucc.explore;

import luisc.lib.Clickable;
import luisc.ucc.App;

public class Reactor extends Exploration {

  public Reactor(App app) {
    super(app);
  }

  @Override
  protected void _update() {
    if (isClicked("buttons")) {
      r.sfx.metalPipe.play(0);
    }
  }

  @Override
  protected void _setup() {
    bg = loadGif("reactor.gif");

    clickables =
      new Clickable[] { new Interactable(a, "buttons", 500, 550, 50, 50) };
  }
}
