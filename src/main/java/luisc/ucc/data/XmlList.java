package luisc.ucc.data;

import com.thoughtworks.xstream.persistence.PersistenceStrategy;
import java.util.AbstractList;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Set;

/*
 * Modified XmlArrayList class which uses generics
 */

/**
 * A persistent list implementation backed on a XmlMap.
 *
 * @author Guilherme Silveira
 */
@SuppressWarnings("all")
public class XmlList<T> extends AbstractList<T> {

  private final XmlMap<Integer, T> map;

  public XmlList(PersistenceStrategy persistenceStrategy) {
    this.map = new XmlMap(persistenceStrategy);
  }

  public int size() {
    return map.size();
  }

  public T set(int index, T element) {
    rangeCheck(index);
    T value = get(index);
    map.put(new Integer(index), element);
    return value;
  }

  public void add(int index, T element) {
    int size = size();
    if (index >= (size + 1) || index < 0) {
      throw new IndexOutOfBoundsException(
        "Index: " + index + ", Size: " + size
      );
    }
    int to = index != size ? index - 1 : index;
    for (int i = size; i > to; i--) {
      map.put(new Integer(i + 1), map.get(new Integer(i)));
    }
    map.put(new Integer(index), element);
  }

  private void rangeCheck(int index) {
    int size = size();
    if (index >= size || index < 0) {
      throw new IndexOutOfBoundsException(
        "Index: " + index + ", Size: " + size
      );
    }
  }

  public T get(int index) {
    rangeCheck(index);
    return map.get(new Integer(index));
  }

  public T remove(int index) {
    int size = size();
    rangeCheck(index);
    T value = map.get(new Integer(index));
    for (int i = index; i < size - 1; i++) {
      map.put(new Integer(i), map.get(new Integer(i + 1)));
    }
    map.remove(new Integer(size - 1));
    return value;
  }

  private class XmlMap<K, V> extends AbstractMap<K, V> {

    private final PersistenceStrategy persistenceStrategy;

    public XmlMap(PersistenceStrategy streamStrategy) {
      this.persistenceStrategy = streamStrategy;
    }

    public int size() {
      return persistenceStrategy.size();
    }

    public V get(Object key) {
      // faster lookup
      return (V) persistenceStrategy.get(key);
    }

    public V put(K key, V value) {
      return (V) persistenceStrategy.put(key, value);
    }

    public V remove(Object key) {
      return (V) persistenceStrategy.remove(key);
    }

    public Set entrySet() {
      return new XmlMapEntries();
    }

    class XmlMapEntries extends AbstractSet {

      public int size() {
        return XmlMap.this.size();
      }

      public boolean isEmpty() {
        return XmlMap.this.isEmpty();
      }

      public Iterator iterator() {
        return persistenceStrategy.iterator();
      }
    }
  }
}
