package luisc.ucc;

import luisc.lib.Obj;
import luisc.lib.PC;

/**
 * Left click to place a ship downwards
 * Right click to place a ship to the right
 */
public class ShotPlacer extends Obj {

  public Player player;

  @Override
  protected void _update() {}

  public void onMouseClick() {
    if (player.tookShot) return;

    // First find the location for the ship
    // Then check if the ship can be placed there
    if (
      p.mouseX < Player.PADDING_LEFT_SHOTS ||
      p.mouseX > Player.PADDING_LEFT_SHOTS + 8 * 50
    ) {
      return;
    } else if (
      p.mouseY < Player.PADDING_TOP_SHOTS ||
      p.mouseY > Player.PADDING_TOP_SHOTS + 8 * 50
    ) {
      return;
    }

    int row = (int) ((p.mouseY - Player.PADDING_TOP_SHOTS) / ShipViewer.SIZE);
    int col = (int) ((p.mouseX - Player.PADDING_LEFT_SHOTS) / ShipViewer.SIZE);

    if (p.mouseButton == PC.LEFT) {
      if (player.shots.ships[row][col].value != ShipViewer.Default) {
        return;
      }

      if (
        player.otherPlayer.ships.ships[row][col].value == ShipViewer.Default
      ) {
        player.shots.ships[row][col].value = ShipViewer.Miss;
      } else {
        player.shots.ships[row][col].value = ShipViewer.Hit;
        player.otherPlayer.ships.ships[row][col].value = ShipViewer.Hit;
      }

      player.tookShot = true;
    }
  }

  public ShotPlacer(App app, Player player) {
    super(app);
    this.player = player;
  }
}
