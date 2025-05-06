package org.abstract_factory.checkboxes.impl;

import org.abstract_factory.checkboxes.interfaces.Checkbox;

/**
 * Represents a macOS variant of the Checkbox.
 */
public class MacOSCheckbox implements Checkbox {

  @Override
  public void toggle() {
    System.out.println("You have toggled a MacOSCheckbox");
  }
}
