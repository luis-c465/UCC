package luisc.ucc.dialogue;

import luisc.ucc.App;

public class Medic extends Dialogue {

  public Medic(App app) {
    super(app);
  }

  @Override
  protected void _setup() {
    add(
      "Medic/thumbs-up: I was watching you sleep in the medical bay.",
      "adrian/medicwatchingyousleep"
    );
    add("Medic/thumbs-up: Just wanted to make sure you were okay.");
    add("Medic: A person just died the other day.");

    add("MC/worried: I mean sure..., thanks for the concern", "mc-medic");
    add("MC/worried: Tbh, You're weird. I'm not sure I like you.");
    add("MC/pointing: I'm VERy suspicious of you, Red.");

    add("Medic/thumbs-up: Aww, thanks!", "adrian/medicthanks");
    add("Medic: Hee-hee.");
  }
}
