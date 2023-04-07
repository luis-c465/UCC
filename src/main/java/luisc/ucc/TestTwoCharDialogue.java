package luisc.ucc;

public class TestTwoCharDialogue extends TwoCharacterDialogue {

  @Override
  protected void _setup() {
    leftCharName = "Captain";
    rightCharName = "Engineer";
    leftCharacterImg = p.loadImage("captain.png");
    rightCharacterImg = p.loadImage("engineer.png");

    bg = r.i.intro;
    add("Captain/", p.loadImage("captain.png"));
    add("Engineer/", p.loadImage("engineer.png"));

    add(
      "Captain//Good work, everyone. It looks like we've eliminated the imposter. Now we need to focus on repairing any damage they may have caused."
    );
    add(
      "Engineer//Yes, sir. I'll get to work on repairing the wires they cut in the engine room."
    );
    add(
      "Captain//Thank you, but we need to make sure this doesn't happen again. We need to improve our security measures."
    );
    add(
      "Engineer//Agreed, sir. I'll work on improving the ship's security systems."
    );
    add(
      "Captain//And we also need to make sure our crew is trained to handle situations like this. We can't let an imposter endanger our mission again."
    );
    add(
      "Engineer//I think we should also run regular security checks to make sure there aren't any hidden compartments or tools on board."
    );
    add(
      "Captain//Excellent idea. We need to be proactive about preventing any future threats. Thank you for your suggestions, Engineer."
    );
    add(
      "Engineer//No problem, sir. It's my job to keep the ship running smoothly."
    );
    add("Captain//And you're doing a great job. Keep up the good work.");
    add("Engineer//Thank you, sir. I'll keep you updated on my progress.");
    add(
      "Captain//Please do. Let's make sure this ship stays safe and on course."
    );
  }

  public TestTwoCharDialogue(App app) {
    super(app);
  }
}
