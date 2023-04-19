package luisc.ucc.data;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.util.HashSet;
import java.util.Set;

/**
 * Class which stores the data to be saved
 */
@XStreamAlias("data")
public class Data extends BaseData {

  public Set<String> evidence = new HashSet<>();
  public Set<String> achievements = new HashSet<>();
  public int test = 0;
}
