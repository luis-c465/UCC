package luisc.ucc;

public class MathClassroom extends Dialogue {

  @Override
  protected void _setup() {
    bg = r.i.transparent;
    add("MC/", r.i.transparent);

    add("Friend/", r.i.transparent);

    add("Jesse/", r.i.transparent);

    add("Rico/", r.i.transparent);

    add("[Jesse is dragged into the teachers classroom]");
    add("Rico: What going on here?");
    add("MC: This kid stole my friends lunchbox!");
    add("Rico: What? How do you know it was him?");
    add("MC: Uhhhhhhh, he had crumbs on his face");
    add(
      "Rico: Well, he doesnt have them on now after you dragged him all the way here"
    );
    add("Rico: How do you know he stole it?");

    add("Rico: Well, I guess I'll have to take a look at his bag");
  }

  public MathClassroom(App app) {
    super(app);
  }
}
