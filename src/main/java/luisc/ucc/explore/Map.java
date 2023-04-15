package luisc.ucc.explore;

import luisc.lib.FullScreenModal;
import luisc.lib.PC;
import luisc.ucc.App;

public class Map extends FullScreenModal {

  @Override
  protected void _setup() {
    img = r.i.map;
  }

  @Override
  protected void preUpdate() {
    if (a.keyPressed && a.key == 'm') {
      beginShowing = true;
    }

    super.preUpdate();
  }

  @Override
  protected void _update() {
    super._update();

    if (!show) return;
    p.textSize(32);
    p.textAlign(PC.CENTER);
    p.fill(255);
    p.text("Map screen", App.cw, 25);
  }

  public Map(App app) {
    super(app);
  }
}
