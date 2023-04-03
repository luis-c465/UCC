package luisc.lib;

import controlP5.ScrollableList;
import luisc.ucc.App;

/**
 * Base class for all the headers
 */
public abstract class BaseHeader extends CP5ControllerHolder {

  public ScrollableList difficulty;

  public static final int safe = 10;
  public static final int margin_top = 10;
  public int h = 100;
  public static final int cy = 50;

  public HelpBtn helpBtn;

  @Override
  protected void postSetup() {
    super.postSetup();

    helpBtn = new HelpBtn(a);
  }

  @Override
  protected void postUpdate() {
    super.postUpdate();

    helpBtn.update();
  }

  public BaseHeader(App a, int h) {
    super(a);
    this.h = h;
  }

  public BaseHeader(App a) {
    super(a);
  }
}
