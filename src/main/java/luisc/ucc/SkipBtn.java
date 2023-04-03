package luisc.ucc;

import luisc.lib.Btn;

/**
 * When clicked goes to the next round
 * Will show either skip turn of go to next round based on how many turns are remaining
 * Above the button text will show how many more cards can be placed
 */
public class SkipBtn extends Btn {

  public int txt_cards_x;
  public int txt_cards_y;

  public static final String end = "End Turn";

  protected void _setup() {
    x = App.w - w - 10;
    y = App.h - h / 2 - 20;

    txt = end;
    icon = p.loadShape("continue.svg");
    icon_space = 70;
    txt_space = 20;

    cornerToCenter();

    txt_cards_x = x;
    txt_cards_y = y - h;
  }

  @Override
  protected void onClick() {
    if (!a.player.tookShot) {
      return;
    }

    a.turnOver = true;
  }

  public SkipBtn(App app) {
    super(app);
  }
}
