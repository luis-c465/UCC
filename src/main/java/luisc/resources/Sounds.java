package luisc.resources;

import ddf.minim.AudioPlayer;
import luisc.lib.BaseApp;
import luisc.lib.ResourceHolder;

public class Sounds extends ResourceHolder<AudioPlayer> {

  public AudioPlayer scan;
  public AudioPlayer vine;
  public AudioPlayer ltg;
  public AudioPlayer holdIt;
  public AudioPlayer metalPipe;
  public AudioPlayer peppino;
  public AudioPlayer fakePeppino;
  public AudioPlayer reactor;
  public AudioPlayer vent;
  public AudioPlayer emergency;
  public AudioPlayer music;

  @Override
  protected void load() {
    scan = p.minim.loadFile("scan.mp3");
    vine = p.minim.loadFile("vine.mp3");
    ltg = l("ltg.mp3");
    metalPipe = l("metal-pipe.mp3");

    holdIt = l("hold-it.mp3");

    peppino = l("peppino.mp3");
    fakePeppino = l("fake-peppino.mp3");
    reactor = l("reactor.mp3");
    vent = l("vent.mp3");
    emergency = l("emergency.mp3");
    music = l("between.mp3");
    music.setGain(-10);
    music.loop();
  }

  public AudioPlayer l(String name) {
    return p.minim.loadFile(name);
  }

  public Sounds(BaseApp p) {
    super(p);
  }
}
