package luisc.ucc.court;

import luisc.ucc.App;
import luisc.ucc.dialogue.EngiMess;
import luisc.ucc.dialogue.EngineerWhere;
import luisc.ucc.dialogue.Options;

public class EngineerQuestions extends Options {

  public EngineerQuestions(App app) {
    super(
      app,
      new String[] {
        "Where were you when the ship was attacked?",
        "What happened in electrical. Thing was a mess!",
        "You know what nvm",
      }
    );
  }

  @Override
  protected void _update() {
    if (isClicked("Where were you when the ship was attacked?")) {
      setDialogue(new EngineerWhere(a));
    } else if (isClicked("What happened in electrical. Thing was a mess!")) {
      setDialogue(new EngiMess(a));
    } else if (isClicked("You know what nvm")) {
      setOptions(new StartOptions(a));
    }
  }
}
