package luisc.lib;

import luisc.ucc.App;
import processing.core.PImage;

public abstract class FullScreenModal extends Obj {

  public int rect_h = 70;
  public int rect_c = 0xff94a3b8;
  public int rect_w = 400;
  public int rect_r = 25;
  public int msg_size = 20;
  public String msg = "Press ENTER or click anywhere to exit";
  public int msg_c = 0xff7c3aed;

  public PImage img = null;
  public boolean show = false;
  public boolean beginShowing = false;

  /**
   * Set the image variable here
   */
  @Override
  protected void _setup() {}

  @Override
  protected void _update() {
    if (!show && !this.beginShowing) {
      a.modalShowing = false;
      return;
    }

    a.modalShowing = true;

    checkEsc();
    display();

    if (beginShowing) {
      beginShowing = false;
      show = true;
    }
  }

  private void display() {
    // Show the help img
    p.imageMode(PC.CORNERS);
    p.image(img, 0, 0, App.w, App.h);

    // Then overlay clicking anywhere to exit or press esc
    p.fill(rect_c);
    p.rectMode(PC.CORNER);
    p.rect(App.w - rect_w, App.h - rect_h, rect_w, rect_h, 5, 0, 0, 0);

    p.fill(msg_c);
    p.textSize(20);
    p.textAlign(PC.LEFT, PC.TOP);
    // p.text(msg, App.w - rect_w, App.h - rect_h, App.w - 5, App.h - 5);
    p.text(msg, App.w - rect_w + 5, App.h - rect_h + 5, rect_w - 5, rect_h);
  }

  private void checkEsc() {
    if (beginShowing) {
      return;
    }

    if (p.keyPressed && (p.key == PC.RETURN || p.key == PC.ENTER)) {
      show = false;
    }
  }

  public void mouseClicked() {
    if (!beginShowing) {
      show = false;
    }
  }

  public FullScreenModal(App a) {
    super(a);
  }
}
