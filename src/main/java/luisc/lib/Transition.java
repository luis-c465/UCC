package luisc.lib;

import luisc.ucc.App;

/**
 * Abstract class for transitions that will take up the entire screen
 * i.e. fade to black, fade out from black
 */
public abstract class Transition extends Obj {

  public int starting_opacity = 0;
  protected int opacity = 0;
  public int end_opacity = 255;
  // Defines if the tick method increases or decreases the opacity of the transition
  public boolean up;
  public int step = 4;

  // !Bellow are variables that should not be managed in a subclass
  public boolean done = false;

  // Will be true if on the last frame of the transition before stopping
  public boolean beforeDone = false;

  protected void preTick() {
    // Do nothing
  }

  protected void postTick() {
    if (done) {
      beforeDone = false;
      return;
    }

    // Updates before done
    if (up && opacity >= end_opacity) {
      beforeDone = true;
    } else if (!up && opacity <= end_opacity) {
      beforeDone = true;
    } else {
      beforeDone = false;
    }
  }

  protected void tick() {
    preTick();
    _tick();
    postTick();
  }

  /**
   * Updates the opacity of the transition
   */
  protected void _tick() {
    if (up) {
      if (opacity < end_opacity) {
        opacity += step;
      } else {
        done = true;
      }
    } else {
      if (opacity > end_opacity) {
        opacity -= step;
      } else {
        done = true;
      }
    }
  }

  @Override
  public void _update() {
    p.fill(0, opacity);
    p.rect(0, 0, BaseApp.w, BaseApp.h);

    tick();
  }

  public void reset() {
    opacity = starting_opacity;
    done = false;
    beforeDone = false;
  }

  public Transition(App app) {
    super(app);
  }
}
