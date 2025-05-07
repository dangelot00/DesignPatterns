package org.abstract_factory.factories.interfaces;

import org.abstract_factory.buttons.interfaces.Button;
import org.abstract_factory.checkboxes.interfaces.Checkbox;

/**
 * Represents the abstract GUIFactory
 * <p>
 * The Abstract Factory knows all about the (abstract) products types
 * </p>
 */
public interface GUIFactory {

  Button createButton();

  Checkbox createCheckbox();
}