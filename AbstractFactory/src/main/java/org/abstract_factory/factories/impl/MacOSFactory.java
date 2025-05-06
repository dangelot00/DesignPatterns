package org.abstract_factory.factories.impl;

import org.abstract_factory.buttons.impl.MacOSButton;
import org.abstract_factory.buttons.interfaces.Button;
import org.abstract_factory.checkboxes.impl.MacOSCheckbox;
import org.abstract_factory.checkboxes.interfaces.Checkbox;
import org.abstract_factory.factories.interfaces.GUIFactory;

/**
 * Represents the concrete MacOSFactory
 * <p>
 * The MacOSFactory is responsible for creating all of the macOS products
 * </p>
 */
public class MacOSFactory implements GUIFactory {

  @Override
  public Button createButton() {
    return new MacOSButton();
  }

  @Override
  public Checkbox createCheckbox() {
    return new MacOSCheckbox();
  }
}
