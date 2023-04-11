package luisc.ucc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import luisc.lib.KeyboardBtn;
import luisc.lib.Obj;
import luisc.lib.PC;
import processing.core.PImage;

/**
 * A dialogue is a sequence of text that is displayed on the screen
 */
public abstract class Dialogue extends Obj {

  private static final int charStep = Integer.MAX_VALUE;
  private static final int textSize = 25;
  protected static final int characterWidth = 250;
  protected static final int txtBoxH = 300;
  protected static final int txtBoxW = 800;
  protected static final int txtBoxY = 700 - 50;
  protected static final int txtBoxX = 100;

  public TextBoxBtn textBoxBtn;

  public PImage bg;
  public List<Text> text = new ArrayList<>();
  public Map<String, PImage> characters = new HashMap<>();

  public int currentText = 0;
  public int currentCharacter = 0;

  public boolean done = false;

  @Override
  protected void preSetup() {
    textBoxBtn = new TextBoxBtn(a);
  }

  @Override
  protected void postSetup() {
    // Go through all values in the characters map and resize them
    add("/", r.i.transparent);

    for (Map.Entry<String, PImage> entry : characters.entrySet()) {
      PImage img = entry.getValue();
      img.resize(characterWidth, 0);
    }
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
    p.image(img, 50, 300);

    p.textAlign(PC.LEFT, PC.TOP);

    // Character
    p.textSize(20);
    p.text(t.character, txtBoxX + 45, txtBoxY + 20);

    // Dialogue
    p.textSize(textSize);
    p.text(
      t.text.substring(0, currentCharacter),
      100 + 20,
      700 + 20,
      txtBoxW - 40,
      txtBoxH - 20
    );

    if (currentCharacter < t.text.length()) {
      // currentCharacter++;
      currentCharacter = Math.min(currentCharacter + charStep, t.text.length());
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
        currentCharacter <= text.get(currentText).text.length() &&
        (currentText + 1) >= text.size()
      ) {
        done = true;
        shouldCheck = false;

        super.preUpdate();
        return;
      }

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
