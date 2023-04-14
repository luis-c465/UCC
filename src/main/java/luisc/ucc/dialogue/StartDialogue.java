package luisc.ucc.dialogue;

import luisc.ucc.App;

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
