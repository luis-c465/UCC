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

  public PImage medical;
  public PImage medicalCrying;
  public PImage medicalLigma;
  public PImage medicalThinking;
  public PImage medicalThumbsUp;
  public PImage medicalWorried;
  public PImage medicalPointing;

  public PImage medic;
  public PImage navigator;
  public PImage communicator;

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

    gunner = p.loadImage("medical/default.png");
    medicalCrying = p.loadImage("medical/crying.png");
    medicalLigma = p.loadImage("medical/ligma.png");
    medicalThinking = p.loadImage("medical/thinking.png");
    medicalThumbsUp = p.loadImage("medical/thumbs-up.png");
    medicalWorried = p.loadImage("medical/worried.png");
    medicalPointing = p.loadImage("medical/pointing.png");

    Gif temp = new Gif(p, "lta.gif");
    temp.play();
    lta = temp;

    navigator = p.loadImage("gamer.png");
    communicator = p.loadImage("gamer.png");
  }

  public Characters(BaseApp p) {
    super(p);
  }
}
