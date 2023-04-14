package luisc.ucc.court;

import luisc.lib.Obj;
import luisc.ucc.App;
import luisc.ucc.TestOptions;

public class Court extends Obj {

  public TestOptions options;

  public Court(App app) {
    super(app);
  }

  @Override
  protected void _setup() {
    options = new TestOptions(a);
    options.setup();
  }

  @Override
  protected void _update() {
    options.update();
  }
}
