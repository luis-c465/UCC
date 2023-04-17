package luisc.ucc.explore;

import luisc.lib.Clickable;
import luisc.ucc.App;

public class Coms extends Exploration {

  public Coms(App app) {
    super(app);
  }

  @Override
  protected void _update() {
    if (isClicked("venty")) {
      r.sfx.vent.play(0);
    }
  }

  @Override
  protected void _setup() {
    bg = loadGif("options/coms.gif");

    clickables =
      new Clickable[] {
        new Evidence(
          a,
          "coms",
          500,
          275,
          512,
          75,
          "MC: All the panels are broken??",
          "MC: Where are we even going??????"
        ),
        new Interactable(a, "venty", 500, 634, 144, 194),
      };
  }
}
