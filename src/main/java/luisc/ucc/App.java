package luisc.ucc;

import java.util.HashSet;
import java.util.Set;
import luisc.lib.BaseApp;
import luisc.ucc.data.Saver;
import luisc.ucc.scene.MainScene;
import luisc.ucc.scene.Scenes;
import luisc.ucc.scene.StartUp;
import processing.event.MouseEvent;

/**
 * Main class for the application
 */
public final class App extends BaseApp {

  public boolean modalShowing;

  public static final boolean loadSaves = false;

  public Scenes scene = Scenes.StartUp;

  public MainScene mainScene;

  public Saver saver;

  public boolean gameOver = false;

  // Game classes
  public StartUp startUp;

  // Data values
  public int test;
  public Set<String> evidence = new HashSet<>();

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
    }

    startUp = new StartUp(this);
    startUp.setup();

    mainScene = new MainScene(this);
    mainScene.setup();
  }

  @Override
  public String getWindowTitle() {
    return "Sussy Justice";
  }

  public void mouseClicked(MouseEvent e) {
    if (mainScene.map.show) {
      mainScene.map.mouseClicked();
      return;
    }
  }

  public boolean hasEvidence(String s) {
    return evidence.contains(s);
  }
}
