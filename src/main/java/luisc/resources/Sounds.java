package luisc.resources;

import ddf.minim.AudioPlayer;
import luisc.lib.BaseApp;
import luisc.lib.ResourceHolder;

public class Sounds extends ResourceHolder<AudioPlayer> {

  public AudioPlayer scan;
  public AudioPlayer vine;
  public AudioPlayer ltg;

  @Override
  protected void load() {
    scan = p.minim.loadFile("scan.mp3");
    vine = p.minim.loadFile("vine.mp3");
    ltg = l("ltg.mp3");
  }

  public AudioPlayer l(String name) {
    return p.minim.loadFile(name);
  }

  public Sounds(BaseApp p) {
    super(p);
  }
}
