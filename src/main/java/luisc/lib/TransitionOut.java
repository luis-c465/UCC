package luisc.lib;

import luisc.ucc.App;

public class TransitionOut extends Transition {

  public TransitionOut(App app) {
    super(app);
    starting_opacity = 255;
    opacity = starting_opacity;
    end_opacity = 0;
    up = false;
    step = 8;
  }
}
