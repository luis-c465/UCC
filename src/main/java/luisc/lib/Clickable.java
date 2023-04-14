package luisc.lib;

import luisc.ucc.App;

/**
 * Class for clickable objects
 */
public abstract class Clickable extends Obj {

  public String identifier = null;

  // ! represents the center of the object
  public int x = 500;
  public int y = 500;

  // * Variables which represent the borders of the clickable area
  // * Are computed in the setup method
  public int left;
  public int right;
  public int top;
  public int bottom;

  // Should be set to true if the object can move around the canvas
  // If true the corners of the object will be recalculated on very re render
  // ! So only set to true if necessary!
  protected boolean canMove = false;

  /**
   * If the class should check if the object was clicked
   * only set to false when the object leaves the screen and should not be checked!
   */
  protected boolean shouldCheck = true;

  protected int w = 150;
  protected int h = 75;

  // If the user has clicked on the button
  // Will only be true on the first update when the user first clicks on the button
  public boolean clicked = false;

  // If the user is currently clicking on the button
  public boolean clicking = false;
  public boolean hovered = false;

  protected void postSetup() {
    updateCorners();
  }

  protected void preUpdate() {
    push();

    // Check if the obj was clicked
    if (shouldCheck) {
      if (canMove) {
        updateCorners();
      }

      checkHover();
      checkClick();

      if (hovered) {
        onHover();
      }
    }
  }

  /**
   * Called when the object is hovered
   * Changes the cursor to a hand
   */
  protected void onHover() {
    if (!a.hoveringClickable) {
      a.hoveringClickable = true;
    }
  }

  private void checkClick() {
    if (p.mousePressed && clicking) {
      clicked = false;
      return;
    } else {
      clicking = false;
    }

    if (!shouldClick() || !p.mousePressed) {
      clicked = false;
      return;
    }

    clicked = hovered;
    clicking = hovered;

    if (clicked) {
      onClick();
    }
  }

  /**
   * Called when the object is clicked
   *
   * Does nothing
   */
  protected void onClick() {}

  protected void checkHover() {
    hovered =
      p.mouseX >= left &&
      p.mouseX <= right &&
      p.mouseY >= bottom &&
      p.mouseY <= top;
  }

  protected void updateCorners() {
    left = x - w / 2;
    bottom = y - h / 2;

    right = x + w / 2;
    top = y + h / 2;
  }

  protected boolean shouldClick() {
    return !a.transitioning;
  }

  /**
   * Updates the x and y variables by converting them from corner values to
   * their corresponding center values
   */
  protected void cornerToCenter() {
    x += w / 2;
    y -= h / 2;
  }

  public Clickable(App app) {
    super(app);
  }

  public Clickable(App app, int x, int y, int w, int h) {
    super(app);
    this.x = x;
    this.y = y;
    this.w = w;
    this.h = h;
  }
}
