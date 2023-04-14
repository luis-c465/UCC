package luisc.ucc.dialogue;

import luisc.lib.Btn;
import luisc.lib.Clickable;
import luisc.lib.ClickableHolder;
import luisc.lib.PC;
import luisc.resources.Colors;
import luisc.ucc.App;

public abstract class Options extends ClickableHolder {

  public Options(App app, String[] opts) {
    super(app);
    clickables = new Clickable[opts.length];

    for (int i = 0; i < opts.length; i++) {
      clickables[i] = new OptionBtn(app, opts[i], i);
    }
  }

  @Override
  protected void preUpdate() {
    p.imageMode(PC.CORNER);
    p.image(
      r.i.textBox,
      Dialogue.txtBoxX,
      Dialogue.txtBoxY,
      Dialogue.txtBoxW,
      Dialogue.txtBoxH
    );

    super.preUpdate();
  }

  public class OptionBtn extends Btn {

    private static final int gap = 10;

    public OptionBtn(App app, String txt, int i) {
      super(app);
      this.txt = txt;
      this.identifier = txt;

      this.h = 40;
      this.w = Dialogue.txtBoxW - (Dialogue.txtBoxPadding * 2);

      this.x = App.cw;
      this.y = Dialogue.txtY + Dialogue.txtBoxPadding * 4 + (i * (h + gap));

      setup();
    }

    @Override
    protected void _setup() {
      color = Colors.btnColor;
      colorHover = Colors.btnColorHover;
      txt_size = 15;
      txt_c = 255;
      txt_space = 30;

      hasIcon = false;
    }
  }
}
