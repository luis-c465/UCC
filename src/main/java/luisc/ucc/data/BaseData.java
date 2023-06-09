package luisc.ucc.data;

import java.lang.reflect.Field;
import luisc.ucc.App;

/**
 * Base class for the data classes
 *
 * Comes with methods to load and save the data
 */
public abstract class BaseData {

  public void load(App a) {
    try {
      copyFields(this, a);
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("Among us! there was an error loading the data");
    }
  }

  public void save(App a) {
    try {
      copyFields(a, this);
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("Among us! there was an saving the data");
    }
  }

  public static void copyFields(Object source, Object destination)
    throws IllegalArgumentException, IllegalAccessException {
    Field[] sourceFields = source.getClass().getDeclaredFields();
    for (Field sourceField : sourceFields) {
      sourceField.setAccessible(true);
      String fieldName = sourceField.getName();
      Field destinationField = null;
      try {
        destinationField = destination.getClass().getDeclaredField(fieldName);
      } catch (NoSuchFieldException e) {
        // Field does not exist in destination class, skip it
        System.out.println(
          "The field `" +
          fieldName +
          "` does not exist in the class " +
          destination.getClass().getName()
        );
        continue;
      }
      destinationField.setAccessible(true);
      Object value = sourceField.get(source);
      destinationField.set(destination, value);
    }
  }
}
