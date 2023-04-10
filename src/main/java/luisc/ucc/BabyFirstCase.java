package luisc.ucc;

public class BabyFirstCase extends Dialogue {

  @Override
  protected void _setup() {
    bg = r.i.transparent;
    add("MC/", r.i.transparent);
    add("Hungry Child/", r.i.transparent);
    add("Imposter/", r.i.transparent);
    add("Judge/", r.i.transparent);
    add("Jesse/", r.i.transparent);
    add("Walter/", r.i.transparent);

    add("Hungry Child: hey there, do you know what happened to my lunch box?");
    add("Hungry Child: It was just there 5 minutes ago, and now it's gone!");

    add("MC: I really don't know, but I can help you find it.");

    add("Hungry Child: Oh, thanks, that would be great");
    add("MC: So what did you have in your lunch box?");

    add("Hungry Child: I had a sandwich, some chips, and a drink.");
    add(
      "Hungry Child: And I had a toy in there too, but I don't think that's important."
    );

    add("MC: Maybe it is... What was the toy?");
    add(
      "Hungry Child: It was a toy car, it was blue and had a red stripe on it."
    );

    add(
      "MC: That's a pretty specific description, but I'll keep an eye out for it."
    );

    add("MC: When was the last time you saw your lunch box?");
    add(
      "Hungry Child: I had left it in my first periods class lunch box holder near the top right corner."
    );
    add(
      "Hungry Child: After the class ended I went to the bathroom and when I came back it was gone."
    );

    add("MC: Did you see anyone else in the class?");
    add(
      "Hungry Child: Yeah, there was a kid named Jesse, he was sitting next to me."
    );
    // Plays breaking bad theme
    add("MC: Jesse from breaking bad??");
    add("Hungry Child: No");
    add("MC: Oh, sorry, I thought you said Jesse from breaking bad");

    add("MC: Anyways, lets go find jesse");
  }

  public BabyFirstCase(App app) {
    super(app);
  }
}
