package org.abstract_factory.buttons.impl;

/**
 * Represents a macOS variant of the Button.
 */
public class MacOSButton implements org.abstract_factory.buttons.interfaces.Button {

  @Override
  public void click() {
    System.out.println("You have clicked on MacOSButton");
  }
}