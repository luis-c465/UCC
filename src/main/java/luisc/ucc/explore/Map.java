package luisc.ucc.explore;

import luisc.lib.Clickable;
import luisc.lib.FullScreenModal;
import luisc.lib.PC;
import luisc.ucc.App;

public class Map extends FullScreenModal {

  public Clickable[] clickables;

  @Override
  protected void _setup() {
    img = r.i.map;

    clickables =
      new Clickable[] {
        new MapBtn(a, "Cafeteria", 569, 353, 100, 100),
        new MapBtn(a, "Medical", 386, 443, 60, 60),
        new MapBtn(a, "Security", 304, 463, 60, 60),
        new MapBtn(a, "Electrical", 400, 578, 60, 60),
        new MapBtn(a, "Coms", 664, 694, 60, 60),
        new MapBtn(a, "Weapons", 782, 335, 60, 60),
      };
  }

  @Override
  protected void preUpdate() {
    if (a.keyPressed && a.key == 'm') {
      beginShowing = true;
    }

    super.preUpdate();
  }

  @Override
  protected void _update() {
    super._update();
    if (isClicked("Cafeteria")) {
      a.mainScene.exploration.setExploration(new CafeteriaExploration(a));
      show = false;
      beginShowing = false;
    } else if (isClicked("Medical")) {
      a.mainScene.exploration.setExploration(new Medical(a));
      show = false;
      beginShowing = false;
    } else if (isClicked("Security")) {
      a.mainScene.exploration.setExploration(new Security(a));
      show = false;
      beginShowing = false;
    } else if (isClicked("Electrical")) {
      a.mainScene.exploration.setExploration(new Electrical(a));
      show = false;
      beginShowing = false;
    } else if (isClicked("Coms")) {
      a.mainScene.exploration.setExploration(new Coms(a));
      show = false;
      beginShowing = false;
    } else if (isClicked("Weapons")) {
      a.mainScene.exploration.setExploration(new Weapons(a));
      show = false;
      beginShowing = false;
    }

    if (!show) return;
    p.textSize(32);
    p.textAlign(PC.CENTER);
    p.fill(255);
    p.text("Map screen", App.cw, 25);
  }

  @Override
  protected void postUpdate() {
    for (Clickable btn : clickables) {
      btn.update();
    }

    super.postUpdate();
  }

  @Override
  public void mouseClicked() {
    // do nothing
  }

  /**
   * Checks if a clickable with the given identifier has been clicked
   */
  protected boolean isClicked(String identifier) {
    for (Clickable click : clickables) {
      if (click.identifier.equals(identifier)) {
        return click.clicked;
      }
    }

    // Clickable not found
    return false;
  }

  public Map(App app) {
    super(app);
  }

  public class MapBtn extends Clickable {

    public MapBtn(App app) {
      super(app);
    }

    public MapBtn(App app, String identifier, int x, int y, int w, int h) {
      super(app, x, y, w, h);
      this.identifier = identifier;

      setup();
    }

    @Override
    protected void postUpdate() {
      shouldCheck = show;

      super.postUpdate();
    }

    @Override
    protected boolean shouldClick() {
      return true;
    }

    @Override
    protected void _update() {}
  }
}
