package luisc.ucc.explore;

import luisc.lib.Clickable;
import luisc.ucc.App;

public class Shields extends Exploration {

  public Shields(App app) {
    super(app);
  }

  @Override
  protected void _update() {}

  @Override
  protected void _setup() {
    bg = loadGif("options/shields.gif");

    // shields-vent
    clickables =
      new Clickable[] {
        new Evidence(
          a,
          "shields-vent",
          735,
          964,
          141,
          135,
          "MC: What is this?",
          "MC: An open vent?, interesting..."
        ),
      };
  }
}
