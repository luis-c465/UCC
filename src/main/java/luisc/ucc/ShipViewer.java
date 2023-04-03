package luisc.ucc;

import luisc.lib.Obj;
import luisc.lib.PC;

public class ShipViewer extends Obj {

  public boolean showEnemyShips = false;

  public int x, y, row, col;

  public static final int SIZE = 60;

  public static final int Aircraft = 5;
  public static final int Battleship = 4;
  public static final int Destroyer = 3;
  public static final int Submarine = 3;
  public static final int Patrol = 2;

  // Should be a different class but I'm lazy, lol
  public static final int Hit = 1;
  public static final int Miss = 0;
  public static final int Default = -1;

  public int value = Default;
  public boolean hit = false;

  @Override
  protected void _update() {
    p.imageMode(PC.CORNER);
    p.image(r.i.water, x, y, SIZE, SIZE);

    p.rectMode(PC.CORNER);
    p.noFill();
    p.strokeWeight(2);
    p.stroke(0);
    p.rect(x, y, SIZE, SIZE);

    p.textAlign(PC.CENTER);
    p.textSize(20);
    // if (value != Default) {
    //   p.text("" + value, x + SIZE / 2, y + SIZE / 2);
    // }

    if (value >= Patrol) {
      p.image(r.i.amog, x, y, SIZE, SIZE);
    } else if (value == Miss) {
      p.image(r.i.miss, x, y, SIZE, SIZE);
    } else if (value == Hit) {
      p.image(r.i.shotAmog, x, y, SIZE, SIZE);
    }

    if (
      showEnemyShips &&
      a.player.otherPlayer.ships.ships[row][col].value > Patrol
    ) {
      p.fill(255, 0, 0);
      p.rect(x, y, SIZE, SIZE);
    }
  }

  @Override
  public String toString() {
    return "" + value + (hit ? "hit" : "");
  }

  public ShipViewer(
    App a,
    int r,
    int c,
    int px,
    int py,
    boolean showEnemyShips
  ) {
    super(a);
    x = px + c * SIZE;
    y = py + r * SIZE;

    row = r;
    col = c;

    this.showEnemyShips = showEnemyShips;
  }
}
