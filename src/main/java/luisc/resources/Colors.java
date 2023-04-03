package luisc.resources;

import luisc.lib.BaseApp;
import luisc.lib.ResourceHolder;

public class Colors extends ResourceHolder<Integer> {

  // public static final int gray_100 = 0xfff7fafc;
  // public static final int gray_200 = 0xffedf2f7;
  // public static final int gray_300 = 0xffe2e8f0;
  // public static final int gray_400 = 0xffcbd5e0;
  // public static final int gray_500 = 0xffa0aec0;
  // public static final int gray_600 = 0xff718096;
  // public static final int gray_700 = 0xff4a5568;
  // public static final int gray_800 = 0xff2d3748;
  // public static final int gray_900 = 0xff1a202c;

  // public static final int red_100 = 0xfffff5f5;
  // public static final int red_200 = 0xfffed7d7;
  // public static final int red_300 = 0xfffeb2b2;
  // public static final int red_400 = 0xfffc8181;
  // public static final int red_500 = 0xfff56565;
  // public static final int red_600 = 0xff718096;
  // public static final int red_700 = 0xff4a5568;
  // public static final int red_800 = 0xff2d3748;
  // public static final int red_900 = 0xff1a202c;

  public static final int success = 0xff4ade80;
  public static final int error = 0xfff87171;
  public static final int gray = 0xff6b7280;
  public static final int selected = 0xff22d3ee;
  public static final int yellow = 0xfffbbf24;
  public static final int timer = 0xff81e087;

  @Override
  protected void load() {}

  public Colors(BaseApp p) {
    super(p);
  }
}
