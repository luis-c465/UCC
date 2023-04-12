package luisc.ucc;

import ddf.minim.AudioPlayer;
import luisc.lib.BaseApp;
import luisc.lib.HelpModal;
import processing.event.MouseEvent;

/**
 * Main class for the application
 */
public final class App extends BaseApp {

  public static final boolean loadSaves = false;

  public Scenes scene = Scenes.StartUp;

  public int test = Integer.MIN_VALUE;
  public MainScene mainScene;

  public Saver saver;

  public boolean gameOver = false;

  // Game classes
  public StartUp startUp;
  public HelpModal helpModal;

  public int turnNum = 1;

  public AudioPlayer sound;

  @Override
  public void draw() {
    defaultSettings();

    imageMode(CORNER);
    // image(r.i.bg, 0, 0, w, h);

    // startUp.update();
    // if (scene == Scenes.StartUp) {
    //   updateHoveringClickable();
    //   return;
    // }

    switch (scene) {
      case StartUp:
        startUp.update();
        break;
      case Main:
        mainScene.update();
        break;
      case HelpModal:
        helpModal.update();
        break;
      case DLC:
        break;
      case Extras:
        break;
      case Quit:
        exit();
        break;
      default:
        break;
    }
    updateHoveringClickable();
  }

  @Override
  protected void setupAppClasses() {
    // Loading saves takes a long time for debugging purposes
    if (loadSaves) {
      saver = new Saver(this);
      saver.load();
    }

    startUp = new StartUp(this);
    startUp.setup();

    helpModal = new HelpModal(this);
    helpModal.setup();

    mainScene = new MainScene(this);
    mainScene.setup();
  }

  @Override
  public String getWindowTitle() {
    return "Sussy Justice";
  }

  public void mouseClicked(MouseEvent e) {
    if (helpModal.show) {
      helpModal.mouseClicked();
      return;
    }
  }
}
