package org.abstract_factory.buttons.impl;

import org.abstract_factory.buttons.interfaces.Button;

/**
 * Represents a Windows variant of the Button.
 */
public class WindowsButton implements Button {

  @Override
  public void click() {
    System.out.println("You have clicked on WindowsButton");
  }
}
