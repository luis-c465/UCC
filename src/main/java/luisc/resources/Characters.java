package luisc.resources;

import gifAnimation.Gif;
import luisc.lib.BaseApp;
import luisc.lib.ResourceHolder;
import processing.core.PImage;

public class Characters extends ResourceHolder<PImage> {

  public PImage lta;

  public PImage mc;
  public PImage mcCrying;
  public PImage mcLigma;
  public PImage mcThinking;
  public PImage mcThumbsUp;
  public PImage mcWorried;
  public PImage mcPointing;

  public PImage engineer;
  public PImage engineerCrying;
  public PImage engineerLigma;
  public PImage engineerThinking;
  public PImage engineerThumbsUp;
  public PImage engineerWorried;

  public PImage gunner;
  public PImage gunnerCrying;
  public PImage gunnerLigma;
  public PImage gunnerThinking;
  public PImage gunnerThumbsUp;
  public PImage gunnerWorried;
  public PImage gunnerPointing;
  public PImage gunnerChad;

  public PImage medic;
  public PImage medicCrying;
  public PImage medicLigma;
  public PImage medicThinking;
  public PImage medicThumbsUp;
  public PImage medicWorried;
  public PImage medicPointing;

  public PImage communicator;
  public PImage communicatorCrying;
  public PImage communicatorLigma;
  public PImage communicatorThinking;
  public PImage communicatorThumbsUp;
  public PImage communicatorWorried;
  public PImage communicatorPointing;

  public PImage navigator;
  public PImage navigatorCrying;
  public PImage navigatorLigma;
  public PImage navigatorThinking;
  public PImage navigatorThumbsUp;
  public PImage navigatorWorried;
  public PImage navigatorPointing;

  @Override
  protected void load() {
    mc = p.loadImage("mc/default.png");
    mcCrying = p.loadImage("mc/crying.png");
    mcLigma = p.loadImage("mc/ligma.png");
    mcThinking = p.loadImage("mc/thinking.png");
    mcThumbsUp = p.loadImage("mc/thumbs-up.png");
    mcWorried = p.loadImage("mc/worried.png");
    mcPointing = p.loadImage("mc/pointing.png");

    engineer = p.loadImage("engineer/default.png");
    engineerCrying = p.loadImage("engineer/crying.png");
    engineerLigma = p.loadImage("engineer/ligma.png");
    engineerThinking = p.loadImage("engineer/thinking.png");
    engineerThumbsUp = p.loadImage("engineer/thumbs-up.png");
    engineerWorried = p.loadImage("engineer/worried.png");

    gunner = p.loadImage("gunner/default.png");
    gunnerCrying = p.loadImage("gunner/crying.png");
    gunnerLigma = p.loadImage("gunner/ligma.png");
    gunnerThinking = p.loadImage("gunner/thinking.png");
    gunnerThumbsUp = p.loadImage("gunner/thumbs-up.png");
    gunnerWorried = p.loadImage("gunner/worried.png");
    gunnerPointing = p.loadImage("gunner/pointing.png");
    gunnerChad = p.loadImage("gunner/chad.png");

    medic = p.loadImage("medical/default.png");
    medicCrying = p.loadImage("medical/crying.png");
    medicLigma = p.loadImage("medical/ligma.png");
    medicThinking = p.loadImage("medical/thinking.png");
    medicThumbsUp = p.loadImage("medical/thumbs-up.png");
    medicWorried = p.loadImage("medical/worried.png");
    medicPointing = p.loadImage("medical/pointing.png");

    communicator = p.loadImage("communicator/default.png");
    communicatorCrying = p.loadImage("communicator/crying.png");
    communicatorLigma = p.loadImage("communicator/ligma.png");
    communicatorThinking = p.loadImage("communicator/thinking.png");
    communicatorThumbsUp = p.loadImage("communicator/thumbs-up.png");
    communicatorWorried = p.loadImage("communicator/worried.png");
    communicatorPointing = p.loadImage("communicator/pointing.png");

    navigator = p.loadImage("navigator/default.png");
    navigatorCrying = p.loadImage("navigator/crying.png");
    navigatorLigma = p.loadImage("navigator/ligma.png");
    navigatorThinking = p.loadImage("navigator/thinking.png");
    navigatorThumbsUp = p.loadImage("navigator/thumbs-up.png");
    navigatorWorried = p.loadImage("navigator/worried.png");
    navigatorPointing = p.loadImage("navigator/pointing.png");

    Gif temp = new Gif(p, "lta.gif");
    temp.play();
    lta = temp;
  }

  public Characters(BaseApp p) {
    super(p);
  }
}
