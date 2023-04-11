package luisc.lib;

import luisc.ucc.App;
import processing.core.PImage;

public abstract class KeyboardBtn extends Clickable {

  // This should be set in the setup method
  protected PImage img;
  protected int kc;

  public void postSetup() {
    super.postSetup();
    resize();
  }

  protected void _update() {
    p.imageMode(PC.CENTER);
    p.image(img, x, y);
  }

  @Override
  protected void postUpdate() {
    if (p.keyCode == kc) {
      if (!clicked && !clicking) {
        clicked = true;
        clicking = true;
      } else {
        clicked = false;
      }

      if (clicked) {
        onClick();
      }

      p.keyCode = 0;
    }

    super.postUpdate();
  }

  // Resize the dimensions of the button to be equal to the current w and height
  // ! Please make sure that the cur w and h have the same aspect ratio as the image's w and h
  // else img will be funky
  protected void resize() {
    img.resize(w, h);
  }

  // Updates the dimensions of the to be equal to the current image
  // Should be called in the update method
  protected void updateDim() {
    w = img.width;
    h = img.height;
  }

  public KeyboardBtn(App app) {
    super(app);
  }
}
