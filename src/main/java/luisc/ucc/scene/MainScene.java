package luisc.ucc.scene;

import luisc.lib.Obj;
import luisc.ucc.App;
import luisc.ucc.court.Court;
import luisc.ucc.explore.CafeteriaExploration;
import luisc.ucc.explore.Exploration;
import luisc.ucc.explore.Map;

/**
 * Main scene class which well, plays the game
 */
public class MainScene extends Obj {

  public static final int TICKS_TO_SWITCH = 6;
  public int dialogueTicks = 0;
  // public int dialogueTicks = 0;
  public int ticksSwitched = 0;

  public boolean inCourt = false;

  public Exploration exploration;
  public Court court;
  public Map map;

  @Override
  protected void _setup() {
    exploration = new CafeteriaExploration(a);
    exploration.setup();

    court = new Court(a);
    court.setup();

    map = new Map(a);
    map.setup();
  }

  @Override
  protected void _update() {
    if (inCourt) {
      court.update();
    } else {
      exploration.update();
    }

    map.update();
  }

  public MainScene(App a) {
    super(a);
  }
}
