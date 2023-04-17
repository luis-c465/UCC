package luisc.ucc.explore;

import luisc.lib.Clickable;
import luisc.ucc.App;

public class LeftEngine extends Exploration {

  public LeftEngine(App app) {
    super(app);
  }

  @Override
  protected void _update() {
    if (isClicked("button")) {
      r.sfx.peppino.play(0);
    } else if (isClicked("!!!")) {
      r.sfx.metalPipe.play(0);
    }
  }

  @Override
  protected void _setup() {
    bg = loadGif("options/left_engine.gif");

    clickables =
      new Clickable[] {
        new Interactable(a, "button", 41, 494, 50, 50),
        new Interactable(a, "!!!", 644, 128, 50, 50),
      };
  }
}
