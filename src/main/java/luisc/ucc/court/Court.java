package luisc.ucc.court;

import luisc.lib.Obj;
import luisc.ucc.App;
import luisc.ucc.dialogue.Dialogue;
import luisc.ucc.dialogue.Options;
import luisc.ucc.dialogue.StartDialogue;

public class Court extends Obj {

  public static final int TICKS_TO_SWITCH = 10;

  /**
   * Count of the number of skill issues by the player
   */
  public int fuckUps = 0;
  public static final int maxFuckUps = 5;

  public Options options;
  public Dialogue dialogue;

  public Court(App app) {
    super(app);
  }

  @Override
  protected void _setup() {
    options = new StartOptions(a);
    options.setup();

    dialogue = new StartDialogue(a);
    dialogue.setup();
  }

  @Override
  protected void _update() {
    if (a.mainScene.ticksSwitched > 0) {
      a.mainScene.ticksSwitched--;
    }

    if (dialogue.done) {
      options.update();
    } else {
      dialogue.update();
    }
  }

  public void setDialogue(Dialogue dia) {
    if (a.mainScene.ticksSwitched != 0) {
      return;
    }

    dialogue = dia;
    dia.setup();
    a.mainScene.ticksSwitched = TICKS_TO_SWITCH;
  }

  public void setOptions(Options opts) {
    if (a.mainScene.ticksSwitched != 0) {
      return;
    }

    options = opts;
    opts.setup();
    a.mainScene.ticksSwitched = TICKS_TO_SWITCH;
  }
}
