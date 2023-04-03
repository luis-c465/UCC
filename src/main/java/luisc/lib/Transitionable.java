package luisc.lib;

import luisc.ucc.App;

/**
 * Class for objects which transition between frames in the app
 */
public abstract class Transitionable extends Obj {

  // Set to true to begin transitioning!
  public boolean trans = false;
  // Done transitioning
  public boolean middle = false;
  public boolean done = false;

  public boolean paused = false;

  protected void postSetup() {
    super.postSetup();

    a.transIn.reset();
    a.transOut.reset();
  }

  protected void preUpdate() {
    super.preUpdate();

    if (middle && trans) {
      transition();
    }
  }

  protected void postUpdate() {
    super.postUpdate();

    if (!middle && trans) {
      transition();
    }
  }

  private void transition() {
    if (paused) return;

    if (!a.transIn.done) {
      a.transIn.update();

      if (a.transIn.beforeDone) {
        middle = true;
        shouldUpdate = false;
        onTransOutBegin();
      }
    } else {
      if (!a.transOut.done) {
        a.transOut.update();
      }
    }

    if (a.transIn.done && a.transOut.done) {
      // When the trans is done
      onDone();
    }
  }

  protected void clean() {
    a.transIn.reset();
    a.transOut.reset();
  }

  protected void onDone() {
    trans = false;
    done = true;
    middle = false;

    clean();
  }

  // Method which inheriting classes should implement
  // for cleanup
  protected void onTransOutBegin() {}

  public Transitionable(App app) {
    super(app);
  }
}
