package luisc.ucc.scene;

import luisc.lib.Btn;
import luisc.lib.PC;
import luisc.lib.Transitionable;
import luisc.resources.Colors;
import luisc.ucc.App;
import processing.core.PImage;

/**
 * Class which displays the startup screen
 */
public class StartUp extends Transitionable {

  private PImage bg;

  private PlayBtn startGameBtn;
  private BehindTheScenesBtn BTSBtn;
  private AchievementsBtn achievementsBtn;
  private DownloadableContentBtn DLCBtn;
  private QuitBtn quitBtn;

  @Override
  protected void _setup() {
    bg = p.loadImage("title.png");

    startGameBtn = new PlayBtn(a);
    startGameBtn.setup();

    BTSBtn = new BehindTheScenesBtn(a);
    BTSBtn.setup();

    DLCBtn = new DownloadableContentBtn(a);
    DLCBtn.setup();

    quitBtn = new QuitBtn(a);
    quitBtn.setup();

    achievementsBtn = new AchievementsBtn(a);
    achievementsBtn.setup();
  }

  @Override
  protected void _update() {
    p.imageMode(PC.CORNER);
    p.image(bg, 0, 0, App.w, App.h);

    startGameBtn.update();
    BTSBtn.update();
    DLCBtn.update();
    quitBtn.update();
    achievementsBtn.update();
  }

  @Override
  protected void onTransOutBegin() {
    onDone();
  }

  private class PlayBtn extends Btn {

    @Override
    public void _setup() {
      x = App.cw;
      y = 550;
      w = 200;

      if (App.loadSaves) {
        txt = a.saver.saves.size() == 0 ? "Play!" : "Continue!";
      } else {
        txt = "Play!";
      }

      color = Colors.btnColor;
      colorHover = Colors.btnColorHover;
      txt_size = 20;
      txt_c = 255;
      txt_space = 30;

      hasIcon = false;
    }

    @Override
    protected void onClick() {
      a.scene = Scenes.Main;
    }

    public PlayBtn(App app) {
      super(app);
    }
  }

  private class BehindTheScenesBtn extends Btn {

    @Override
    public void _setup() {
      x = App.cw;
      y = 700;
      w = 200;

      txt = "Behind the scenes";
      color = Colors.btnColor;
      colorHover = Colors.btnColorHover;
      txt_size = 20;
      txt_c = 255;
      txt_space = 30;

      hasIcon = false;
    }

    @Override
    protected void onClick() {
      a.scene = Scenes.Extras;
    }

    public BehindTheScenesBtn(App app) {
      super(app);
    }
  }

  /**
   * DLC button
   */
  private class DownloadableContentBtn extends Btn {

    @Override
    public void _setup() {
      x = App.cw;
      y = 800;
      w = 200;

      txt = "DLC";
      color = Colors.btnColor;
      colorHover = Colors.btnColorHover;
      txt_size = 20;
      txt_c = 255;
      txt_space = 30;

      hasIcon = false;
    }

    @Override
    protected void onClick() {
      a.scene = Scenes.DLC;
    }

    public DownloadableContentBtn(App app) {
      super(app);
    }
  }

  private class QuitBtn extends Btn {

    @Override
    public void _setup() {
      x = App.cw;
      y = 900;
      w = 200;

      txt = "Quit";
      color = Colors.error;
      colorHover = 0xffb91c1c;
      txt_size = 20;
      txt_c = 255;
      txt_space = 30;

      hasIcon = false;
    }

    @Override
    protected void onClick() {
      a.scene = Scenes.Quit;
    }

    public QuitBtn(App app) {
      super(app);
    }
  }

  public StartUp(App app) {
    super(app);
  }

  private class AchievementsBtn extends Btn {

    public AchievementsBtn(App app) {
      super(app);
    }

    @Override
    public void _setup() {
      x = App.cw + 300;
      y = 700;
      w = 200;

      txt = "Achievements";
      color = Colors.btnColor;
      colorHover = Colors.btnColorHover;
      txt_size = 20;
      txt_c = 255;
      txt_space = 30;

      hasIcon = false;
    }

    @Override
    protected void onClick() {
      a.scene = Scenes.Achievements;
    }
  }
}
