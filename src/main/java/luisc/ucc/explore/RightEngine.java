package luisc.ucc.explore;

import luisc.lib.Clickable;
import luisc.ucc.App;

public class RightEngine extends Exploration {

  public RightEngine(App app) {
    super(app);
  }

  @Override
  protected void _update() {
    if (isClicked("buttons")) {
      r.sfx.peppino.play(0);
    } else if (isClicked("check")) {
      r.sfx.fakePeppino.play(0);
    }
  }

  @Override
  protected void _setup() {
    bg = loadGif("options/right-engine.gif");

    clickables =
      new Clickable[] {
        new Interactable(a, "buttons", 941, 480, 50, 50),
        new Interactable(a, "check", 348, 141, 50, 50),
      };
  }
}
