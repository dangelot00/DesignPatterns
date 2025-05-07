package org.abstract_factory.app;

import org.abstract_factory.buttons.interfaces.Button;
import org.abstract_factory.checkboxes.interfaces.Checkbox;
import org.abstract_factory.factories.interfaces.GUIFactory;

/**
 * The User Application
 *
 * <p>Users interact with abstract factories.<br>
 * They just want to have buttons and checkboxes and interact with them.<br>
 * They can be unaware on the actual concrete factory that they are using.</p>
 *
 */
public class Application {
  private final Button button;
  private final Checkbox checkbox;

  public Application(GUIFactory factory) {
    super();

    button = factory.createButton();
    checkbox = factory.createCheckbox();
  }

  public void interact() {
    button.click();
    checkbox.toggle();
  }
}
