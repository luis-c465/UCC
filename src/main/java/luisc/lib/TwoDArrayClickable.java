package luisc.lib;

import luisc.ucc.App;

/**
 * Abstract class for clickable objects contained in a 2D array
 */
public abstract class TwoDArrayClickable extends Clickable {

  public int row = -1;
  public int col = -1;

  public TwoDArrayClickable(App a, int r, int c) {
    super(a);
    this.row = r;
    this.col = c;
  }

  /**
   * Method which re calculates the x and y position for the objects
   */
  protected void calc() {}
}
