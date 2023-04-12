package luisc.ucc.dialogue;

import luisc.ucc.App;

public class FindingJesse extends Dialogue {

  @Override
  protected void _setup() {
    bg = r.i.transparent;
    add("MC/", r.i.transparent);
    add("Friend/", r.i.transparent);
    add("Imposter/", r.i.transparent);
    add("Judge/", r.i.transparent);
    add("Jesse/", r.i.transparent);
    add("Jesse/Nervous", r.i.transparent);
    add("Jesse/Sweating", r.i.transparent);
    add("Jesse/Confused", r.i.transparent);

    add("[You walk into the hallway and see Jesse with crumbs on his face]");
    add("Jesse: Hey, whats up?");
    add("MC: Hey, I'm looking for my friend's lunchbox, have you seen it?");
    add("Jesse/Nervous: No, I haven't seen it");
    add("MC: You sure?");
    add("Jesse/Nervous: Yeah, I'm sure");

    add("MC: Alright will you let me check your bag?");
    add("Jesse/Confused: You really think I stole it?");
    add("MC: I don't know, but I need to check your bag to be sure");
    add("Jesse/Confused: Alright, I guess");

    add("[You check his bag and find the lunchbox opened]");
  }

  public FindingJesse(App app) {
    super(app);
  }
}
