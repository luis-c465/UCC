package luisc.ucc;

import java.util.Arrays;
import luisc.lib.Obj;

public class Board extends Obj {

  public boolean showEnemyShips = false;

  public Player player;

  public static final int ROWS = 7;
  public static final int COLS = 7;

  public ShipViewer[][] ships = new ShipViewer[ROWS][COLS];

  @Override
  protected void _update() {
    // Update all the ships
    for (int i = 0; i < ships.length; i++) {
      for (int j = 0; j < ships[i].length; j++) {
        ships[i][j].update();
      }
    }
  }

  @Override
  public String toString() {
    return Arrays.deepToString(ships);
  }

  public Board(App a, Player p, int px, int py) {
    super(a);
    this.player = p;

    for (int i = 0; i < ships.length; i++) {
      for (int j = 0; j < ships[i].length; j++) {
        ships[i][j] = new ShipViewer(a, i, j, px, py, false);
      }
    }
  }

  public Board(App a, Player p, int px, int py, boolean showEnemyShips) {
    super(a);
    this.showEnemyShips = showEnemyShips;
    this.player = p;

    for (int i = 0; i < ships.length; i++) {
      for (int j = 0; j < ships[i].length; j++) {
        ships[i][j] = new ShipViewer(a, i, j, px, py, showEnemyShips);
      }
    }
  }
}
