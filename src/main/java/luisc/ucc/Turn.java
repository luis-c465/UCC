package luisc.ucc;

import luisc.lib.KeyboardBtn;
import luisc.lib.Obj;
import luisc.lib.PC;

public class Turn extends Obj {

  public static final int x = App.cw;
  public static final int y = App.ch;

  public EnterBtn enterBtn;

  protected void _setup() {
    enterBtn = new EnterBtn(a);
    enterBtn.setup();
  }

  protected void _update() {
    if (!a.gameOver) {
      p.background(0);
      p.textAlign(PC.CENTER);
      p.textSize(30);
      p.text("Turn over, pass the computer to the next player", x, y - 100);
      p.textSize(60);
      p.text("Press enter to continue", x, y + 100);

      enterBtn.update();
      if (enterBtn.clicked) {
        if (a.placeOver) {
          a.placeOver = false;
        } else {
          a.turnOver = false;

          a.player.tookShot = false;
        }

        a.player = a.player.otherPlayer;

        enterBtn.clicked = false;
      }
    } else if (a.gameOver) {
      p.imageMode(PC.CORNER);
      p.image(r.i.winner, 0, 0, App.w, App.h);

      p.textAlign(PC.CENTER);
      p.textSize(30);
      p.text("Player " + a.winner + " wins! ", x, y - 100);
      p.textSize(60);
      p.text("Press enter to restart", x, y + 100);

      enterBtn.update();
      if (enterBtn.clicked) {
        enterBtn.clicked = false;
        a.dropdown(a.curDropdown);
      }
    }
  }

  private class EnterBtn extends KeyboardBtn {

    protected void _setup() {
      x = App.cw;
      y = 800;

      w = 200;
      h = 100;
      img = r.i.enter;

      kc = PC.ENTER;
    }

    public EnterBtn(App app) {
      super(app);
    }
  }

  public Turn(App app) {
    super(app);
  }
}
