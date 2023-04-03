package luisc.ucc;

import luisc.lib.Obj;

public class Player extends Obj {

  public Player otherPlayer;
  public boolean tookShot = false;
  public int num = 0;

  public static final int PADDING_TOP_SHIPS = 100;
  public static final int PADDING_LEFT_SHIPS = 50;

  public static final int PADDING_TOP_SHOTS = 100;
  public static final int PADDING_LEFT_SHOTS = 500;

  public boolean placingShips = true;

  public Board ships;
  public Board shots;
  public ShipPlacer shipPlacer;
  public ShotPlacer shotPlacer;

  public Player(App a, int n, boolean shouldShowEnemyShips, int[] arr) {
    super(a);
    this.num = n;

    ships = new Board(a, this, PADDING_LEFT_SHIPS, PADDING_TOP_SHIPS, false);
    shots =
      new Board(
        a,
        this,
        PADDING_LEFT_SHOTS,
        PADDING_TOP_SHOTS,
        shouldShowEnemyShips
      );

    shipPlacer = new ShipPlacer(a, this, arr);
    shotPlacer = new ShotPlacer(a, this);

    ships.setup();
    shots.setup();
    shipPlacer.setup();
    shotPlacer.setup();
  }

  @Override
  protected void _update() {
    ships.update();
    shots.update();
  }

  public boolean checkIfWon() {
    for (int i = 0; i < ships.ships.length; i++) {
      for (int j = 0; j < ships.ships[i].length; j++) {
        if (ships.ships[i][j].value >= ShipViewer.Patrol) {
          return false;
        }
      }
    }

    return true;
  }

  @Override
  public String toString() {
    return "Player [ships=" + ships + "\n, shots=" + shots + "]";
  }
}
