package luisc.ucc;

import luisc.lib.Obj;
import luisc.ucc.explore.CafeteriaExploration;
import luisc.ucc.explore.Exploration;

/**
 * Main scene class which well, plays the game
 */
public class MainScene extends Obj {

  public BabyFirstCase babyFirstCase;
  public FindingJesse findingJesse;
  public TheLunchBox theLunchBox;
  public MathClassroom mathClassroom;

  public Exploration exploration;

  @Override
  protected void _setup() {
    babyFirstCase = new BabyFirstCase(a);
    babyFirstCase.setup();

    findingJesse = new FindingJesse(a);
    findingJesse.setup();

    theLunchBox = new TheLunchBox(a);
    theLunchBox.setup();

    mathClassroom = new MathClassroom(a);
    mathClassroom.setup();

    exploration = new CafeteriaExploration(a);
    exploration.setup();
  }

  @Override
  protected void _update() {
    exploration.update();
    // if (!babyFirstCase.done) {
    //   babyFirstCase.update();
    // } else if (!findingJesse.done) {
    //   findingJesse.update();
    // } else if (!theLunchBox.done) {
    //   theLunchBox.update();
    // } else if (!mathClassroom.done) {
    //   mathClassroom.update();
    // }
  }

  public MainScene(App a) {
    super(a);
  }
}
