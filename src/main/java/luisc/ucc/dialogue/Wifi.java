package luisc.ucc.dialogue;

import luisc.ucc.App;
import luisc.ucc.court.GunnerQuestions;

public class Wifi extends Dialogue {

  public Wifi(App app) {
    super(app);
  }

  @Override
  protected void _setup() {
    add("MC: Bit strange, don't you think?");
    if (a.hasEvidence("wifi")) {
      add(
        "MC/thinking: Cutting off means of communication? Or a simple mishap?"
      );
      add("MC/pointing: I think you're hiding something, Green.");

      add(
        "Gunner/thumbs-up: I have no idea what that panel is for sonny. I just shoot things."
      );
      add("MC: I'm not buying it but oh well.");

      a.mainScene.court.fuckUps++;
    } else {
      add("Gunner/thinking: How so?");
      add("[??]");
      add("MC/crying: I really dont know, I think the screen was broken");
      add("Gunner/worried: 'I think'?");
      add(
        "Gunner/worried: Aren't you the detective here sonny. Shouldn't you have more evidence before leaping to conclusions?"
      );

      add("MC/ligma: Yeah :(");

      a.mainScene.court.fuckUps += 2;
    }
  }

  @Override
  public void onDone() {
    setOptions(new GunnerQuestions(a));
  }
}
