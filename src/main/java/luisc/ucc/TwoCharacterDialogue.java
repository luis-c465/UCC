package luisc.ucc;

import luisc.lib.PC;
import processing.core.PImage;

/**
 * Dialogue with two characters where only 2 characters are shown speaking at one time
 */
public class TwoCharacterDialogue extends Dialogue {

  public PImage leftCharacterImg;
  public PImage rightCharacterImg;
  public String leftCharName;
  public String rightCharName;

  /**
   * Shows the current text and displays each character one by one
   */
  @Override
  protected void _update() {
    p.imageMode(PC.CORNER);
    p.image(bg, 0, 0, App.w, App.h);

    p.textSize(20);
    p.fill(0);
    p.textAlign(PC.LEFT, PC.TOP);

    Text t = text.get(currentText);

    p.imageMode(PC.CORNER);
    push();
    if (t.character.equals(leftCharName)) {
      leftCharacterImg = characters.get(leftCharName + "/");
      p.scale(1, 1);
    } else if (t.character.equals(rightCharName)) {
      rightCharacterImg = characters.get(rightCharName + "/");
      p.translate(txtBoxX * 2 + r.i.textBox.width, 0);
      p.scale(-1, 1);
    }

    p.image(r.i.textBox, txtBoxX, txtBoxY, txtBoxW, txtBoxH);

    pop();

    p.scale(1, 1);

    p.image(leftCharacterImg, 50, 300);
    p.image(rightCharacterImg, App.w - 50 - 200, 300);

    p.textAlign(PC.LEFT, PC.TOP);
    p.textSize(32);
    p.text(
      t.text.substring(0, currentCharacter),
      100 + 20,
      700 + 20,
      txtBoxW - 40,
      txtBoxH - 20
    );

    if (currentCharacter < t.text.length()) {
      // currentCharacter++;
      currentCharacter = Math.min(currentCharacter + 5, t.text.length());
    }

    textBoxBtn.update();
  }

  public TwoCharacterDialogue(App app) {
    super(app);
  }
}
