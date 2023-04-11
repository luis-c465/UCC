package luisc.ucc;

public class CafeteriaExploration extends ExplorationOptions {

  public CafeteriaExploration(App app) {
    super(app);
  }

  @Override
  protected void _update() {
    if (isBtnClicked("Go into left hallway")) {
      App.println("Go into left hallway");
    }
  }

  @Override
  protected void _setup() {
    bg = p.loadImage("options/cafeteria.png");

    btns =
      new ExplorationBtn[] {
        new ExplorationBtn(a, "Go into left hallway", 200, 550),
        new ExplorationBtn(a, "Go into right hallway", 800, 615),
      };
  }
}
