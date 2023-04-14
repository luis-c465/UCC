package luisc.lib;

import luisc.ucc.App;

public abstract class ClickableHolder extends Obj {

  public Clickable[] clickables;

  public ClickableHolder(App app) {
    super(app);
  }

  @Override
  protected void postUpdate() {
    for (Clickable btn : clickables) {
      btn.update();
    }

    super.postUpdate();
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
}
