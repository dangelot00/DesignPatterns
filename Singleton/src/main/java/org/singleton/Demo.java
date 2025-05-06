package org.singleton;

import org.singleton.instances.BillPughSingleton;
import org.singleton.instances.DoubleCheckedLockingSingleton;
import org.singleton.instances.EagerSingleton;
import org.singleton.instances.EnumSingleton;
import org.singleton.instances.StaticBlockSingleton;
import org.singleton.instances.SynchronizedMethodSingleton;

public final class Demo {

  private Demo() {
    super();
  }

  public static void main(String[] args) throws InterruptedException {
    System.out.println("Demonstrating various Singleton implementations in a multi-threaded environment.");
    System.out.println("For each type, two threads will attempt to get an instance.");
    System.out.println("If the hash codes printed by both threads for a given type are the same,");
    System.out.println("the Singleton is behaving correctly (returning the same instance).\n");

    testSingleton("EagerSingleton", new EagerSingletonRunnable(), new EagerSingletonRunnable());
    testSingleton("StaticBlockSingleton", new StaticBlockSingletonRunnable(), new StaticBlockSingletonRunnable());
    testSingleton("SynchronizedMethodSingleton", new SynchronizedMethodSingletonRunnable(), new SynchronizedMethodSingletonRunnable());
    testSingleton("DoubleCheckedLockingSingleton", new DoubleCheckedLockingSingletonRunnable(), new DoubleCheckedLockingSingletonRunnable());
    testSingleton("BillPughSingleton (Initialization-on-demand holder idiom)", new BillPughSingletonRunnable(), new BillPughSingletonRunnable());
    testSingleton("EnumSingleton", new EnumSingletonRunnable(), new EnumSingletonRunnable());

    System.out.println("All tests completed.");
  }

  private static void testSingleton(String name, Runnable r1, Runnable r2) throws InterruptedException {
    System.out.println("--- Testing " + name + " ---");
    Thread t1 = new Thread(r1);
    Thread t2 = new Thread(r2);

    t1.start();
    t2.start();

    t1.join();
    t2.join();
    System.out.println("--- Finished testing " + name + " ---\n");
  }

  static class EagerSingletonRunnable implements Runnable {
    @Override
    public void run() {
      EagerSingleton singleton = EagerSingleton.getInstance();
      System.out.println(Thread.currentThread().getName() + " - EagerSingleton Instance HashCode: " + singleton.hashCode());
    }
  }

  static class StaticBlockSingletonRunnable implements Runnable {
    @Override
    public void run() {
      StaticBlockSingleton singleton = StaticBlockSingleton.getInstance();
      System.out.println(Thread.currentThread().getName() + " - StaticBlockSingleton Instance HashCode: " + singleton.hashCode());
    }
  }

  static class SynchronizedMethodSingletonRunnable implements Runnable {
    @Override
    public void run() {
      SynchronizedMethodSingleton singleton = SynchronizedMethodSingleton.getInstance();
      System.out.println(Thread.currentThread().getName() + " - SynchronizedMethodSingleton Instance HashCode: " + singleton.hashCode());
    }
  }

  static class DoubleCheckedLockingSingletonRunnable implements Runnable {
    @Override
    public void run() {
      DoubleCheckedLockingSingleton singleton = DoubleCheckedLockingSingleton.getInstance();
      System.out.println(Thread.currentThread().getName() + " - DoubleCheckedLockingSingleton Instance HashCode: " + singleton.hashCode());
    }
  }

  static class BillPughSingletonRunnable implements Runnable {
    @Override
    public void run() {
      BillPughSingleton singleton = BillPughSingleton.getInstance();
      System.out.println(Thread.currentThread().getName() + " - BillPughSingleton Instance HashCode: " + singleton.hashCode());
    }
  }

  static class EnumSingletonRunnable implements Runnable {
    @Override
    public void run() {
      EnumSingleton singleton = EnumSingleton.INSTANCE;
      System.out.println(Thread.currentThread().getName() + " - EnumSingleton Instance HashCode: " + singleton.hashCode());
    }
  }
}