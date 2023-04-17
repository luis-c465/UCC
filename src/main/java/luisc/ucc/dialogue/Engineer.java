package luisc.ucc.dialogue;

import luisc.ucc.App;
import luisc.ucc.court.StartOptions;

public class Engineer extends Dialogue {

  public Engineer(App app) {
    super(app);
  }

  @Override
  protected void _setup() {
    add(
      "Engineer: Greasing up the engines",
      "adrian/oye_papito_greasing_up_the_engines"
    );
    add("Engineer: Top engine specifically");

    add(
      "MC/thinking: Well, any other place you could have been during the murder?",
      "engineer/place"
    );
    add(
      "Engineer/worried: Probably electrical to work on the comms panel which is somehow always not functioning."
    );

    if (!hasEvidence("electrical-grease")) {
      add(
        "MC/worried: Not near the scene. Alright then I guess. :P",
        "engineer/not-scene"
      );
    } else {
      add(
        "MC/pointing: Got a bit messy in the electrical vent huh?",
        "engineer/messy"
      );
      add(
        "Engineer/thumbs-up: Pretty much. I dragged some of the engine grease in and someone doesn't know how to put the fucking mop back in the electrical cabinet so I dont know where it is.",
        "adrian/claro_que_si"
      );

      if (!hasEvidence("electrical-cabinet")) {
        add("MC/thumbs-up: Alright you're clear now", "engineer/clear");
      } else {
        add(
          "MC: I noticed the cabinet was open. Maybe the murderer took it to clean up his tracks. The dumb bitch lmfao",
          "engineer/cabinet"
        );

        if (!hasEvidence("electrical-wires")) {
          add("MC/thumbs-up: You cleared. We good homie.", "engineer/clear");
        } else {
          add(
            "MC/thinking: What about those cut wires engie? Pretty sus ngl.",
            ""
          );
          add(
            "Engineer/worried: Tried to see if cutting the wires could help make comms work again.",
            "adrian/cutting_the_wires"
          );
          add(
            "MC/pointing: You don't have a degree in engineering do you?",
            "engineer/degree"
          );
          add(
            "Engineer/crying: Nope. I have no fucking clue what i'm doing.",
            "adrian/soy_un_balsero"
          );
          add(
            "MC/ligma: *sigh* I'm surrounded by fucking idiots.",
            "engineer/idiots"
          );
        }
      }
    }
  }

  @Override
  public void onDone() {
    setOptions(new StartOptions(a));
  }
}
