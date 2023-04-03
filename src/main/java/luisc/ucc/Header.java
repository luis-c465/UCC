package luisc.ucc;

import controlP5.ControlP5;
import luisc.lib.BaseHeader;
import luisc.lib.PC;
import luisc.resources.Colors;

public class Header extends BaseHeader {

  @Override
  protected void _update() {
    p.textSize(25);
    if (a.player.placingShips) {
      int curShipLen =
        a.player.shipPlacer.ships[a.player.shipPlacer.placingShipIndex <
            a.player.shipPlacer.ships.length
            ? a.player.shipPlacer.placingShipIndex
            : 0];
      p.text(
        "Player " + a.player.num + " place a ship of length " + curShipLen,
        App.cw - 50,
        30
      );
    } else {
      p.text("Player " + a.player.num + " Take your shot", App.cw - 50, 30);
    }

    p.textSize(30);
    p.fill(Colors.success);
    if (a.player.placingShips) {
      p.text("Your Ships", App.cw / 2, 80);
    } else {
      p.text("Shots", App.cw / 2 + 450, 80);
    }

    p.fill(255);
    if (!a.player.placingShips) {
      p.text("Your Ships", App.cw / 2, 80);
    } else {
      p.text("Shots", App.cw / 2 + 450, 80);
    }

    // Show the number of wins for that player
    p.textSize(20);

    int curPlayerWins = a.player.num == 1 ? a.p1Wins : a.p2Wins;
    int otherPlayerWins = a.player.num == 1 ? a.p2Wins : a.p1Wins;
    p.textAlign(PC.LEFT);
    p.text("Wins: " + curPlayerWins + " - Losses: " + otherPlayerWins, 20, 20);
  }

  @Override
  protected void createControllers() {
    difficulty =
      a.cp5
        .addScrollableList("dropdown")
        .setPosition(700, 0)
        .setSize(130, 500)
        .setBarHeight(30)
        .setItemHeight(20)
        .addItems(new String[] { "Easy (3 Ships & See)", "Medium (5 Ships)" })
        .setLabel("Difficulty")
        .close()
        .hide();

    difficulty
      .getValueLabel()
      .align(ControlP5.LEFT, ControlP5.BOTTOM_OUTSIDE)
      .setPaddingX(0)
      .setFont(r.f.nunito)
      .setSize(12);

    difficulty
      .getCaptionLabel()
      .align(ControlP5.LEFT, ControlP5.BOTTOM_OUTSIDE)
      .setPaddingX(0)
      .setFont(r.f.nunito)
      .setSize(12);

    controllers.add(difficulty);
  }

  public Header(App app) {
    super(app);
  }
}
