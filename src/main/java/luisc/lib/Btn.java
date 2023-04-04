package luisc.lib;

import luisc.ucc.App;
import processing.core.PShape;

public abstract class Btn extends Clickable {

  protected final int btn_safe = 10;

  protected String txt = "Click me!";
  protected int txt_size = 15;
  protected int color = 0xfffac83c;
  protected int colorHover = 0xfffac83c;
  protected int txt_c = 0xff000000;
  protected int radius = 25;

  protected boolean hasIcon = true;
  protected PShape icon;
  protected int icon_space = 70;
  protected int icon_size = 50;

  // ! Calculated in setup
  protected int icon_x;
  protected int icon_y;
  protected int txt_x;
  protected int txt_y;

  protected int icon_y_mod = 0;

  protected int txt_space = 10;

  public Btn(App app) {
    super(app);
  }

  protected void postSetup() {
    super.postSetup();
    setupIcon();
    setupText();
  }

  /**
   * Should be overridden by inheriting classes if needed
   * Icon should be setup here
   */
  protected abstract void _setup();

  protected void _update() {
    p.rectMode(PC.CENTER);
    p.shapeMode(PC.CENTER);

    p.fill(hovered ? colorHover : color);

    p.noStroke();
    p.rect(x, y, w, h, radius, radius, radius, radius);

    // Draw text
    p.textAlign(PC.LEFT, PC.CENTER);
    p.fill(txt_c);
    p.textSize(txt_size);
    p.text(txt, txt_x, txt_y);

    if (hasIcon) {
      p.shapeMode(PC.CENTER);
      p.shape(icon, icon_x, icon_y, icon_size, icon_size);
    }
  }

  protected void setupIcon() {
    icon_x = x - icon_size;
    icon_y = y;
  }

  protected void setupText() {
    if (hasIcon) {
      txt_x = x - w / 6;
    } else {
      txt_x = left + btn_safe;
    }
    txt_y = y - 3;
  }
}
