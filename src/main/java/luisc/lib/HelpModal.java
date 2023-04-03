package luisc.lib;

import luisc.ucc.App;

public class HelpModal extends FullScreenModal {

  @Override
  protected void _setup() {
    img = r.i.tutorial;
  }

  public HelpModal(App a) {
    super(a);
  }
}
