package luisc.ucc.dialogue;

import luisc.ucc.App;
import luisc.ucc.court.StartOptions;

public class Engineer extends Dialogue {

  public Engineer(App app) {
    super(app);
  }

  @Override
  protected void _setup() {
    add("Engineer: Greasing up the engines");
    add("Engineer: Top engine specifically");

    add("MC: Well, any ohter place you cold have been during the murder?");
    add(
      "Engineer: Probably electrical to work on the comms panel which is somehow always not functioning."
    );

    if (!hasEvidence("electrical-grease")) {
      add("MC: Not near teh scene. Alright then I guess. :P");
    } else {
      add("MC: Got a bit messy in the electrical vent huh?");
      add(
        "Engineer: Pretty much. I dragged some of the engine grease in and someone doesn't know how to put the fucking mop back in the electrical cabinet so I dont know where it is."
      );

      if (!hasEvidence("electrical-cabinet")) {
        add("MC: Alright you're clear now");
      } else {
        add(
          "MC: I noticed the cabinet was open. Maybe the murderer took it to clean up his tracks. The dumb bitch lmfao"
        );

        if (!hasEvidence("electrical-wires")) {
          add("MC: You cleared. We good homie.");
        } else {
          add("MC: What about those cut wires engie? Pretty sus ngl.");
          add(
            "Engineer: Tried to see if cutting the wires could help make comms work again."
          );
          add("MC: You don't have a degree in engineering do you?");
          add("Engineer: Nope. I have no fucking clue what i'm doing.");
          add("MC: *sigh* I'm surrounded by fucking idiots.");
        }
      }
    }
  }

  @Override
  public void onDone() {
    setOptions(new StartOptions(a));
  }
}
