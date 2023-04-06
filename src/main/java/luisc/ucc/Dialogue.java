package luisc.ucc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import luisc.lib.KeyboardBtn;
import luisc.lib.Obj;
import luisc.lib.PC;
import processing.core.PImage;

public abstract class Dialogue extends Obj {

  private static final int txtBoxH = 300;
  private static final int txtBoxW = 800;
  private static final int txtBoxY = 700 - 50;
  private static final int txtBoxX = 100;

  public TextBoxBtn textBoxBtn;

  public PImage bg;
  public List<Text> text = new ArrayList<>();
  public Map<String, PImage> characters = new HashMap<>();

  public int currentText = 0;
  public int currentCharacter = 0;

  @Override
  protected void _setup() {
    textBoxBtn = new TextBoxBtn(a);
  }

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
    PImage img = characters.get(t.getIdentifier());

    p.imageMode(PC.CORNER);
    p.image(r.i.textBox, txtBoxX, txtBoxY, txtBoxW, txtBoxH);
    p.image(img, 50, 300, 250, 250);

    p.textAlign(PC.LEFT, PC.TOP);
    p.textSize(32);
    p.text(t.text.substring(0, currentCharacter), 100 + 20, 700 + 20);

    if (currentCharacter < t.text.length()) {
      currentCharacter++;
    }

    textBoxBtn.update();
  }

  /**
   * Adds a new text to the dialogue
   *
   * @param dialogue The text to add
   */
  public void add(String dialogue) {
    text.add(new Text(dialogue));
  }

  /**
   * Adds a new characters and their images to the dialogue
   *
   */
  public void add(String identifier, PImage image) {
    characters.put(identifier, image);
  }

  protected class TextBoxBtn extends KeyboardBtn {

    @Override
    public void postSetup() {
      updateCorners();
    }

    @Override
    protected void _update() {
      // does nothing
    }

    @Override
    protected void preUpdate() {
      if (
        currentCharacter < text.get(currentText).text.length() ||
        (currentText + 1) >= text.size()
      ) {
        shouldCheck = false;
      } else {
        shouldCheck = true;
      }

      super.preUpdate();
    }

    public TextBoxBtn(App app) {
      super(app);
      setup();
    }

    @Override
    protected void _setup() {
      kc = PC.ENTER;

      x = txtBoxX;
      y = txtBoxY + txtBoxH;
      w = txtBoxW;
      h = txtBoxH;

      cornerToCenter();
    }

    @Override
    protected void onClick() {
      currentCharacter = 0;
      currentText++;
    }
  }

  public Dialogue(App app) {
    super(app);
  }
}
