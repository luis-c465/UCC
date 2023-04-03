package luisc.lib;

import controlP5.Controller;
import java.util.ArrayList;
import luisc.ucc.App;

/**
 * A class that holds a list of controllers and shows/hides them
 * depending on the state of the application
 */
public abstract class CP5ControllerHolder extends Obj {

  public ArrayList<Controller<?>> controllers = new ArrayList<>();

  public void hideAll() {
    for (Controller<?> c : controllers) {
      c.hide();
    }
  }

  public void showAll() {
    for (Controller<?> c : controllers) {
      c.show();
    }
  }

  /**
   * Creates the controllers and adds them to the list
   *
   * Override this method to add controllers to the list `controllers`
   */
  protected void createControllers() {}

  @Override
  protected void preSetup() {
    super.preSetup();

    createControllers();
    hideAll();
  }

  /**
   * Returns true if the controllers should be shown, false otherwise
   */
  protected boolean shouldShowControllers() {
    return !a.doingIntro && !a.doingStartUp && !a.transitioning;
  }

  @Override
  protected void preUpdate() {
    super.preUpdate();

    if (shouldShowControllers()) {
      showAll();
    } else {
      hideAll();
    }
  }

  public CP5ControllerHolder(App a) {
    super(a);
  }
}
