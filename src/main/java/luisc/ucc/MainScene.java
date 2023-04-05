package luisc.ucc;

import luisc.lib.Obj;
import luisc.lib.PC;

/**
 * Main scene class which well, plays the game
 */
public class MainScene extends Obj {

  @Override
  protected void _update() {
    p.fill(255);
    p.rectMode(PC.CORNER);
    p.rect(500, 500, 25, 25);
  }

  public MainScene(App a) {
    super(a);
  }
}
