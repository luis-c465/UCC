package luisc.ucc.court;

import luisc.ucc.App;
import luisc.ucc.dialogue.Communicator;
import luisc.ucc.dialogue.Gunner;
import luisc.ucc.dialogue.Medic;
import luisc.ucc.dialogue.Navigator;
import luisc.ucc.dialogue.Options;

public class StartOptions extends Options {

  public StartOptions(App app) {
    super(
      app,
      new String[] {
        "Ask medic tf2 man",
        "Ask gunner where he was",
        "Ask the navigator",
        "Mr coms?",
        "Engineer gaming",
        "Nvm, let me find some more evidence first",
      }
    );
  }

  @Override
  protected void _update() {
    if (isClicked("Ask medic tf2 man")) {
      setDialogue(new Medic(a));
    } else if (isClicked("Ask gunner where he was")) {
      setDialogue(new Gunner(a));
    } else if (isClicked("Ask the navigator")) {
      setDialogue(new Navigator(a));
    } else if (isClicked("Mr coms?")) {
      setDialogue(new Communicator(a));
    } else if (isClicked("Engineer gaming")) {
      setOptions(new EngineerQuestions(a));
    } else if (isClicked("Nvm, let me find some more evidence first")) {
      a.mainScene.inCourt = false;
    }
  }
}
