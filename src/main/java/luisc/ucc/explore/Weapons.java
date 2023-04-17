package luisc.ucc.explore;

import luisc.lib.Clickable;
import luisc.ucc.App;

public class Weapons extends Exploration {

  public Weapons(App app) {
    super(app);
  }

  @Override
  protected void _update() {
    if (isClicked("vent")) {
      r.sfx.vent.play(0);
    }
  }

  @Override
  protected void _setup() {
    bg = p.loadImage("options/weapons.gif");

    clickables =
      new Clickable[] {
        new Interactable(a, "vent", 356, 313, 100, 100),
        new Evidence(
          a,
          "ammo salvo",
          485,
          432,
          200,
          200,
          "MC: What in da hell, the ammo salvos here are full"
        ),
      };
  }
}
