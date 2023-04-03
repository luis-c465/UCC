package luisc.lib;

import luisc.ucc.App;

/**
 * Transitions in between 2 screens
 *
 * The update method should be called durring each draw for this to work
 */
public class TransitionIn extends Transition {

  public TransitionIn(App app) {
    super(app);
    starting_opacity = 0;
    opacity = starting_opacity;
    end_opacity = 255;
    up = true;
    step = 8;
  }
}
