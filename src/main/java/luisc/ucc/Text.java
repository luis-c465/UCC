package luisc.ucc;

public class Text {

  public String character = "";
  public String emotion = "";
  public String text = "";

  public Text(String character, String emotion, String text) {
    this.character = character;
    this.emotion = emotion;
    this.text = text;
  }

  public Text(String all) {
    if (all.charAt(0) == '[') {
      text = all;
      return;
    }

    String[] parts = all.split(":");

    String[] first = parts[0].split("/");
    this.character = first[0];
    this.emotion = first.length > 1 ? first[1] : "";

    this.text = parts[1];
  }

  public String toString() {
    return character + "/" + emotion + ":" + text;
  }

  public String getIdentifier() {
    return character + "/" + emotion;
  }
}
