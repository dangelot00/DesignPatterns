package org.singleton.instances;

public final class EagerSingleton {

  private static final EagerSingleton INSTANCE = new EagerSingleton();

  private EagerSingleton() {
    super();
    System.out.println("EagerSingleton instance created.");
  }

  public static EagerSingleton getInstance() {
    return INSTANCE;
  }

  public void showMessage() {
    System.out.println("Hello from EagerSingleton!");
  }
}