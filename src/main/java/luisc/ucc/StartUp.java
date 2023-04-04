package luisc.ucc;

import luisc.lib.Btn;
import luisc.lib.Transitionable;

/**
 * Class which displays the startup screen
 * Shows 2 inputs for both players names
 */
public class StartUp extends Transitionable {

  private StartGameBtn startGameBtn;

  @Override
  protected void _setup() {
    startGameBtn = new StartGameBtn(a);
    startGameBtn.setup();
  }

  @Override
  protected void _update() {}

  @Override
  protected void onTransOutBegin() {
    onDone();
  }

  private class StartGameBtn extends Btn {

    @Override
    public void _setup() {
      x = App.cw;
      y = 800;
      w = 200;

      txt = "Start Game";
      color = 0xff0ea5e9;
      txt_size = 20;
      txt_c = 255;
      txt_space = 30;

      icon = p.loadShape("play.svg");
      icon_space = 60;
      icon_y_mod = 5;
    }

    public StartGameBtn(App app) {
      super(app);
    }
  }

  public StartUp(App app) {
    super(app);
  }
}
