package luisc.ucc.dialogue;

import luisc.ucc.App;

public class Medic extends Dialogue {

  public Medic(App app) {
    super(app);
  }

  @Override
  protected void _setup() {
    add("Medic/", r.ch.medic);
    add("MC/", r.ch.mc);

    add("Medic: I was watching you sleep in the medical bay.");
    add("MC: You're weird. I'n not sure I like you.");
    add("MC: I'm VERy suspicious of you, Red.");
    add("Medic: Aww, thanks!");
    add("Medic: Hee-hee.");
  }
}
