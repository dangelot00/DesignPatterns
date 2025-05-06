package org.abstract_factory.factories.impl;

import org.abstract_factory.buttons.impl.WindowsButton;
import org.abstract_factory.buttons.interfaces.Button;
import org.abstract_factory.checkboxes.impl.WindowsCheckbox;
import org.abstract_factory.checkboxes.interfaces.Checkbox;
import org.abstract_factory.factories.interfaces.GUIFactory;

/**
 * Represents the concrete WindowsFactory
 * <p>
 * The WindowsFactory is responsible for creating all of the Windows products
 * </p>
 */
public class WindowsFactory implements GUIFactory {

  @Override
  public Button createButton() {
    return new WindowsButton();
  }

  @Override
  public Checkbox createCheckbox() {
    return new WindowsCheckbox();
  }
}
