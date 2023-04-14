package luisc.ucc.dialogue;

import luisc.ucc.App;
import luisc.ucc.court.StartOptions;

public class Navigator extends Dialogue {

  public Navigator(App app) {
    super(app);
  }

  @Override
  protected void _setup() {
    add("MC/", r.ch.mc);
    add("Navigator/", r.ch.mc);

    add(
      "Navigator: I was in the cockpit, trying to put us on a quicker route."
    );
    add("MC: A bit suspicious that the body ended up the navigation, Green");
    add("Navigator: I swear on my life it wasn't me!");
    add("Navigator: I had left to get some coffee from the cafeteria!");

    add("[TEMP: susy amgousaopdfjalsdfjlasdjflasdjflaskdjf]");
  }

  @Override
  public void onDone() {
    setOptions(new StartOptions(a));
  }
}
