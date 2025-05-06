package org.singleton.instances;

public final class BillPughSingleton {

  private BillPughSingleton() {
    super();
    System.out.println("BillPughSingleton instance created.");
  }

  // Private static inner class that contains the instance of the singleton class.
  // This class is not loaded into memory and the instance is not created until
  // getInstance() is called.
  private static class SingletonHelper {
    private static final BillPughSingleton INSTANCE = new BillPughSingleton();
  }

  public static BillPughSingleton getInstance() {
    return SingletonHelper.INSTANCE;
  }

  public void showMessage() {
    System.out.println("Hello from BillPughSingleton!");
  }
}