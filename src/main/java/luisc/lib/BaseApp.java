package luisc.lib;

import controlP5.ControlP5;
import java.util.Random;
import luisc.resources.Resources;
import luisc.ucc.App;
import processing.core.PApplet;

/**
 * Base class for all apps
 */
public abstract class BaseApp extends PApplet {

  public boolean hoveringClickable = false;

  public int curCursor = PC.ARROW;

  public Random rand = new Random();

  public boolean doingIntro = true;
  public boolean doingStartUp = true;
  public boolean transitioning = false;

  // * Util classes
  public Resources r;

  // * library classes
  public ControlP5 cp5;

  // Transition classes
  public TransitionIn transIn;
  public TransitionOut transOut;

  // * CONSTANTS
  /** Height of the app */
  public static final int h = 1000;
  /** Width of the app */
  public static final int w = 1000;

  /** Center height of the app */
  public static final int ch = 500;
  /** Center width of the app */
  public static final int cw = 500;

  // * COLORS
  /** Background Color */
  public static final int bg = 0xff1e293b;

  @Override
  public void settings() {
    size(1000, 1000);
  }

  @Override
  public void setup() {
    surface.setTitle(getWindowTitle());
    getWindowTitle();
    defaultSettings();
    setupUtilAndLib();
    setupAppClasses();
  }

  protected abstract String getWindowTitle();

  /**
   * Setups util and library classes
   */
  protected void setupUtilAndLib() {
    r = new Resources(this);
    cp5 = new ControlP5(this);

    transIn = new TransitionIn((App) this);
    transOut = new TransitionOut((App) this);
    transIn.setup();
    transOut.setup();
  }

  /**
   * Setups the classes used in the app
   */
  protected abstract void setupAppClasses();

  public static void main(String[] args) {
    runSketch(getAppletArgs(), null);
  }

  /**
   * Sets the default settings for drawing with processing
   */
  public void defaultSettings() {
    frameRate(30);
    smooth();
    background(bg);
    shapeMode(CENTER);
    textAlign(CENTER);
    imageMode(CENTER);
    noStroke();

    // Default fill color is white
    fill(255);
  }

  protected static String[] getAppletArgs() {
    return new String[] { "--display=1", getMainClassName() };
  }

  protected static String getMainClassName() {
    return App.class.getName();
  }

  protected void updateHoveringClickable() {
    if (hoveringClickable) {
      cursor(PC.HAND);
    } else {
      cursor(PC.ARROW);
    }

    hoveringClickable = false;
  }
}
