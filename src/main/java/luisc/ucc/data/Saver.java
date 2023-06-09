package luisc.ucc.data;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.persistence.FilePersistenceStrategy;
import com.thoughtworks.xstream.persistence.PersistenceStrategy;
import com.thoughtworks.xstream.security.AnyTypePermission;
import java.io.File;
import java.util.List;
import luisc.ucc.App;

/**
 * Class which saves and loads the save data for the game
 */
public class Saver {

  public static final String name = "saveData";

  public XStream x = new XStream();

  public PersistenceStrategy strategy;
  public List<Data> saves;

  public App a;

  public int saveIndex = 0;

  public Saver(App a) {
    this.a = a;

    // Save the game when the app is closed
    a.registerMethod("dispose", this);

    x.processAnnotations(Data.class);
    x.addPermission(AnyTypePermission.ANY);
    x.allowTypesByRegExp(new String[] { ".*" });

    String folder = System.getProperty("user.home");
    folder += File.separator + ".luisc.sussy-justice";
    File customDir = new File(folder);

    if (customDir.exists()) {
      System.out.println(customDir + " already exists");
    } else if (customDir.mkdirs()) {
      System.out.println(customDir + " was created");
    } else {
      System.out.println(customDir + " was not created");
    }

    strategy = new FilePersistenceStrategy(new File(folder), x);
    saves = new XmlList<Data>(strategy);

    if (saves.size() == 0) {
      a.firstLoaded = true;
      saves.add(new Data());
    }

    load();
  }

  /**
   * Load the save at index i
   */
  public void load(int i) {
    saves.get(i).load(a);
  }

  /**
   * Loads the current save
   */
  public void load() {
    load(saveIndex);
  }

  /**
   * Save the current game state to the save at index i
   */
  public void save(int i) {
    Data temp = saves.get(i);
    temp.save(a);
    saves.set(i, temp);
  }

  /**
   * Saves the current game state to the current save
   */
  public void save() {
    save(saveIndex);
  }

  public void dispose() {
    save();
  }
}
