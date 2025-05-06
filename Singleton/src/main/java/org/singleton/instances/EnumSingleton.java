package org.singleton.instances;

public enum EnumSingleton {

  INSTANCE;

  EnumSingleton() {
    System.out.println("EnumSingleton instance created.");
  }

  public void showMessage() {
    System.out.println("Hello from EnumSingleton! Instance: " + this.hashCode());
  }
}
