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
        new MapBtn(a, "Reactor", 131, 485, 60, 60),
        new MapBtn(a, "Left Engine", 228, 348, 60, 60),
        new MapBtn(a, "Right Engine", 218, 605, 60, 60),
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
      set(new CafeteriaExploration(a));
    } else if (isClicked("Medical")) {
      set(new Medical(a));
    } else if (isClicked("Security")) {
      set(new Security(a));
    } else if (isClicked("Electrical")) {
      set(new Electrical(a));
    } else if (isClicked("Coms")) {
      set(new Coms(a));
    } else if (isClicked("Weapons")) {
      set(new Weapons(a));
    } else if (isClicked("Reactor")) {
      set(new Reactor(a));
    } else if (isClicked("Left Engine")) {
      set(new LeftEngine(a));
    } else if (isClicked("Right Engine")) {
      set(new RightEngine(a));
    }

    if (!show) return;
    p.textSize(32);
    p.textAlign(PC.CENTER);
    p.fill(255);
    p.text("Map screen", App.cw, 25);
  }

  protected void set(Exploration exploration) {
    a.mainScene.exploration.setExploration(exploration);
    show = false;
    beginShowing = false;
    a.modalShowing = false;
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
    protected void _update() {
      // p.fill(255);
      // p.rectMode(PC.CORNERS);
      // p.rect(left, top, right, bottom);
    }
  }
}
