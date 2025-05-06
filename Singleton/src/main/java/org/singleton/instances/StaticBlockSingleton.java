package org.singleton.instances;

public final class StaticBlockSingleton {

  private static final StaticBlockSingleton INSTANCE;

  private StaticBlockSingleton() {
    super();
    System.out.println("StaticBlockSingleton instance created.");
  }

  static {
    try {
      INSTANCE = new StaticBlockSingleton();
    } catch (Exception e) {
      throw new RuntimeException("Exception occurred in creating singleton instance", e);
    }
  }

  public static StaticBlockSingleton getInstance() {
    return INSTANCE;
  }

  public void showMessage() {
    System.out.println("Hello from StaticBlockSingleton!");
  }
}