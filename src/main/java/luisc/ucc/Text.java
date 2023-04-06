package luisc.ucc;

public class Text {

  public String character;
  public String emotion;
  public String text;

  public Text(String character, String emotion, String text) {
    this.character = character;
    this.emotion = emotion;
    this.text = text;
  }

  public Text(String all) {
    String[] parts = all.split("/");
    this.character = parts[0];
    this.emotion = parts[1];
    this.text = parts[2];
  }

  public String toString() {
    return character + "/" + emotion + "/" + text;
  }

  public String getIdentifier() {
    return character + "/" + emotion;
  }
}
