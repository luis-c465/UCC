package luisc.ucc.scene;

import luisc.lib.Obj;
import luisc.lib.PC;
import luisc.ucc.App;

/**
 * Main scene class which well, plays the game
 */
public class DLC extends Obj {

  @Override
  protected void _update() {
    p.background(255);
    p.image(r.i.dlc, 0, 0, App.w, App.h);

    p.textMode(PC.CORNER);
    p.textSize(50);
    p.fill(0);
    p.text("Press space to go back", App.cw, 50);

    if (p.keyPressed && p.key == ' ') {
      a.scene = Scenes.StartUp;
    }
  }

  public DLC(App a) {
    super(a);
  }
}
