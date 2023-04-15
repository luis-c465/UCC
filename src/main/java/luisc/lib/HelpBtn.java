package luisc.lib;

import luisc.ucc.App;

public class HelpBtn extends Btn {

  @Override
  protected void _setup() {
    x = App.w - 75;
    y = 50;

    txt = "Help";
    icon = p.loadShape("help.svg");
    color = 0xff94a3b8;
  }

  @Override
  protected void onClick() {
    // a.helpModal.beginShowing = true;
  }

  public HelpBtn(App a) {
    super(a);
    setup();
  }
}
