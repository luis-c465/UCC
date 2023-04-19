package luisc.ucc.dialogue;

import ddf.minim.AudioPlayer;
import java.io.File;
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
  public static final int characterHeight = 250;

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

    add("MC/", r.ch.mc);
    add("MC/crying", r.ch.mcCrying);
    add("MC/ligma", r.ch.mcLigma);
    add("MC/thinking", r.ch.mcThinking);
    add("MC/thumbs-up", r.ch.mcThumbsUp);
    add("MC/worried", r.ch.mcWorried);
    add("MC/pointing", r.ch.mcPointing);

    add("Engineer/", r.ch.engineer);
    add("Engineer/crying", r.ch.engineerCrying);
    add("Engineer/ligma", r.ch.engineerLigma);
    add("Engineer/thinking", r.ch.engineerThinking);
    add("Engineer/thumbs-up", r.ch.engineerThumbsUp);
    add("Engineer/worried", r.ch.engineerWorried);

    add("Gunner/", r.ch.gunner);
    add("Gunner/crying", r.ch.gunnerCrying);
    add("Gunner/ligma", r.ch.gunnerLigma);
    add("Gunner/thinking", r.ch.gunnerThinking);
    add("Gunner/thumbs-up", r.ch.gunnerThumbsUp);
    add("Gunner/worried", r.ch.gunnerWorried);
    add("Gunner/pointing", r.ch.gunnerPointing);
    add("Gunner/chad", r.ch.gunnerChad);

    add("Medic/", r.ch.medic);
    add("Medic/crying", r.ch.medicCrying);
    add("Medic/ligma", r.ch.medicLigma);
    add("Medic/thinking", r.ch.medicThinking);
    add("Medic/thumbs-up", r.ch.medicThumbsUp);
    add("Medic/worried", r.ch.medicWorried);
    add("Medic/pointing", r.ch.medicPointing);

    add("Navigator/", r.ch.navigator);
    add("Navigator/crying", r.ch.navigatorCrying);
    add("Navigator/ligma", r.ch.navigatorLigma);
    add("Navigator/thinking", r.ch.navigatorThinking);
    add("Navigator/thumbs-up", r.ch.navigatorThumbsUp);
    add("Navigator/worried", r.ch.navigatorWorried);
    add("Navigator/pointing", r.ch.navigatorPointing);

    add("Communicator/", r.ch.communicator);
    add("Communicator/crying", r.ch.communicatorCrying);
    add("Communicator/ligma", r.ch.communicatorLigma);
    add("Communicator/thinking", r.ch.communicatorThinking);
    add("Communicator/thumbs-up", r.ch.communicatorThumbsUp);
    add("Communicator/worried", r.ch.communicatorWorried);
    add("Communicator/pointing", r.ch.communicatorPointing);
    add("Communicator/ltg", r.ch.lta);

    for (Map.Entry<String, PImage> entry : characters.entrySet()) {
      PImage img = entry.getValue();
      img.resize(0, characterHeight);
    }

    if (text.size() > 0) {
      Text temp = text.get(currentText);
      if (temp.sound != null) {
        temp.sound.play(0);
      }
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
   * Adds a new text to the dialogue
   *
   * @param dialogue The text to add
   */
  public void add(String dialogue, String sound) {
    text.add(
      new Text(
        dialogue,
        a.minim.loadFile("voices" + File.separator + sound + ".mp3")
      )
    );
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

      if (p.keyCode == kc && currentText + 2 < text.size()) {
        if (currentText + 2 < text.size()) {
          currentCharacter = 0;
          currentText++;
        } else {
          currentCharacter = text.get(currentText).text.length() - 1;
        }
        App.println("Clicked ");

        p.keyCode = 0;
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
