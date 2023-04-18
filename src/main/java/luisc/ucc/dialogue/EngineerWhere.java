package luisc.ucc.dialogue;

import luisc.ucc.App;
import luisc.ucc.court.EngineerQuestions;

public class EngineerWhere extends Dialogue {

  public EngineerWhere(App app) {
    super(app);
  }

  @Override
  protected void _setup() {
    add("MC: Where were you when the ship was attacked?", "engineer/where");
    add(
      "Engineer: Greasing up the engines",
      "adrian/oye_papito_greasing_up_the_engines"
    );

    add(
      "MC/thinking: Well, any other place you could have been during the murder?",
      "engineer/place"
    );
    add(
      "Engineer/worried: Probably electrical to work on the comms panel which is somehow always not functioning."
    );
  }

  @Override
  public void onDone() {
    setOptions(new EngineerQuestions(a));
  }
}
