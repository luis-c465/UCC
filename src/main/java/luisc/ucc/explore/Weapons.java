package luisc.ucc.explore;

import luisc.lib.Clickable;
import luisc.ucc.App;

public class Weapons extends Exploration {

  public Weapons(App app) {
    super(app);
  }

  @Override
  protected void _setup() {
    bg = loadGif("options/weapons.gif");

    clickables =
      new Clickable[] {
        new Evidence(
          a,
          "guns-blood",
          356,
          313,
          100,
          100,
          "MC: The guns are covered in blood, and so is this vent!!!",
          "MC: I wonder what happened here..."
        ),
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
