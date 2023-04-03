package luisc.lib;

import luisc.resources.Resources;
import luisc.ucc.App;
import processing.core.PApplet;

/**
 * Abstract class for objects that will be drawn to the screen
 */
public abstract class Obj {

  protected Resources r;
  protected App a;
  protected PApplet p;
  public boolean shouldUpdate = true;

  public Obj(App app) {
    this.r = app.r;
    this.a = app;
    this.p = app;
  }

  public final void setup() {
    // Do sone setup
    preSetup();

    _setup();

    postSetup();
  }

  /**
   * Should be used by super classes to setup variables
   */
  protected void preSetup() {}

  /**
   * Should be used by a super class to override variables after setup
   */
  protected void postSetup() {}

  /**
   * Should be overridden by a super class to setup stuff if needed
   */
  protected void _setup() {}

  /**
   * Draws and updates the object
   * Should not be overridden by a super class
   */
  public final void update() {
    preUpdate();

    if (shouldUpdate) {
      _update();
    }

    postUpdate();
  }

  protected abstract void _update();

  protected void preUpdate() {
    push();
  }

  protected void postUpdate() {
    pop();
  }

  protected final void push() {
    a.pushMatrix();
    a.pushStyle();
  }

  protected final void pop() {
    a.popMatrix();
    a.popStyle();
  }
}
