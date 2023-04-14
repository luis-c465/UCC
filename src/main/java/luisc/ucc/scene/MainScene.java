package luisc.ucc.scene;

import luisc.lib.Obj;
import luisc.ucc.App;
import luisc.ucc.court.Court;
import luisc.ucc.explore.CafeteriaExploration;
import luisc.ucc.explore.Exploration;

/**
 * Main scene class which well, plays the game
 */
public class MainScene extends Obj {

  public static final int TICKS_TO_SWITCH = 6;
  public int ticksSwitched = 0;

  public boolean inCourt = true;

  public Exploration exploration;
  public Court court;

  @Override
  protected void _setup() {
    exploration = new CafeteriaExploration(a);
    exploration.setup();

    court = new Court(a);
    court.setup();
  }

  @Override
  protected void _update() {
    if (inCourt) {
      court.update();
    } else {
      exploration.update();
    }
  }

  public MainScene(App a) {
    super(a);
  }
}
