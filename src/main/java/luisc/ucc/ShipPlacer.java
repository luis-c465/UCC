package luisc.ucc;

import luisc.lib.Obj;
import luisc.lib.PC;

/**
 * Left click to place a ship downwards
 * Right click to place a ship to the right
 */
public class ShipPlacer extends Obj {

  public int[] ships;

  public Player player;
  public int placingShipIndex = 0;
  public int placingShip = 5;

  @Override
  protected void _update() {}

  public void onMouseClick() {
    // First find the location for the ship
    // Then check if the ship can be placed there
    if (
      p.mouseX < Player.PADDING_LEFT_SHIPS ||
      p.mouseX > Player.PADDING_LEFT_SHIPS + 8 * 50
    ) {
      return;
    } else if (
      p.mouseY < Player.PADDING_TOP_SHIPS ||
      p.mouseY > Player.PADDING_TOP_SHIPS + 8 * 50
    ) {
      return;
    }

    if (placingShipIndex < ships.length) {
      placingShip = ships[placingShipIndex];
    }

    int row = (int) ((p.mouseY - Player.PADDING_TOP_SHIPS) / ShipViewer.SIZE);
    int col = (int) ((p.mouseX - Player.PADDING_LEFT_SHIPS) / ShipViewer.SIZE);

    // Place ship downwards from row and col
    if (p.mouseButton == PC.LEFT) {
      // Check if the ship can fit in the board
      if (row + placingShip > Board.ROWS) {
        return;
      }

      // Check if all the spaces are empty
      for (int i = 0; i < placingShip; i++) {
        if (player.ships.ships[row + i][col].value != ShipViewer.Default) {
          return;
        }
      }

      // Finally Place the ship
      for (int i = 0; i < placingShip; i++) {
        player.ships.ships[row + i][col].value = placingShip;
      }

      placingShipIndex++;
    } else if (p.mouseButton == PC.RIGHT) { // Place the ship to the right
      // Check if the ship can fit in the board
      if (col + placingShip > Board.COLS) {
        return;
      }

      // Check if all the spaces are empty
      for (int i = 0; i < placingShip; i++) {
        if (player.ships.ships[row][col + i].value != ShipViewer.Default) {
          return;
        }
      }

      // Finally Place the ship
      for (int i = 0; i < placingShip; i++) {
        player.ships.ships[row][col + i].value = placingShip;
      }

      placingShipIndex++;
    }

    if (placingShipIndex >= ships.length) {
      player.placingShips = false;

      a.placeOver = true;
    }
  }

  public ShipPlacer(App app, Player player, int[] ships) {
    super(app);
    this.player = player;
    this.ships = ships;
  }
}
