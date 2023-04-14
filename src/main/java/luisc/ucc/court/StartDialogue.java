package luisc.ucc.court;

import luisc.ucc.App;
import luisc.ucc.dialogue.Dialogue;

public class StartDialogue extends Dialogue {

  public StartDialogue(App app) {
    super(app);
  }

  @Override
  protected void _setup() {
    add("MC/", r.ch.mc);

    add(
      "MC: Alright, first things first, where was everyone located before the murder?"
    );
  }
}
