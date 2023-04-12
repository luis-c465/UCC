package luisc.resources;

import ddf.minim.AudioPlayer;
import luisc.lib.BaseApp;
import luisc.lib.ResourceHolder;

public class Sounds extends ResourceHolder<AudioPlayer> {

  public AudioPlayer scan;

  @Override
  protected void load() {
    scan = p.minim.loadFile("scan.mp3");
  }

  public Sounds(BaseApp p) {
    super(p);
  }
}
