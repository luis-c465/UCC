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

    if (hasEvidence("cams")) {
      add("MC: You were on cams Green. I will admit.");
      add(
        "MC: But is there any way you can tell me why the body would end up in navigation?"
      );
      add("Navigator: Idk what to tell you Joe. I didn't do it.");
      add(
        "Navigator: I would think the real imposter put it there to frame me!"
      );
    }
  }

  @Override
  public void onDone() {
    setOptions(new StartOptions(a));
  }
}
