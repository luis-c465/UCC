package luisc.ucc.dialogue;

import luisc.ucc.App;

public class BabyFirstCase extends Dialogue {

  @Override
  protected void _setup() {
    bg = r.i.transparent;
    add("MC/", r.i.transparent);
    add("Friend/", r.i.transparent);
    add("Imposter/", r.i.transparent);
    add("Judge/", r.i.transparent);
    add("Jesse/", r.i.transparent);
    add("Walter/", r.i.transparent);

    add("MC: Hey friend, what's up?");
    add("Friend: Hey, I'm just looking for my lunch box.");
    add("Friend: It was just there 5 minutes ago, and now it's gone!");

    add("MC: Weird, did you leave it somewhere?");
    add("Friend: Yeah, I left it in my first period class.");
    add("MC: What class was that?");
    add("Friend: It was math class.");
    add("MC: Oh, Mr Johnson's class?");
    add("Friend: Yeah, that's the one.");
    add(
      "Friend: So I had left it in the lunch box holder and when I left to go to the bathroom it was gone."
    );

    add("Friend: It had a sandwich, some chips, and a drink.");

    add("MC: Well, did you see anyone else in the class?");
    add(
      "Friend: Yeah, there was a kid named Jesse, he was sitting next to me."
    );
    // Plays breaking bad theme
    add("MC: Jesse from breaking bad??");
    add("Friend: No");
    add("MC: Oh, sorry, I thought you said Jesse from breaking bad");

    add("MC: Anyways, lets go find jesse");
    add("MC: Lets look in the halls for him first");
  }

  public BabyFirstCase(App app) {
    super(app);
  }
}
