package luisc.ucc.explore;

import luisc.lib.Clickable;
import luisc.ucc.App;

public class Electrical extends Exploration {

  public Electrical(App app) {
    super(app);
  }

  @Override
  protected void _update() {
    if (isClicked("Go back outside")) {
      setExploration(new ElectricalHallway(a));
    }
  }

  @Override
  protected void _setup() {
    bg = p.loadImage("options/electrical-1.png");

    clickables =
      new Clickable[] {
        new ExplorationBtn(a, "Go back outside", 800, 800),
        new Evidence(
          a,
          "MC: The communications panel is malfunctioning, thats a bit sus",
          "Wifi",
          260,
          352
        ),
        new Evidence(
          a,
          "MC: Who did a little trolling here",
          "wires",
          374,
          517
        ),
        new Evidence(a, "MC: Why are the wires cut?", "wires", 813, 628),
        new Evidence(
          a,
          "MC: Grease on the vents, interesting",
          "vent",
          244,
          539
        ),
        new Evidence(a, "MC: Why is this open", "electricity", 950, 450),
      };
  }
}
