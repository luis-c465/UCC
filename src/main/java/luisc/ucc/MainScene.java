package luisc.ucc;

import luisc.lib.Obj;

/**
 * Main scene class which well, plays the game
 */
public class MainScene extends Obj {

  BabyFirstCase babyFirstCase;
  FindingJesse findingJesse;
  TheLunchBox theLunchBox;
  MathClassroom mathClassroom;

  CafeteriaExploration cafeteriaExploration;

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

    cafeteriaExploration = new CafeteriaExploration(a);
    cafeteriaExploration.setup();
  }

  @Override
  protected void _update() {
    cafeteriaExploration.update();
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
