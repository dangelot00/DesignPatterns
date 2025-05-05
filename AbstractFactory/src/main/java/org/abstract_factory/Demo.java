package org.abstract_factory;


/**
 * The Abstract Factory Pattern
 * <p>
 * Abstract Factory defines an interface for creating all distinct products but leaves the actual product
 * creation to concrete factory classes. Each factory type corresponds to a certain product variety. <br><br>
 * The client code calls the creation methods of a factory object instead of creating products directly
 * with a constructor call (new operator). Since a factory corresponds to a single product variant, all
 * its products will be compatible. <br><br>
 * Client code works with factories and products only through their abstract interfaces.
 * This lets the client code work with any product variants, created by the factory object.
 * You just create a new concrete factory class and pass it to the client code. <br><br>
 * </p>
 **/
public class Demo {
  public static void main(String[] args) {
    System.out.println("Hello world!");
  }
}