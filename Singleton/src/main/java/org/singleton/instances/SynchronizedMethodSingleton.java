package org.singleton.instances;

public final class SynchronizedMethodSingleton {

  private static SynchronizedMethodSingleton instance;

  private SynchronizedMethodSingleton() {
    super();
    System.out.println("SynchronizedMethodSingleton instance created.");
  }

  public static synchronized SynchronizedMethodSingleton getInstance() {
    if (instance == null) {
      instance = new SynchronizedMethodSingleton();
    }
    return instance;
  }

  public void showMessage() {
    System.out.println("Hello from SynchronizedMethodSingleton!");
  }
}
