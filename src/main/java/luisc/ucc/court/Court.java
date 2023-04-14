package luisc.ucc.court;

import luisc.lib.Obj;
import luisc.ucc.App;
import luisc.ucc.dialogue.Dialogue;
import luisc.ucc.dialogue.Options;

public class Court extends Obj {

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
    if (dialogue.done) {
      options.update();
    } else {
      dialogue.update();
    }
  }

  public void setDialogue(Dialogue dia) {
    dialogue = dia;
    dia.setup();
  }
}
