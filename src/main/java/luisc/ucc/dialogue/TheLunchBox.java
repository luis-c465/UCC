package luisc.ucc.dialogue;

import luisc.ucc.App;

public class TheLunchBox extends Dialogue {

  @Override
  protected void _setup() {
    bg = r.i.transparent;
    add("MC/", r.i.transparent);
    add("MC/Screaming", r.i.transparent);

    add("Friend/", r.i.transparent);
    add("Friend/Running", r.i.transparent);
    add("Friend/Mad", r.i.transparent);

    add("Jesse/", r.i.transparent);
    add("Jesse/Nervous", r.i.transparent);
    add("Jesse/Sweating", r.i.transparent);
    add("Jesse/Confused", r.i.transparent);

    add("MC/Screaming: Ayoo Jose come here real quick");

    // Stomping sounds as he approaches
    add("Friend/Running: Holy Jesse really man?");
    add("Friend/Mad: You really did it?");

    add("Jesse/Nervous: What did I do?");
    add("Friend/Mad: Stop with the cap I see the crumbs on your face!");
    add("[You both drag Jesse to the maths teachers classroom]");
  }

  public TheLunchBox(App app) {
    super(app);
  }
}
