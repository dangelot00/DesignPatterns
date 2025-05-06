package org.singleton.instances;

public final class DoubleCheckedLockingSingleton {

  private static volatile DoubleCheckedLockingSingleton instance;

  private DoubleCheckedLockingSingleton() {
    super();
    System.out.println("DoubleCheckedLockingSingleton instance created.");
  }

  public static DoubleCheckedLockingSingleton getInstance() {
    // First check (without lock)
    if (instance == null) {
      // Synchronize only the critical section
      synchronized (DoubleCheckedLockingSingleton.class) {
        // Second check (with lock)
        if (instance == null) {
          instance = new DoubleCheckedLockingSingleton();
        }
      }
    }
    return instance;
  }

  public void showMessage() {
    System.out.println("Hello from DoubleCheckedLockingSingleton!");
  }
}
