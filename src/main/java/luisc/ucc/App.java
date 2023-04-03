package luisc.ucc;

import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import luisc.lib.BaseApp;
import luisc.lib.HelpModal;
import processing.event.MouseEvent;

/**
 * Main class for the application
 */
public final class App extends BaseApp {

  public static final int[] EASY_SHIPS = { 5, 4, 3 };
  public static final int[] HARD_SHIPS = { 6, 5, 4, 3, 2 };

  public int winner = -1;
  public int p1Wins = 0;
  public int p2Wins = 0;
  public boolean gameOver = false;
  public int curDropdown = 0;

  public boolean placeOver = false;
  public boolean turnOver = false;

  // Game classes
  public AppIntro intro;
  public Header header;
  public HelpModal helpModal;

  public int turnNum = 1;
  public Player p1;
  public Player p2;
  public Player player;
  public Turn turn;
  public SkipBtn endTurnBtn;

  public AudioPlayer sound;

  @Override
  public void draw() {
    defaultSettings();

    imageMode(CORNER);
    image(r.i.bg, 0, 0, w, h);

    doingIntro = false;
    doingStartUp = false;
    // intro.update();
    // if (doingIntro) {
    //   return;
    // }

    endTurnBtn.update();

    if (!turnOver && !placeOver) {
      header.update();

      player.update();

      helpModal.update();
    } else {
      turn.update();
    }

    checkGameOver();
  }

  @Override
  protected void setupAppClasses() {
    Minim minim = new Minim(this);
    sound = minim.loadFile("loud.mp3");

    intro = new AppIntro(this);
    intro.setup();

    header = new Header(this);
    header.setup();

    helpModal = new HelpModal(this);
    helpModal.setup();

    endTurnBtn = new SkipBtn(this);
    endTurnBtn.setup();

    turn = new Turn(this);
    turn.setup();

    // Instantiate the players
    dropdown(1);

    println(p1);
    println(p2);
  }

  @Override
  public String getWindowTitle() {
    return "RICODE Encryption & Decryption";
  }

  public void mouseClicked(MouseEvent e) {
    sound.play(0);

    if (turnOver || helpModal.show) {
      helpModal.mouseClicked();
      return;
    }

    if (player.placingShips) {
      player.shipPlacer.onMouseClick();
    } else {
      player.shotPlacer.onMouseClick();
    }
  }

  public void dropdown(int n) {
    if (n == 0) {
      p1 = new Player(this, 1, true, EASY_SHIPS);
      p2 = new Player(this, 2, true, EASY_SHIPS);
    } else if (n == 1) {
      p1 = new Player(this, 1, false, HARD_SHIPS);
      p2 = new Player(this, 2, false, HARD_SHIPS);
    }

    p1.setup();
    p2.setup();

    p1.otherPlayer = p2;
    p2.otherPlayer = p1;

    player = p1;
    curDropdown = n;
    winner = -1;

    gameOver = false;
    turnOver = false;
  }

  public void checkGameOver() {
    if (gameOver || p1.placingShips || p2.placingShips) {
      return;
    }

    if (p1.checkIfWon()) {
      p1Wins++;
      gameOver = true;
      winner = 1;
    } else if (p2.checkIfWon()) {
      p2Wins++;
      gameOver = true;
      winner = 2;
    }
  }
}
