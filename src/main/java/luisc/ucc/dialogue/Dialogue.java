package luisc.ucc.dialogue;

import ddf.minim.AudioPlayer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import luisc.lib.KeyboardBtn;
import luisc.lib.Obj;
import luisc.lib.PC;
import luisc.ucc.App;
import luisc.ucc.scene.MainScene;
import processing.core.PImage;

/**
 * A dialogue is a sequence of text that is displayed on the screen
 */
public abstract class Dialogue extends Obj {

  public boolean skipDialogue = true;

  private static final int charStep = 5;
  private static final int textSize = 25;
  public static final int characterWidth = 250;
  public static final int txtBoxH = 300;
  public static final int txtBoxW = 800;
  public static final int txtBoxY = 700 - 50;

  public static final int txtY = txtBoxY + 20;
  public static final int txtBoxX = 100;
  public static final int txtBoxPadding = 20;

  public TextBoxBtn textBoxBtn;

  public PImage bg;
  public List<Text> text = new ArrayList<>();
  public Map<String, PImage> characters = new HashMap<>();

  public int currentText = 0;
  public int currentCharacter = 0;

  public boolean done = false;
  public boolean almostDone = false;

  @Override
  protected void preSetup() {
    textBoxBtn = new TextBoxBtn(a);
    bg = r.i.transparent;
  }

  @Override
  protected void postSetup() {
    // Go through all values in the characters map and resize them
    add("/", r.i.transparent);
    add("mc", r.ch.mc);
    add("mc/crying", r.ch.mcCrying);
    add("mc/ligma", r.ch.mcLigma);
    add("mc/pointing", r.ch.mcPointing);
    add("mc/thinking", r.ch.mcThinking);
    add("mc/thumbs-up", r.ch.mcThumbsUp);
    add("mc/worried", r.ch.mcWorried);

    add("engineer", r.ch.engineer);
    add("engineer/crying", r.ch.engineerCrying);
    add("engineer/ligma", r.ch.engineerLigma);
    add("engineer/thinking", r.ch.engineerThinking);
    add("engineer/thumbs-up", r.ch.engineerThumbsUp);
    add("engineer/worried", r.ch.engineerWorried);

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

    if (img == null) {
      img = r.i.transparent;
      App.println("The character " + t.getIdentifier() + " does not exist");
    }

    p.imageMode(PC.CORNER);
    p.image(r.i.textBox, txtBoxX, txtBoxY, txtBoxW, txtBoxH);
    p.image(img, 50, 300);

    p.textAlign(PC.LEFT, PC.TOP);

    // Character
    p.textSize(20);
    p.text(t.character, txtBoxX + 45, txtY);

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
   * Adds a new text to the dialogue
   *
   * @param dialogue The text to add
   */
  public void add(String dialogue, AudioPlayer soundOnText) {
    text.add(new Text(dialogue, soundOnText));
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
      if (almostDone) {
        super.preUpdate();
        return;
      }

      if (
        currentCharacter >= text.get(currentText).text.length() &&
        (currentText + 1) >= text.size()
      ) {
        if (skipDialogue) {
          almostDone = true;
          shouldCheck = true;
        }

        super.preUpdate();
        return;
      }

      if (
        currentCharacter < text.get(currentText).text.length() ||
        (currentText + 1) >= text.size()
      ) {
        if (skipDialogue) {
          shouldCheck = false;
        }
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
      if (!skipDialogue && currentText >= text.size() - 1) {
        done = true;
        onDone();

        return;
      }

      if (almostDone) {
        a.mainScene.ticksSwitched = MainScene.TICKS_TO_SWITCH;

        done = true;
        onDone();
        return;
      }

      currentCharacter = 0;
      currentText++;

      Text temp = text.get(currentText);
      if (temp.sound != null) {
        temp.sound.play(0);
      }
    }
  }

  /**
   * Override this method to do something when the dialogue is done
   */
  public void onDone() {}

  protected void setDialogue(Dialogue dia) {
    a.mainScene.court.setDialogue(dia);
  }

  protected void setOptions(Options opts) {
    a.mainScene.court.setOptions(opts);
  }

  protected boolean hasEvidence(String evidence) {
    return a.hasEvidence(evidence);
  }

  public Dialogue(App app) {
    super(app);
  }
}
