package luisc.ucc;

public class TestDialogue extends Dialogue {

  public TestDialogue(App app) {
    super(app);
    bg = r.i.intro;
    add("Luis/Neutral", r.i.miss);
    add("Luis/SUSY", r.i.amog);
    add("Luis/Wet", r.i.water);

    add("Luis/Neutral/An imposter is among us!!!");
    add("Luis/SUSY/Are you ready to play?");
    add("Luis/Wet/Your making me wet!!!!?");
  }
}
