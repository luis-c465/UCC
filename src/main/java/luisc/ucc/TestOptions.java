package luisc.ucc;

import luisc.ucc.dialogue.Options;

public class TestOptions extends Options {

  public TestOptions(App app) {
    super(app, new String[] { "Option 1", "Option 2", "Option 3" });
  }

  @Override
  protected void _update() {
    if (isClicked("Option 1")) {
      System.out.println("Option 1");
      a.mainScene.inCourt = false;
    } else if (isClicked("Option 2")) {
      System.out.println("Option 2");
    } else if (isClicked("Option 3")) {
      System.out.println("Option 3");
    }
  }
}
