package luisc.ucc.explore;

import luisc.lib.Clickable;
import luisc.ucc.App;
import luisc.ucc.dialogue.Dialogue;

public class Evidence extends Clickable {

  String text = null;
  EvidenceDialogue dialogue = null;
  public boolean doingDialogue = false;

  public Evidence(App app, String identifier, int x, int y, String... text) {
    super(app, x, y, 50, 50);
    this.identifier = identifier;
    dialogue = new EvidenceDialogue(app, text);
    dialogue.setup();

    setup();
  }

  @Override
  protected void _update() {
    if (doingDialogue) {
      dialogue.update();
      if (dialogue.done) {
        doingDialogue = false;
      }
    }
  }

  @Override
  protected void onClick() {
    a.evidence.add(identifier);
    App.println("Added evidence: " + identifier);
    App.println("Evidence: " + a.evidence);

    this.shouldCheck = false;
    this.doingDialogue = true;
    r.sfx.vine.play(0);
  }

  public class EvidenceDialogue extends Dialogue {

    String[] text;

    public EvidenceDialogue(App app, String... text) {
      super(app);
      this.text = text;
      this.skipDialogue = false;
    }

    @Override
    protected void _setup() {
      bg = r.i.transparent;

      for (String r : this.text) {
        add(r);
      }
    }
  }
}
