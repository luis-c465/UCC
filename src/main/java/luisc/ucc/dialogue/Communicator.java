package luisc.ucc.dialogue;

import luisc.ucc.App;
import luisc.ucc.court.StartOptions;

public class Communicator extends Dialogue {

  public Communicator(App app) {
    super(app);
  }

  @Override
  protected void _setup() {
    add("MC/", r.ch.mc);
    add("Communicator/", r.ch.mc);

    add(
      "Communicator: I was honestly just sleeping with the radio in my ears."
    );
    add("Communicator: Was just trying to get some sleep in the comms room.");
    add("Communicator: Whats wrong with that");

    add("[TEMP: susy amgousaopdfjalsdfjlasdjflasdjflaskdjf]");
  }

  @Override
  public void onDone() {
    setOptions(new StartOptions(a));
  }
}
