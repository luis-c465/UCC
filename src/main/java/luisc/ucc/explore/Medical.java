package luisc.ucc.explore;

import luisc.lib.Clickable;
import luisc.lib.PC;
import luisc.ucc.App;

public class Medical extends Exploration {

  public Medical(App app) {
    super(app);
  }

  @Override
  protected void _update() {
    if (isClicked("scanner")) {
      r.sfx.scan.play(0);
    }
  }

  @Override
  protected void postUpdate() {
    super.postUpdate();

    if (r.sfx.scan.isPlaying()) {
      push();
      p.imageMode(PC.CENTER);
      p.image(r.i.scan, 851, 700, 130, 130);
      pop();
    }
  }

  @Override
  protected void _setup() {
    bg = p.loadImage("options/medical.png");

    clickables =
      new Clickable[] { new Interactable(a, "scanner", 851, 675, 346, 362) };
  }
}
