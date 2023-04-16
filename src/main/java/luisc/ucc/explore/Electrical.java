package luisc.ucc.explore;

import luisc.lib.Clickable;
import luisc.ucc.App;

public class Electrical extends Exploration {

  public Electrical(App app) {
    super(app);
  }

  @Override
  protected void _update() {}

  @Override
  protected void _setup() {
    bg = loadGif("options/electrical.gif");

    clickables =
      new Clickable[] {
        new Evidence(
          a,
          "wifi",
          254,
          192,
          "MC: The communications panel is malfunctioning, thats a bit sus"
        ),
        new Evidence(
          a,
          "electrical-wires",
          367,
          525,
          "MC: Who did a little trolling here"
        ),
        new Evidence(a, "wires", 818, 764, "MC: Why are the wires cut?"),
        new Evidence(
          a,
          "electrical-grease",
          245,
          568,
          "MC: Grease on the vents, interesting"
        ),
        new Evidence(
          a,
          "electrical-cabinet",
          939,
          373,
          "MC: Why is this open?"
        ),
      };
  }
}
