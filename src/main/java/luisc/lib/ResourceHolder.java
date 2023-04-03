package luisc.lib;

public abstract class ResourceHolder<T> {

  public BaseApp p;

  @SuppressWarnings("rawtypes")
  public Class<? extends ResourceHolder> _class;

  public ResourceHolder(BaseApp p) {
    this.p = p;
    this._class = this.getClass();

    load();
  }

  protected abstract void load();

  /**
   * Safely and dynamically get an asset with the given name
   *
   * @return null if an error occurred getting the asset
   */
  @SuppressWarnings("unchecked")
  public T getAsset(String name) {
    try {
      return (T) get(name);
    } catch (Exception e) {
      return null;
    }
  }

  public Object get(String k)
    throws IllegalAccessException, NoSuchFieldException {
    return (_class.getDeclaredField(k).get(this));
  }
}
