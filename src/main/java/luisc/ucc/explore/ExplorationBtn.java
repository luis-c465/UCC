package luisc.ucc.explore;

import luisc.lib.Btn;
import luisc.resources.Colors;
import luisc.ucc.App;

public class ExplorationBtn extends Btn {

  public ExplorationBtn(App app, String txt, int x, int y) {
    super(app);
    this.txt = txt;
    this.identifier = txt;

    this.x = x;
    this.y = y;

    setup();
  }

  @Override
  protected void _setup() {
    w = 200;

    color = Colors.btnColor;
    colorHover = Colors.btnColorHover;
    txt_size = 15;
    txt_c = 255;
    txt_space = 30;

    hasIcon = false;
  }
}
