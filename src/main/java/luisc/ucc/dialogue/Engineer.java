package luisc.ucc.dialogue;

import luisc.ucc.App;
import luisc.ucc.court.StartOptions;

public class Engineer extends Dialogue {

  public Engineer(App app) {
    super(app);
  }

  @Override
  protected void _setup() {
    add("MC/", r.ch.mc);
    add("Engineer/", r.ch.mc);

    add("Engineer: Greasing up the engines");
    add("Engineer: Top engine specifically");

    add("[TEMP: susy amgousaopdfjalsdfjlasdjflasdjflaskdjf]");
  }

  @Override
  public void onDone() {
    setOptions(new StartOptions(a));
  }
}
